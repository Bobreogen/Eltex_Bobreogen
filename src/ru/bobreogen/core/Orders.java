package ru.bobreogen.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Date;

public class Orders extends LinkedList {

    static Orders orders = new Orders();

    public static void makeAPurchase(ShoppingCart cart, Credentials credentials, long time){
        Order order = new Order(cart, credentials, time);
        orders.add(order);
    }

    public static void Check(){
        Iterator<Order> i = orders.iterator();
        while(i.hasNext()){
            Order order = i.next();
            if(order.timeCreate + order.timeWait > (new Date()).getTime() && order.statusOrder){
                i.remove();
            }
        }
    }

    public static void showAll(){
        Iterator<Order> i = orders.iterator();
        while(i.hasNext()){
            Order order = i.next();
            System.out.println(order.credentials.id);
            order.cart.showAll();
        }
    }
}
