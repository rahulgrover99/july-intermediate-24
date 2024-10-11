package designpatterns.observer;

import java.util.List;

public class OrderService {

    private final List<OrderObserver> observerList;

    public OrderService(List<OrderObserver> observerList) {
        this.observerList = observerList;
    }

    void getOrder(int id) {
        System.out.println("Getting order.");
    }

    void amendOrder(int id) {
        System.out.println("updating order");
    }

    void placeOrder(int id) {
        System.out.println("Order placed");
        observerList.forEach(orderObserver -> orderObserver.onOrderPlace(id));
    }


}
