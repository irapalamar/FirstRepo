package ru.sbrf.demo;

public class Startup {
    public static void main(String[] args){
        Animal[] animals = {new Dog(2,"Шарик"),new Cat(5,"Бобик")};
        for (Animal animal: animals){
            System.out.println(animal.say());
        }
    }

}
