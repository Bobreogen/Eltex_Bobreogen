package ru.bobreogen.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.UUID;

public class Tea extends Drink {
    private String typeContainer;

    Tea(){
        id = UUID.randomUUID();
    }

    @Override
    public void delete() {
        super.delete();
        typeContainer = "";
    }

    @Override
    public void read(){
        super.read();
        System.out.println("Type container: " + typeContainer);
    }

    @Override
    public void update(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        super.update();
        try{
            System.out.print("Type container: ");
            typeContainer = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(){
        Random random = new Random();
        super.create();
        typeContainer = "Container_" + random.nextInt(10);
    }
}
