package ru.bobreogen.core;


import ru.bobreogen.lab1.Drink;
import ru.bobreogen.lab1.Tea;
import ru.bobreogen.lab2.Credentials;
import ru.bobreogen.lab2.Orders;
import ru.bobreogen.lab2.ShoppingCart;

public class Main {

    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        for(int i = 0; i < 5; i++){
            Drink dr = new Tea();
            dr.create();
            cart.add(dr);
        }
        Credentials cr = new Credentials();
        cr.create();
        Orders ors = new Orders();
        ors.makeAPurchase(cart, cr, 100000);
        ors.showAll();

    }
}
