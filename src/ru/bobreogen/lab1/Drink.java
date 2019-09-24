package ru.bobreogen.lab1;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;


public abstract class Drink implements ICrudAction {

    private UUID id;
    private String name;
    private int price;
    private static int goodsCount = 0;
    private String firmSupplier;
    private String producerCountry;

    private boolean isCreate = false;

    Drink(){
        id = UUID.randomUUID();
    }

    public void setId(UUID id){
        this.id = id;
    }

    public void create(){
        final Random random = new Random();
        name = "DefaultName_" + random.nextInt(1000);
        price = random.nextInt(10000);
        firmSupplier = "Firm_" + random.nextInt(1000);
        producerCountry = "Country_" + random.nextInt(10);
        if(!isCreate){
            goodsCount++;
            isCreate = true;
        }
    }

    public void read(){
        System.out.println("ID: " + id.hashCode());
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Firm supplier: " + firmSupplier);
        System.out.println("Producer country: " + producerCountry);
    }

    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Price: ");
        price = Integer.parseInt(sc.nextLine());
        System.out.print("Firm supplier: ");
        firmSupplier = sc.nextLine();
        System.out.print("Producer country: ");
        producerCountry = sc.nextLine();
        if(!isCreate){
            goodsCount++;
            isCreate = true;
        }
    }

    public void delete(){
        name = null;
        price = 0;
        firmSupplier = null;
        producerCountry = null;
        if(isCreate){
            isCreate = false;
            goodsCount--;
        }
    }

    public int getID(){
        return id.hashCode();
    }
}
