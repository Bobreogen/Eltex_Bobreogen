package ru.bobreogen.lab1;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Coffee extends Drink {
    private String typeCoffee;

    public Coffee(){
        this.setId(UUID.randomUUID());
    }

    @Override
    public void delete() {
        super.delete();
        typeCoffee = "";
    }

    @Override
    public void update(){
        super.update();
        System.out.print("Type coffee: ");
        typeCoffee = (new Scanner(System.in)).nextLine();
    }

    @Override
    public void create(){
        Random random = new Random();
        super.create();
        typeCoffee = "Type coffee_" + random.nextInt(2);
    }
}
