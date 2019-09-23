package ru.bobreogen.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ShoppingCart extends ArrayList {

    HashSet idSet = new HashSet();

//    public boolean add(Drink dr){
//        this.add(dr);
//        idSet.add(dr.getID());
//        return true;
//    }

//    public void setId(){
//        Iterator<Drink> i = this.iterator();
//        while(i.hasNext()){
//            Drink dr = i.next();
//            idSet.add(dr.getID());
//        }
//    }

    public void search(){
        //В процессе
    }

    public void showAll(){
        Iterator<Drink> i = this.iterator();
        while(i.hasNext()){
            Drink dr = i.next();
            dr.read();
        }
    }

    public void delete(int index){
         this.remove(index);
    }


}
