package ru.bobreogen.lab5;
import ru.bobreogen.lab2.Order;
import ru.bobreogen.lab2.Orders;

import java.io.*;

public class ManagerOrderFile extends AManageOrder {


    public ManagerOrderFile(Orders<Order> orders){
        super(orders);
    }

    public void saveFile(Order order){
        try {
            File file = new File(directory + order.getID() + ".jsorder");
            file.createNewFile();
            System.out.println(file.getAbsolutePath());
        }catch (Exception e){
            e.printStackTrace();
        }
        try(FileOutputStream fos = new FileOutputStream(directory + order.getID() + ".order")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Order readFile(int id){
        Order order = new Order();
        try(FileInputStream fis = new FileInputStream(directory + id + ".order")){
            ObjectInputStream ois = new ObjectInputStream(fis);
            order = (Order) ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return order;
    }

    public Orders readAll(){
        Orders<Order> orders = new Orders<>();
        File folder = new File(directory);

        String[] files = folder.list((folder1, name) -> name.endsWith(".order"));
        try {
            for (String fileName : files) {
                String id = (fileName.split("\\."))[0];
                orders.add(readById(Integer.parseInt(id)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }
}