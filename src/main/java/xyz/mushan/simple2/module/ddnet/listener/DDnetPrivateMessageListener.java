package xyz.mushan.simple2.module.ddnet.listener;

import catcode.CatCodeUtil;
import catcode.CodeBuilder;
import lombok.extern.slf4j.Slf4j;
import love.forte.simbot.annotation.*;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.core.SimbotContext;
import love.forte.simbot.filter.MatchType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xyz.mushan.simple2.manage.DDnetWorkMange;
import xyz.mushan.simple2.module.ddnet.service.DDnetService;
import xyz.mushan.simple2.module.ddnet.utils.DDnetMessageBuilder;
import xyz.mushan.simple2.utils.LogUtil;

import java.io.IOException;
import java.util.Set;

/**
 * @author mushan
 * @date 2022/12/30
 * @apiNote
 */
@Slf4j
@Component
public class DDnetPrivateMessageListener {
    @Value("${robot.master.qq}")
    private Set<String> master;
    @Value("${robot.admin}")
    private Set<String> admin;
    @Value("${robot.ddnet.work.points}")
    private Boolean isPoints;

    @Autowired
    DDnetService dDnetService;

    private static final Logger LOG = LoggerFactory.getLogger(DDnetPrivateMessageListener.class);
    /**
     * ddnet 功能列表
     * @param msg
     * @param sender
     */
    @OnPrivate
    @Filter(value = "ddnet", matchType = MatchType.CONTAINS)
    public void workList(PrivateMsg msg, MsgSender sender){
        String result = "❤️DDnet 功能列表❤️\n" +
                "1. dd查分\n" +
                "2. dd搜图\n" +
                "3. dd排行\n" +
                "4. dd皮肤";
        LogUtil.sendPrivateListenLog(msg, result);
        sender.SENDER.sendPrivateMsg(msg.getAccountInfo(), result);
    }

    @OnPrivate
    @Filter(value = "dd查分", matchType = MatchType.STARTS_WITH)
    public void queryPoints(PrivateMsg msg, MsgSender sender, SimbotContext context){
        if(!isPoints){
            sender.SENDER.sendPrivateMsg(msg, "dd查分功能，当前处于关闭状态，请联系管理员开启。");
            sender.SENDER.sendPrivateMsg(msg, "❤️管理员列表❤️\n" +
                    admin.toString());
            return;
        }
        try{
            String text = msg.getText();
            String[] s = text.split(" ");
            StringBuilder result = new StringBuilder();
            String at = CatCodeUtil.INSTANCE.getStringCodeBuilder("at", true).key("code").value(msg.getAccountInfo().getAccountCode()).build();
            if(s.length == 2 && "dd查分".equals(s[0])){
                Long points = dDnetService.queryPoints(s[1]);
                result.append(at).append("，").append(s[1]).append("的分数为：").append(points);
                result.append(DDnetMessageBuilder.queryPoints(points));
            }else{
                result.append(at).append("，如果您想要查询分数，请输入以下格式：\n\ndd查分 名字");
            }
            LogUtil.sendPrivateListenLog(msg, result.toString());
            sender.SENDER.sendPrivateMsg(msg.getAccountInfo(), result.toString());
        }catch (Exception e){
            e.printStackTrace();
            sender.SENDER.sendPrivateMsg(msg.getAccountInfo(), "获取失败！可能是服务器正在维护~~。请联系管理员修复哦❤️\n" +
                    "管理员qq：" + master);
        }
    }

    @OnPrivate
    @Filter(value = "关闭dd查分")
    public void shutDDQueryPoints(PrivateMsg msg, MsgSender sender, SimbotContext context) {
        if(!isPoints){
            sender.SENDER.sendPrivateMsg(msg, "dd查分功能，已经处于关闭状态，无需修改");
            return;
        }
        try{
            boolean b = admin.stream().anyMatch(e -> {
                return !e.equals(msg.getAccountInfo().getAccountCode());
            });
            if(!b){
                DDnetWorkMange.updateQueryPoints(false);
                sender.SENDER.sendPrivateMsg(msg, "✅关闭成功");
            }else{
                sender.SENDER.sendPrivateMsg(msg, "对不起，您不是管理员，无法使用此指令！");
            }
        }catch (Exception e){
            e.printStackTrace();
            sender.SENDER.sendPrivateMsg(msg, "❌关闭失败！程序异常");
        }
    }


    @OnPrivate
    @Filter(value = "开启dd查分")
    public void openDDQueryPoints(PrivateMsg msg, MsgSender sender, SimbotContext context) {
        if(isPoints){
            sender.SENDER.sendPrivateMsg(msg, "dd查分功能，已经处于开启状态，无需修改");
            return;
        }
        try{
            boolean b = admin.stream().anyMatch(e -> {
                return !e.equals(msg.getAccountInfo().getAccountCode());
            });
            if(!b){
                DDnetWorkMange.updateQueryPoints(true);
                sender.SENDER.sendPrivateMsg(msg, "✅开启成功");
            }else{
                sender.SENDER.sendPrivateMsg(msg, "对不起，您不是管理员，无法使用此指令！");
            }
        }catch (Exception e){
            e.printStackTrace();
            sender.SENDER.sendPrivateMsg(msg, "❌开启失败！程序异常");
        }
    }
}
