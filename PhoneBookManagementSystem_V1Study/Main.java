import java.util.*;

interface IPhonebook {
    void insertPhone(String name, String phone);
    void removePhone(String name);
    void updatePhone(String name, String newPhone);
    void searchPhone(String name);
    void sort();
}

class Phonebook implements IPhonebook {
    private Map<String, String> phonebook;

    public Phonebook() {
        phonebook = new TreeMap<>();
    }

    @Override
    public void insertPhone(String name, String phone) {
        phonebook.put(name, phone);
        System.out.println("Phone number inserted for " + name);
    }

    @Override
    public void removePhone(String name) {
        if (phonebook.containsKey(name)) {
            phonebook.remove(name);
            System.out.println("Phone number removed for " + name);
        } else {
            System.out.println("No phone number found for " + name);
        }
    }

    @Override
    public void updatePhone(String name, String newPhone) {
        if (phonebook.containsKey(name)) {
            phonebook.put(name, newPhone);
            System.out.println("Phone number updated for " + name);
        } else {
            System.out.println("No phone number found for " + name);
        }
    }

    @Override
    public void searchPhone(String name) {
        if (phonebook.containsKey(name)) {
            System.out.println("Phone number for " + name + " is " + phonebook.get(name));
        } else {
            System.out.println("No phone number found for " + name);
        }
    }

    @Override
    public void sort() {
        TreeMap<String, String> sortedPhonebook = new TreeMap<>(phonebook);
        for (Map.Entry<String, String> entry : sortedPhonebook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert phone");
            System.out.println("2. Remove phone");
            System.out.println("3. Update phone");
            System.out.println("4. Search phone");
            System.out.println("5. Sort");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    phonebook.insertPhone(name, phone);
                    break;
                case 2:
                    System.out.print("Enter name to remove: ");
                    name = scanner.nextLine();
                    phonebook.removePhone(name);
                    break;
                case 3:
                    System.out.print("Enter name to update: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    phone = scanner.nextLine();
                    phonebook.updatePhone(name, phone);
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();
                    phonebook.searchPhone(name);
                    break;
                case 5:
                    phonebook.sort();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
