package src;

public class Interface {
    public interface IAnimal {
        int getID();
        void setID(int id);
        String getName();
        void setName(String name);
        int getAge();
        void setAge(int age);
    }

    public interface ITerrestrialAnimal extends IAnimal {
        void move();
    }

    public interface IMarineAnimal extends IAnimal {
        void move();
    }
}
