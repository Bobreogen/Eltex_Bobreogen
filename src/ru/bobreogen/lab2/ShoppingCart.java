package ru.bobreogen.lab2;

import ru.bobreogen.lab1.Coffee;
import ru.bobreogen.lab1.Drink;
import ru.bobreogen.lab1.Tea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class ShoppingCart<T extends Drink> {

    private T dr;

    private ArrayList<Drink> list = new ArrayList<>();
    private HashSet<Integer> idSet = new HashSet<>();

    public Drink search(int id){
        if (idSet.contains(id)){
            for(Drink dr: list){
                if(dr.getID() == id){
                    return dr;
                }
            }
        }
        return null;
    }

    public ShoppingCart CreateRandom(){
        Random r = new Random();
        for(int i = 0; i < r.nextInt(15) + 1; i++){
            if(r.nextBoolean()){
                Coffee cf = new Coffee();
                cf.create();
                list.add(cf);
            }else{
                Tea t = new Tea();
                t.create();
                list.add(t);
            }
        }
        return this;
    }

    public void add(T dr){
        idSet.add(dr.getID());
        list.add(dr);
    }

    void showAll(){
        for (Drink dr : list) {
            dr.read();
        }
    }

    public Drink get(int index){
        return list.get(index);
    }

    public int size(){
        return list.size();
    }

    public void delete(int index){
        list.remove(index);
    }

    public void delete(T dr){
        list.remove(dr);
    }


}
