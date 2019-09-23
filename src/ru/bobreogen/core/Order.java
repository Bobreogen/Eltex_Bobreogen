package ru.bobreogen.core;

import java.util.Date;

class Order {
    boolean statusOrder = false;
    long timeCreate;
    long timeWait;

    Order(ShoppingCart cart, Credentials credentials, long timeWait){
        Date date = new Date();
        this.cart = cart;
        this.credentials = credentials;
        this.timeWait = timeWait;
        timeCreate = date.getTime();
    }

    ShoppingCart cart;
    Credentials credentials;
}
