package xyz.mushan.simple2.module.gallery.listener;

import love.forte.simbot.annotation.Filter;
import love.forte.simbot.annotation.OnPrivate;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.MsgSender;
import love.forte.simbot.filter.MatchType;
import org.springframework.stereotype.Component;
import xyz.mushan.simple2.utils.LogUtil;

/**
 * @author mushan
 * @date 2022/12/31
 * @apiNote
 */
@Component
public class GalleryPrivateMessageListener {
    @OnPrivate
    @Filter(value = "图库", matchType = MatchType.CONTAINS)
    public void workList(PrivateMsg msg, MsgSender sender){
        String result = "❤️图库 功能列表❤️\n" +
                "1. 获取色图\n" +
                "2. 获取壁纸\n" +
                "3. 获取cos\n" +
                "4. 获取表情";
        LogUtil.sendPrivateListenLog(msg, result);
        sender.SENDER.sendPrivateMsg(msg.getAccountInfo(), result);
    }
}
