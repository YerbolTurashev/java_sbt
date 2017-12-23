package ru.sbt.java.hw;

/**
 * Created by User on 28.09.2017.
 */
public class Main {

    public static void main(String[] args) {

        Person ivan = new Person(true, "Ivan");
        Person vlad = new Person(true, "Vlad");
        Person kate = new Person(false, "Kate");
        Person olga = new Person(false, "Olga");

        System.out.println(ivan.marry(olga));
        System.out.println(ivan);
        System.out.println(olga);
        ivan.marry(kate);
        System.out.println(ivan);
        System.out.println(olga);
    }


}
