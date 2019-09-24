package ru.bobreogen.lab2;

import java.util.UUID;

public class Credentials {
    private UUID id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;

    public Credentials(){
        id = UUID.randomUUID();
    }

    public int getId() {
        return id.hashCode();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void create(){
        firstName = "123";
        lastName = "234";
        patronymic = "345";
        email = "456";
    }


}
