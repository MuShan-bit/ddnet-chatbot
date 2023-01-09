package xyz.mushan.simple2.utils;

import lombok.extern.slf4j.Slf4j;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.message.events.PrivateMsg;

/**
 * @author mushan
 * @date 2022/12/30
 * @apiNote
 */
@Slf4j
public class LogUtil {
    public static void sendPrivateListenLog(PrivateMsg msg, String result){
        log.info("接收消息~~" + msg.getAccountInfo().getAccountNickname()
                + ": " + msg.getText());
        log.info("回复消息~~" + result);
    }
    public static void sendGroupListenLog(GroupMsg msg, String result){
        log.info("接收消息~~" + msg.getAccountInfo().getAccountNickname()
                + ": " + msg.getText());
        log.info("回复消息~~" + result);
    }
}
