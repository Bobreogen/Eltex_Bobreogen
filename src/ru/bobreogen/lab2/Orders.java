package ru.bobreogen.lab2;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
public class Orders {

    LinkedList<Order> orders = new LinkedList<>();
    HashMap<Long, Order> times = new HashMap<>();

    public void makeAPurchase(ShoppingCart cart, Credentials credentials, long time){
        Order order = new Order(cart, credentials, time);
        orders.add(order);
        times.put(order.timeCreate, order);
    }

    public void Check(){
        Iterator<Order> i = orders.iterator();
        while(i.hasNext()){
            Order order = i.next();
            if(order.timeCreate + order.timeWait > System.currentTimeMillis() && order.statusOrder){
                System.out.println("Some order has been deleted");
                i.remove();
            }
        }
    }

    public void showAll(){
        for (Order order : orders) {
            System.out.println(order.credentials.getId());
            order.cart.showAll();
        }
    }
}
