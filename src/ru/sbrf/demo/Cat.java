package ru.sbrf.demo;

public class Cat implements Animal {
    private int age;
    private String name;

    public Cat (int age, String name){
        this.age=age;
        this.name=name;
    }

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
        return "Мяу-мяу";
    }
}
