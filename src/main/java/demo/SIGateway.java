package demo;

import org.springframework.integration.annotation.Gateway;

/**
 * Created by wwadge on 06/11/14.
 */

public interface SIGateway {


    @Gateway(requestChannel = "input")
    void toConsole(String order);

}
