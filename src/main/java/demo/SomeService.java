package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

/**
 * Created by wwadge on 06/11/14.
 */
@Component
public class SomeService {

    @Autowired
    @Qualifier("exampleChannel")
    MessageChannel channel;

    public void run(){
        channel.send(new GenericMessage<>("5"));
    }
}
