package ru.sbrf.demo;

public class Dog implements Animal {
    private int age;
    private String name;


    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String say() {
        return "Гав-гав";
    }
}
