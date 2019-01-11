package com.example.vaibhavi.forinternshala;

public class Users {

    private String name;
    private int age;
    private int uid;


    Users(String name,int age){
        this.name = name;
        this.age = age;
    }

    Users(int age, String name, int uid){
        this.name = name;
        this.age = age;
        this.uid = uid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
