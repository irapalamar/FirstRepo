package ru.sbrf.demo;

public class LoggerTwo implements Logger {
    @Override
    public void writeLog(Animal animal) {
        System.out.println(animal.getName() + ":  " + animal.say());
    }
}
