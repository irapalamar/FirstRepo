package ru.sbrf.demo.test;

import ru.sbrf.demo.Animal;

public class Dog implements Animal {
    private int age;
    private String name;

    public Dog (int age, String name){
        this.age=age;
        this.name=name;
    }

    protected String getColor(){
        return "red";
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

  //  @Override
    public String say() {
        return "Гав-гав";
    }
}
