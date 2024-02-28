import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, Book1> bookMap = new HashMap<>();

    public static void main(String[] args) throws ParseException {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    insertNewBook();
                    break;
                case 2:
                    viewListOfBooks();
                    break;
                case 3:
                    calculateAndDisplayAveragePrice();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 4);
    }

    private static void displayMenu() {
        System.out.println("Tasks Menu:");
        System.out.println("1. Insert new book");
        System.out.println("2. View list of books");
        System.out.println("3. Average Price");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void insertNewBook() throws ParseException {
        Book1 book1 = new Book1();
        System.out.print("Enter Name: ");
        book1.setName(scanner.nextLine());
        System.out.print("Enter Publish Date (dd-MM-yyyy): ");
        book1.setPublishDate(scanner.nextLine());
        System.out.print("Enter Author: ");
        book1.setAuthor(scanner.nextLine());
        System.out.print("Enter Language: ");
        book1.setLanguage(scanner.nextLine());
        System.out.println("Enter 5 prices:");
        int[] prices = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Price " + (i + 1) + ": ");
            prices[i] = scanner.nextInt();
        }
        book1.setPriceList(prices);
        bookMap.put(book1.getID(), book1);
        System.out.println("Book1 added successfully with ID: " + book1.getID());
    }

    private static void viewListOfBooks() {
        for (Book1 book1 : bookMap.values()) {
            book1.display();
            System.out.println();
        }
    }

    private static void calculateAndDisplayAveragePrice() {
        for (Book1 book1 : bookMap.values()) {
            book1.display();
            System.out.println();
        }
    }
}
