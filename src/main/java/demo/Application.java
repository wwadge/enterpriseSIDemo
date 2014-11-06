package demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
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


        PollableChannel channel = new QueueChannel();
        channel.send(msg);

        // somewhere else....
        Message<?> msg2 = channel.receive();
        log.debug(msg2.toString());




//        SpringApplication.run(Application.class, args);
    }
}
