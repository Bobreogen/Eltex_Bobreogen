package ru.bobreogen.lab4;

import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public abstract class ACheck extends TimerTask {
    private Orders<Order> orders;
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

    ACheck(Orders<Order> orders){
        this.orders = orders;
    }

    ACheck(Orders<Order> orders, int period) {
        this.orders = orders;

        if(period > 0) {
            executorService.scheduleAtFixedRate(this, 0, period, TimeUnit.MILLISECONDS);
        }
    }

    abstract void check(Orders<Order> orders);

    public void startCheck() {
        executorService.schedule(this, 0, TimeUnit.MILLISECONDS);;
    }

    @Override
    public void run() {
        check(orders);
    }
}
