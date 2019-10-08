package ru.bobreogen.core;


import ru.bobreogen.lab1.Drink;
import ru.bobreogen.lab1.Tea;
import ru.bobreogen.lab2.Credentials;
import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;
import ru.bobreogen.lab2.ShoppingCart;
import ru.bobreogen.lab4.ACheckProcessed;
import ru.bobreogen.lab4.ACheckWaiting;
import ru.bobreogen.lab4.OrderCreator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Orders<Order> orders = new Orders<>();

        OrderCreator orderCreator = new OrderCreator(orders, 200);
        OrderCreator orderCreator1 = new OrderCreator(orders, 350);
        ACheckWaiting aCheckWaiting = new ACheckWaiting(orders, 1000);
        ACheckProcessed aCheckProcessed = new ACheckProcessed(orders, 2500);

        Scanner sc = new Scanner(System.in);

        while(true){
            int a = sc.nextInt();
            if(a == 1){
                aCheckWaiting.startCheck();
            }
            if(a == 0){
                aCheckProcessed.startCheck();
            }
        }
    }
}
