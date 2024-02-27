package src;

public class Meo implements Interface.ITerrestrialAnimal {
    private int id;
    private String name;
    private int age;

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
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

    public void move() {
        System.out.println("Run");
    }

    @Override
    public String toString() {
        System.out.println(getClass());
        System.out.println("Id: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        return "";
    }
}