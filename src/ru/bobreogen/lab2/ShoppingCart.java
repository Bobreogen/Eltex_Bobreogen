package ru.bobreogen.lab2;

import ru.bobreogen.lab1.Drink;

import java.util.ArrayList;
import java.util.HashSet;

public class ShoppingCart<T extends Drink> {

    private T dr;

    private ArrayList<Drink> list = new ArrayList<>();
    HashSet<Integer> idSet = new HashSet<>();

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

    public void add(T dr){
        idSet.add(dr.getID());
        list.add(dr);
    }

    public void showAll(){
        for (Drink dr : list) {
            dr.read();
        }
    }

    public void delete(int index){
        list.remove(index);
    }

    public void delete(T dr){
        list.remove(dr);
    }


}
