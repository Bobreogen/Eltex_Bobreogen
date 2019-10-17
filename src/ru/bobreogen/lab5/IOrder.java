package ru.bobreogen.lab5;

import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;

public interface IOrder {
    Order readById(int id);
    void saveById(int id);
    Orders readAll();
    void saveAll();
}
