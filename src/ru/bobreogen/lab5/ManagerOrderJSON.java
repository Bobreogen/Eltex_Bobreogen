package ru.bobreogen.lab5;

import com.google.gson.Gson;
import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ManagerOrderJSON extends AManageOrder {
    public ManagerOrderJSON(Orders<Order> orders){
        super(orders);
    }

    public void saveFile(Order order){
        try {
            new File(directory + order.getID() + ".jsorder").createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
        try(FileWriter fw = new FileWriter(directory + order.getID() + ".jsorder")){
            Gson gson = new Gson();
            gson.toJson(order, fw);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Order readFile(int id){
        Order order = new Order();
        try(FileReader fr = new FileReader((directory + id + ".jsorder"))){
            Gson gson = new Gson();
            order = gson.fromJson(fr, order.getClass());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return order;
    }

    public Orders readAll(){
        Orders<Order> orders = new Orders<>();
        File folder = new File(directory);

        String[] files = folder.list((folder1, name) -> name.endsWith(".jsorder"));
        try {
            for (String fileName : files) {
                String id = (fileName.split("\\."))[0];
                orders.add(readById(Integer.parseInt(id)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return orders;
    }
}
