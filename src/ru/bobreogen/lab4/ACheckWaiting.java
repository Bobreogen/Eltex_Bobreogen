package ru.bobreogen.lab4;

import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;

public class ACheckWaiting extends ACheck {

    public ACheckWaiting(Orders<Order> orders){
        super(orders);
    }

    public ACheckWaiting(Orders<Order> orders, int periodSeconds){
        super(orders, periodSeconds);
    }

    @Override
    synchronized void check(Orders<Order> orders) {
            Order order;
            int ID;
            for (int i = 0; i < orders.size(); i++) {
                order = orders.get(i);
                if (!order.isStatusOrder()) {
                    ID = order.getID();
                    order.setStatusOrder(true);
                    System.out.println("Order " + ID + " is processed.");
                }
            }
    }
}
