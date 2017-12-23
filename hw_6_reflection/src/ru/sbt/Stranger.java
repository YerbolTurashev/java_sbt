package ru.sbt;

public class Stranger {

    private String name;
    private Number age;

    public Stranger(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Number getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Number age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stranger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
