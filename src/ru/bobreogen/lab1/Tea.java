package ru.bobreogen.lab1;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Tea extends Drink implements Serializable {
    private String typeContainer;

    public Tea(){
        this.setId(UUID.randomUUID());
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
        super.update();
        System.out.print("Type container: ");
        typeContainer = (new Scanner(System.in)).nextLine();
    }

    @Override
    public void create(){
        Random random = new Random();
        super.create();
        typeContainer = "Container_" + random.nextInt(10);
    }
}
