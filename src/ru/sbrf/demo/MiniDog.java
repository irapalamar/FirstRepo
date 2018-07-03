package ru.sbrf.demo;

public class MiniDog extends Dog {
    public MiniDog(int age, String name) {
        super(age, name);
    }

    @Override
    public String say() {
        return ("Гав-гав " + getColor());
    }
}
