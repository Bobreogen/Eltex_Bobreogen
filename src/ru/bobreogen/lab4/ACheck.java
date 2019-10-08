package ru.bobreogen.lab4;

import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public abstract class ACheck extends TimerTask {
    private Orders<Order> orders;
    private Timer timer = null;
    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

    public ACheck(Orders<Order> orders){
        this.orders = orders;
    }

    public ACheck(Orders<Order> orders, int period) {
        this.orders = orders;

        timer = new Timer(true);

        if(period > 0) {
            executorService.scheduleAtFixedRate(this, 0, period, TimeUnit.MILLISECONDS);
        }
    }

    abstract void check(Orders<Order> orders);

    //Для старта в отдельном потоке необходимо запускать этот метод
    public void startCheck() {
        executorService.schedule(this, 0, TimeUnit.MILLISECONDS);;
    }

    @Override
    public void run() {
        check(orders);
    }
}
