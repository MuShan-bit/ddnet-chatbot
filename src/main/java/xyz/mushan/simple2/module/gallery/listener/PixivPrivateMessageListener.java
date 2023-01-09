package xyz.mushan.simple2.module.gallery.listener;

import catcode.CatCodeUtil;
import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.OnPrivate;
import love.forte.simbot.api.message.events.MessageGet;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.filter.MatchType;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xyz.mushan.simple2.module.gallery.entity.po.PixivImageData;
import xyz.mushan.simple2.module.gallery.service.PixivService;
import xyz.mushan.simple2.utils.LogUtil;

import java.util.Set;

/**
 * @author mushan
 * @date 2022/12/31
 * @apiNote
 */
@Component
public class PixivPrivateMessageListener {
    @Autowired
    PixivService pixivService;
    @Value("${robot.vip}")
    private Set<String> vip;
    @Value("${robot.master.qq}")
    private String master;

    @OnPrivate
    @Filter(value = "色图", matchType = MatchType.CONTAINS)
    @Filter(value = "涩图", matchType = MatchType.CONTAINS)
    public void randomImage(PrivateMsg msg, MsgSender sender){
        boolean b = vip.stream().anyMatch(e -> {
            return !e.equals(msg.getAccountInfo().getAccountCode());
        });
        if(b){
            sender.SENDER.sendPrivateMsg(msg, "对不起，您不是vip，无法使用此功能！\n获取vip请联系我的master：" + master);
            return;
        }
        try{
            PixivImageData imageData = pixivService.getImage();
            String result = CatCodeUtil.INSTANCE.getStringCodeBuilder("image",
                    false).key("url").value(imageData.getUrls().getOriginal()).build();
            LogUtil.sendPrivateListenLog(msg, result);
            sender.SENDER.sendPrivateMsg(msg, result);
        } catch (Exception e){
            e.printStackTrace();
            sender.SENDER.sendPrivateMsg(msg, "😢获取失败！可能是网络异常导致，请联系管理员维护");
        }
    }
}
