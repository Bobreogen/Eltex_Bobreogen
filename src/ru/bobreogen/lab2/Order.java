package ru.bobreogen.lab2;


public class Order {
    boolean statusOrder = false; //false - в ожидании, true - выполнен
    long timeCreate;
    long timeWait;

    public Order(ShoppingCart cart, Credentials credentials, long timeWait){
        this.cart = cart;
        this.credentials = credentials;
        this.timeWait = timeWait;
        timeCreate = System.currentTimeMillis();
    }

    ShoppingCart cart;
    Credentials credentials;
}
