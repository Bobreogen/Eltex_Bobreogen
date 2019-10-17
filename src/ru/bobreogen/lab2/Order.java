package ru.bobreogen.lab2;


import java.io.Serializable;
import java.util.UUID;

public class Order implements Serializable {
    private boolean statusOrder = false; //false - в ожидании, true - выполнен
    private long timeCreate;
    private long timeWait;
    private int id;

    public Order(){
        timeCreate = 0;
        timeWait = 0;
        id = UUID.randomUUID().hashCode();
    }

    Order(ShoppingCart cart, Credentials credentials, long timeWait){
        this.cart = cart;
        this.credentials = credentials;
        this.timeWait = timeWait;
        timeCreate = System.currentTimeMillis();
        id = UUID.randomUUID().hashCode();
    }

    private ShoppingCart cart;

    private Credentials credentials;

    public boolean isStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(boolean statusOrder) {
        this.statusOrder = statusOrder;
    }

    long getTimeCreate() {
        return timeCreate;
    }

    void setTimeCreate(long timeCreate) {
        this.timeCreate = timeCreate;
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

}
