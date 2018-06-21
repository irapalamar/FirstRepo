package ru.sbrf.demo;

public class LoggerThree implements Logger  {
    @Override
    public void writeLog(Animal animal) {
        System.out.println(animal.getName()+": "+animal.getAge()+ ": "+ animal.say());    }
}
