package xyz.mushan.simple2;

import love.forte.simbot.spring.autoconfigure.EnableSimbot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableSimbot
@EnableScheduling
@SpringBootApplication
public class Simple2Application {

    public static void main(String[] args) {
        SpringApplication.run(Simple2Application.class, args);
    }

}
