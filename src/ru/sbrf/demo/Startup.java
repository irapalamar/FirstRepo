package ru.sbrf.demo;

public class Startup {
    // private static Logger logger = new LoggerOne();
    //private static Logger logger = new LoggerTwo();
    //private static Logger logger = new LoggerThree();
    public static void main(String[] args) {
        Animal[] animals = {new Dog(2, "Шарик"), new Cat(5, "Бобик")};
        showAll(animals);
    }

    private static void showAll(Animal[] animals) {
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                new LoggerOne().writeLog(animal);
            } else if (animal instanceof Cat) {
                new LoggerTwo().writeLog(animal);
            } else new LoggerThree().writeLog(animal);
        }

    }
}
