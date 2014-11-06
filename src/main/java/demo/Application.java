package demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Slf4j
public class Application {

    public static void main(String[] args) {

        // Manual message construction
        Message<String> msg =  MessageBuilder.withPayload("Hello World!").setHeader("Name", "Wallace").build();
        log.debug(msg.toString());


        // 1-to-1, same thread
        SubscribableChannel channel = new DirectChannel();

        // somewhere else....
        channel.subscribe(message -> log.debug(message.toString()));

        channel.send(msg);

//        SpringApplication.run(Application.class, args);
    }
}
