package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    int count = 0;
    List<Animal> animalList = new ArrayList<>();

    public void AddCat() {
        Cat obj = new Cat();
        obj.setID(count);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of cat: ");
        obj.setName(scanner.nextLine());
        System.out.print("Age of cat: ");
        obj.setAge(Integer.parseInt(scanner.nextLine()));
        animalList.add(obj);
        count++;
    }

    public void AddFish() {
        Fish obj = new Fish();
        obj.setID(count);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of fish: ");
        obj.setName(scanner.nextLine());
        System.out.print("Age of fish: ");
        obj.setAge(Integer.parseInt(scanner.nextLine()));
        animalList.add(obj);
        count++;
    }

    public void AddCrocodile() {
        Crocodile obj = new Crocodile();
        obj.setID(count);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of crocodile: ");
        obj.setName(scanner.nextLine());
        System.out.print("Age of crocodile: ");
        obj.setAge(Integer.parseInt(scanner.nextLine()));
        animalList.add(obj);
        count++;
    }

    public void ViewTerrestrialAnimals() {
        for (Animal animal : animalList) {
            if (animal instanceof Cat) {
                System.out.println(animal);
                ((Cat) animal).move();
            }
        }
    }

    public void ViewMarineAnimals() {
        for (Animal animal : animalList) {
            if (animal instanceof Fish) {
                System.out.println(animal);
                ((Fish) animal).move();
            }
        }
    }

    public void ViewAllAnimals() {
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
    }

    public void DeleteAnimals() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an index: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index >= 0 && index < animalList.size()) {
            animalList.remove(index);
            count--;
            System.out.println("Animal removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Create a Crocodile");
        System.out.println("2. Create a Cat");
        System.out.println("3. Create a Fish");
        System.out.println("4. View Terrestrial Animals");
        System.out.println("5. View Marine Animals");
        System.out.println("6. View All Animals");
        System.out.println("7. Delete Animal");
        System.out.println("8. Exit");
        do {
            System.out.print("\nPlease select an item: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    t.AddCrocodile();
                    break;
                case 2:
                    t.AddCat();
                    break;
                case 3:
                    t.AddFish();
                    break;
                case 4:
                    t.ViewTerrestrialAnimals();
                    break;
                case 5:
                    t.ViewMarineAnimals();
                    break;
                case 6:
                    t.ViewAllAnimals();
                    break;
                case 7:
                    t.DeleteAnimals();
                    break;
                case 8:
                    return;
            }
        } while (true);
    }
}