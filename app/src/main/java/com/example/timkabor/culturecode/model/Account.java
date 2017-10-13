package com.example.timkabor.culturecode.model;

/**
 * Created by Timkabor on 10/13/2017.
 */

public class Account {
    private String login;
    private String password;
    private String name, surname;
    private int age;
    private int electricity, light, gas, water, internet, phone, TV, balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account(String login, String password, String name, String surname, int age, int electricity, int light, int gas, int water, int internet, int phone, int TV, int balance) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.electricity = electricity;
        this.light = light;
        this.gas = gas;
        this.water = water;
        this.internet = internet;
        this.phone = phone;
        this.TV = TV;
        this.balance = balance;
    }

    public Account(String login, String password, String name, String surname, int age, int electricity, int light, int gas, int water, int internet, int phone, int TV) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.electricity = electricity;
        this.light = light;
        this.gas = gas;
        this.water = water;
        this.internet = internet;
        this.phone = phone;
        this.TV = TV;
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public Account(String login, String password,String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getTV() {
        return TV;
    }

    public void setTV(int TV) {
        this.TV = TV;
    }
}
