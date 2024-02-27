package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Animal {
    private int ID;
    private String name;
    private int age;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat extends Animal {
    public void move() {
        System.out.println("Cat is walking.");
    }

    @Override
    public String toString() {
        return "Cat [ID=" + getID() + ", Name=" + getName() + ", Age=" + getAge() + "]";
    }
}

class Fish extends Animal {
    public void move() {
        System.out.println("Fish is swimming.");
    }

    @Override
    public String toString() {
        return "Fish [ID=" + getID() + ", Name=" + getName() + ", Age=" + getAge() + "]";
    }
}

class Crocodile extends Animal {
    public void move() {
        System.out.println("Crocodile is crawling.");
    }

    @Override
    public String toString() {
        return "Crocodile [ID=" + getID() + ", Name=" + getName() + ", Age=" + getAge() + "]";
    }
}

