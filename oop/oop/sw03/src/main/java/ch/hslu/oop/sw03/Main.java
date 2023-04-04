package ch.hslu.oop.sw03;

public class Main {

    public static void main(String[] args) {
        Element nitrogen = new Element("N", -210, -196);

        Temperatur temperatur = new Temperatur();
        System.out.println(temperatur.getAggregateState(nitrogen));
    }

}
