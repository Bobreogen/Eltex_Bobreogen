package ru.bobreogen.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.UUID;

public class Coffee extends Drink {
    private String typeCoffee;

    Coffee(){
        id = UUID.randomUUID();
    }

    @Override
    public void delete() {
        super.delete();
        typeCoffee = "";
    }

    @Override
    public void update(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        super.update();
        try{
            typeCoffee = reader.readLine();} catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(){
        Random random = new Random();
        super.create();
        typeCoffee = "Type coffee_" + random.nextInt(2);
    }
}
