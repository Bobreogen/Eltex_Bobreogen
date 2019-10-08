package ru.bobreogen.lab4;

import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;

public class ACheckProcessed extends ACheck {

    public ACheckProcessed(Orders<Order> orders){
        super(orders);
    }

    public ACheckProcessed(Orders<Order> orders, int periodSeconds){
        super(orders, periodSeconds);
    }

    @Override
    void check(Orders<Order> orders) {
        synchronized(this) {
            Order order;
            int ID;
            for (int i = 0; i < orders.size(); i++) {
                order = orders.get(i);
                if (order.isStatusOrder()) {
                    ID = order.getCrID();
                    orders.delete(i);
                    System.out.println("Order " + ID + " is deleted.");
                }
            }
        }
    }
}
