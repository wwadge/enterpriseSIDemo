package demo;

/**
 * Created by wwadge on 06/11/14.
 */
public interface SIGateway {

//    @Gateway(requestChannel="orders") - optional if you want to define additional items
    void placeOrder(String order);
}
