package ru.bobreogen.lab4;

import ru.bobreogen.lab2.Credentials;
import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;
import ru.bobreogen.lab2.ShoppingCart;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OrderCreator extends TimerTask {

    private Orders<Order> ord;

    public OrderCreator(Orders<Order> orders, int period){

        this.ord = orders;
        Timer timer = new Timer(true);

        if(period > 0) {
            timer.scheduleAtFixedRate(this, 0, period);
        }
    }

    public synchronized void create(){
        Credentials cr = new Credentials();
        cr.create();
        System.out.println("Order " + cr.getId() + " is create");
        ord.makeAPurchase(new Order(),(new ShoppingCart()).CreateRandom(), cr, (new Random()).nextInt(20000));
    }

    @Override
    public void run(){
        create();
    }
}
