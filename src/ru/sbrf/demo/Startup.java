package ru.sbrf.demo;

public class Startup {
    // private static Logger logger = new LoggerOne();
    private static Logger logger = new LoggerTwo();

    public static void main(String[] args) {
        Animal[] animals = {new Dog(2, "Шарик"), new Cat(5, "Бобик")};
        showAll(animals);
    }

    private static void showAll(Animal[] animals) {
        for (Animal animal : animals) {
            logger.writeLog(animal);
        }
    }

}
