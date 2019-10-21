package ru.bobreogen.lab2;

import java.io.Serializable;
import java.util.UUID;

public class Order implements Serializable {
    private boolean statusOrder = false; //false - в ожидании, true - выполнен
    private long timeCreate = System.currentTimeMillis();
    private long timeWait = 0;
    private int id;
    private ShoppingCart cart;
    private Credentials credentials;


    public Order(){
        id = UUID.randomUUID().hashCode();
    }

    Order(ShoppingCart cart, Credentials credentials, long timeWait){
        this.cart = cart;
        this.credentials = credentials;
        this.timeWait = timeWait;
        id = UUID.randomUUID().hashCode();
    }

    public boolean isStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(boolean statusOrder) {
        this.statusOrder = statusOrder;
    }

    long getTimeCreate() {
        return timeCreate;
    }

    long getTimeWait() {
        return timeWait;
    }

    void setTimeWait(long timeWait) {
        this.timeWait = timeWait;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    Credentials getCredentials() {
        return credentials;
    }

    public int getID(){
        return id;
    }

    void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Order createRandom(){
        cart = new ShoppingCart().CreateRandom();
        credentials = new Credentials(); credentials.create();
        id = UUID.randomUUID().hashCode();
        timeWait = 10000;
        return this;
    }

}
