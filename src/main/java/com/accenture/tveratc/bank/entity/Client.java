package com.accenture.tveratc.bank.entity;

import java.util.UUID;

public class Client {
    private UUID ID;
    private String login;
    private String password;
    private String name;
    private String lastName;
    private String middleName;
    private String role;

    public Client(UUID ID, String login, String password, String name, String lastName, String middleName, String role) {
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.role = role;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
