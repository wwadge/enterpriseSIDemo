package demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by wwadge on 06/11/14.
 */
@Component
@Slf4j
public class SomeService {

    public void runString(Message<?> msg){
        log.info("Invoked String via Spring integration : "+msg.toString());
    }

    public void runInteger(Message<?> msg){
        log.info("Invoked Integer via Spring integration : "+msg.toString());
    }

    public Integer foo(){
        return 1;
    }
}
