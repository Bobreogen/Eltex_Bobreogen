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
import ru.bobreogen.lab5.ManagerOrderFile;
import ru.bobreogen.lab5.ManagerOrderJSON;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        main5();
    }

    static void main5(){
        Orders<Order> orders = new Orders<>();
        for(int i = 0; i < 10; i++){
            orders.add(new Order().createRandom());
        }
        orders.get(0).getCart().get(0).read();
        ManagerOrderFile mof = new ManagerOrderFile(orders);
        ManagerOrderJSON moj = new ManagerOrderJSON(orders);
        mof.saveAll();
        moj.saveAll();
        Orders orders1 = mof.readAll();
        Orders orders2 = moj.readAll();
        orders1.get(0).getCart().get(0).read();
        orders2.get(0).getCart().get(0).read();
    }

    static void main4(){

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
