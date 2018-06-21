package ru.sbrf.demo;

public class LoggerOne implements Logger {
    @Override
    public void writeLog(Animal animal) {
        System.out.println(animal.say());
    }
}
