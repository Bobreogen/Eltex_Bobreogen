package ru.bobreogen.lab2;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
public class Orders<T extends Order> {

    private LinkedList<Order> orders = new LinkedList<>();
    private HashMap<Long, Order> times = new HashMap<>();

    public void makeAPurchase(ShoppingCart cart, Credentials credentials, long time){
        Order order = new Order(cart, credentials, time);
        orders.add(order);
        times.put(order.getTimeCreate(), order);
    }

    public Order get(int index){
        return orders.get(index);
    }

    public int size(){
        return orders.size();
    }

    public void delete(int index){
        orders.remove(index);
    }

    public LinkedList<Order> getList(){
        return orders;
    }

    public void Check(){
        Iterator<Order> i = orders.iterator();
        while(i.hasNext()){
            Order order = i.next();
            if(order.getTimeCreate() + order.getTimeWait() > System.currentTimeMillis() && order.isStatusOrder()){
                System.out.println("Some order has been deleted");
                i.remove();
            }
        }
    }

    public void showAll(){
        for (Order order : orders) {
            System.out.println(order.getCredentials().getId());
            order.getCart().showAll();
        }
    }
}
