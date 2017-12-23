package ru.sbt;

public class Solution {

    public static void main(String[] args) {

        String a = "getName";

        System.out.println( a.split("get")[1]);

        Person person = new Person("Alex", 30);
        Stranger stranger = new Stranger("Stranger", 35);


        System.out.println(person);
        System.out.println(stranger);
        BeanUtils.assign(stranger, person);
        System.out.println(stranger);
    }
}
