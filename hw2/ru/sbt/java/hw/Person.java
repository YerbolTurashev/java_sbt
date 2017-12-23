package ru.sbt.java.hw;

public class Person {

    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;

    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public boolean marry(Person person) {

        if (man == person.isMan()) {

            return false;
        }


        if (spouse != null ) {

            divorce();
        }

        if (person.getSpouse() != null) {

            person.divorce();
        }

        person.setSpouse(this);
        spouse = person;
        return  true;

    }

    public void divorce() {

         spouse.setSpouse(null);
         spouse = null;


    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + (man ? "male" : "female") + ", Spouce: " + (spouse != null ? spouse.getName() : "No spouce");
    }
}
