package ru.sbrf.demo;

public class Cat extends Animal {
    public Cat(int age, String name) {
        super(age, name);
    }

    @Override
    public String say() {
        return "Мяу-мяу";
    }
}
