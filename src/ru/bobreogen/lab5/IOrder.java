package ru.bobreogen.lab5;

import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;

public interface IOrder {
    static Order readById(int id){return null;}
    static void saveById(int id){}
    static Orders readAll(){return null;}
    static void saveAll(){}
}
