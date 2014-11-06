package demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
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


        // 1-to-n, same thread
        PublishSubscribeChannel channel = new PublishSubscribeChannel();

        // somewhere else....
        channel.subscribe(message -> log.debug(message.toString()));
        channel.subscribe(message -> log.debug("Hey there, I'm also called"));

        channel.addInterceptor(new ChannelInterceptorAdapter() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                log.debug("About to send");
                return super.preSend(message, channel);
            }
        });

        channel.send(msg);



//        SpringApplication.run(Application.class, args);
    }
}
