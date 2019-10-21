package ru.bobreogen.lab2;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
public class Orders<T extends Order> {

    private LinkedList<T> orders = new LinkedList<>();
    private HashMap<Long, T> times = new HashMap<>();

    public void add(T t){
        orders.add(t);
    }

    public void makeAPurchase(T t, ShoppingCart cart, Credentials credentials, long time){
        t.setStatusOrder(false);
        t.setCart(cart);
        t.setCredentials(credentials);
        t.setTimeWait(time);
        orders.add(t);
        times.put(t.getTimeCreate(), t);
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

    public LinkedList<T> getList(){
        return orders;
    }

    public void Check(){
        Iterator<T> i = orders.iterator();
        while(i.hasNext()){
            Order order = i.next();
            if(order.getTimeCreate() + order.getTimeWait() > System.currentTimeMillis() && order.isStatusOrder()){
                System.out.println("Some order has been deleted");
                i.remove();
            }
        }
    }

    public void showAll(){
        for (T order : orders) {
            System.out.println(order.getCredentials().getId());
            order.getCart().showAll();
        }
    }
}
