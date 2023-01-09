package xyz.mushan.simple2;

import lombok.extern.slf4j.Slf4j;
import love.forte.common.configuration.Configuration;
import love.forte.simbot.api.sender.BotSender;
import love.forte.simbot.bot.Bot;
import love.forte.simbot.core.SimbotContext;
import love.forte.simbot.core.SimbotProcess;
import love.forte.simbot.spring.autoconfigure.EnableSimbot;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@EnableSimbot
@EnableScheduling
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Slf4j
public class Simple2Application {

    public static void main(String[] args) {
        SpringApplication.run(Simple2Application.class, args);
        log.info("启动成功------------");
    }
}
