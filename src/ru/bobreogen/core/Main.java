package ru.bobreogen.core;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Drink dr = new Tea();
        dr.update();
        dr.read();
    }

    private static void start1lab(String[] args){
        ArrayList<Drink> list = new ArrayList<Drink>();
        for(int i = 0; i < Integer.parseInt(args[0]); i++){
            Drink dr;
            if (Integer.parseInt(args[0]) == 1)
                dr = new Tea();
            else dr = new Coffee();
            dr.update();
            list.add(dr);
        }
        for(int i = 0; i < Integer.parseInt(args[0]); i++){
            list.get(i).read();
        }
    }
}
