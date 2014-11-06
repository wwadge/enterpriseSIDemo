package demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.Executors;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Slf4j
public class Application {

    public static void main(String[] args) {

        // Manual message construction
        Message<String> msg =  MessageBuilder.withPayload("Hello World!").setHeader("Name", "Wallace").build();
        log.debug(msg.toString());


        // 1-to-n, same thread
        SubscribableChannel channel = new ExecutorChannel(Executors.newSingleThreadExecutor());

        // somewhere else....
        channel.subscribe(message -> log.debug(Thread.currentThread() + " : " + message.toString()));
        channel.subscribe(message -> log.debug(Thread.currentThread() + ": Hey there, I'm also called"));

        log.debug("Sender thread ID : " + Thread.currentThread());
        channel.send(msg);

//        SpringApplication.run(Application.class, args);
    }
}
