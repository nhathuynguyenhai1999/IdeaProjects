import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

interface IBook1 {
    int getID();
    String getName();
    Date getPublishDate();
    String getAuthor();
    String getLanguage();
    float getAveragePrice();
    void display();
}

class Book implements IBook {
    private static int autoID = 1;
    private int ID;
    private String name;
    private Date publishDate;
    private String author;
    private String language;
    private int[] priceList = new int[5];

    public Book() {
        this.ID = autoID++;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getPublishDate() {
        return publishDate;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public float getAveragePrice() {
        return (float) Arrays.stream(priceList).average().orElse(0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        this.publishDate = format.parse(dateString);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPriceList(int[] priceList) {
        this.priceList = priceList;
    }

    @Override
    public void display() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Language: " + language);
        System.out.println("Average Price: " + getAveragePrice());
    }
}

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;

interface IBook {
    int getID();
    String getName();
    Date getPublishDate();
    String getAuthor();
    String getLanguage();
    float getAveragePrice();
    void display();
}

class Book1 implements IBook {
    private static int autoID = 1;
    private int ID;
    private String name;
    private Date publishDate;
    private String author;
    private String language;
    private int[] priceList = new int[5];

    public Book1() {
        this.ID = autoID++;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getPublishDate() {
        return publishDate;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public float getAveragePrice() {
        return (float) Arrays.stream(priceList).average().orElse(0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        this.publishDate = format.parse(dateString);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPriceList(int[] priceList) {
        this.priceList = priceList;
    }

    @Override
    public void display() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Language: " + language);
        System.out.println("Average Price: " + getAveragePrice());
    }
}

public class Main1 {
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
