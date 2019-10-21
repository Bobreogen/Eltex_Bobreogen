package ru.bobreogen.lab5;

import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;


abstract class AManageOrder implements IOrder {
    private Orders orders;
    String directory = "name/";

    AManageOrder(Orders orders){
        this.orders = orders;
    }

    private Order orderById(int id){
        Order order = null;
        for(int i = 0; i < orders.size(); i++){
            if(orders.get(i).getID() == id){
                order = orders.get(i);
                break;
            }
        }
        return  order;}
    abstract void saveFile(Order order);
    abstract Order readFile(int id);

    public void saveById(int id){
        saveFile(orderById(id));
    }

    public Order readById(int id){
        return readFile(id);
    }

    public void saveAll(){
        for(int i = 0; i < orders.size(); i++){
            saveFile(orders.get(i));
        }
    }


}
