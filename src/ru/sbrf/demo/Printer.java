package ru.sbrf.demo;

public class Printer {
    private static Printer p;
    private Printer(){

    }

    public static Printer getIntance(){
        if ( p == null)
            p = new Printer();
        return p;
    }

    public static void printText(String text){
        System.out.println(text);
    }
}
