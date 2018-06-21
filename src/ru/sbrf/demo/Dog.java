package ru.sbrf.demo;

public class Dog extends Animal {

    public Dog(int age, String name) {
        super(age, name);
    }

    @Override
    public String say() {
       return "Гав-гав";
    }
}
