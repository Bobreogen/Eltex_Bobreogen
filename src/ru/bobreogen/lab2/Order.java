package ru.bobreogen.lab2;


public class Order {
    private boolean statusOrder = false; //false - в ожидании, true - выполнен
    private long timeCreate;
    private long timeWait;

    Order(ShoppingCart cart, Credentials credentials, long timeWait){
        this.cart = cart;
        this.credentials = credentials;
        this.timeWait = timeWait;
        timeCreate = System.currentTimeMillis();
    }

    private ShoppingCart cart;

    private Credentials credentials;

    boolean isStatusOrder() {
        return statusOrder;
    }

    void setStatusOrder(boolean statusOrder) {
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

    ShoppingCart getCart() {
        return cart;
    }

    void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    Credentials getCredentials() {
        return credentials;
    }

    void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

}
