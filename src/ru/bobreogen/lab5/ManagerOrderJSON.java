package ru.bobreogen.lab5;

import ru.bobreogen.lab1.Drink;
import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;

import java.io.FileWriter;

public class ManagerOrderJSON extends AManageOrder {
    ManagerOrderJSON(Orders orders){
        super(orders);
    }

    public void saveFile(Order order){
        try(FileWriter fw = new FileWriter(order.getID() + ".jsorder")){
            fw.write("Cart: {");
            for(int i = 0; i < order.getCart().size(); i++){
                Drink dr = order.getCart().get(i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Order readFile(int id){
        return null;
    }

    public Orders readAll(){
        return null;
    }
}
