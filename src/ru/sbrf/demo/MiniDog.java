package ru.sbrf.demo;

import ru.sbrf.demo.test.Dog;

public class MiniDog extends Dog {
    public MiniDog(int age, String name) {
        super(age, name);
    }

    @Override
    public String say() {
        return ("Гав-гав " + getColor());
    }
}
