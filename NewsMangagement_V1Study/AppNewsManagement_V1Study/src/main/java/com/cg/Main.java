package com.cg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;

interface INews {
    int getID();
    String getTitle();
    Date getPublishDate();
    String getAuthor();
    String getContent();
    float getAverageRate();
    void display();
}

class News implements INews {
    private static int autoID = 1;
    private final int ID;
    private String title;
    private Date publishDate;
    private String author;
    private String content;
    private float averageRate;
    private int[] rateList = new int[3];

    public News() {
        this.ID = autoID++;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getTitle() {
        return title;
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
    public String getContent() {
        return content;
    }

    @Override
    public float getAverageRate() {
        return averageRate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        this.publishDate = format.parse(dateString);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRateList(int[] rateList) {
        this.rateList = rateList;
    }

    public void calculate() {
        int sum = 0;
        for (int rate : rateList) {
            sum += rate;
        }
        averageRate = (float) sum / rateList.length;
    }

    @Override
    public void display() {
        System.out.println("ID: " + ID);
        System.out.println("Title: " + title);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
        System.out.println("Average Rate: " + averageRate);
    }
}

public class Main {
    private static final Hashtable<Integer, News> newsHashtable = new Hashtable<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    insertNews(scanner);
                    break;
                case 2:
                    viewListNews();
                    break;
                case 3:
                    calculateAndDisplayAverageRate();
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
        System.out.println("a. Insert news");
        System.out.println("b. View List news");
        System.out.println("c. Average rate");
        System.out.println("d. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void insertNews(Scanner scanner) {
        News news = new News();
        System.out.print("Enter Title: ");
        news.setTitle(scanner.nextLine());
        System.out.print("Enter Publish Date (dd-MM-yyyy): ");
        try {
            news.setPublishDate(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd-MM-yyyy.");
            return;
        }
        System.out.print("Enter Author: ");
        news.setAuthor(scanner.nextLine());
        System.out.print("Enter Content: ");
        news.setContent(scanner.nextLine());
        System.out.println("Enter 3 rates:");
        int[] rates = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Rate " + (i + 1) + ": ");
            rates[i] = scanner.nextInt();
        }
        news.setRateList(rates);
        news.calculate();
        newsHashtable.put(news.getID(), news);
        System.out.println("News added successfully with ID: " + news.getID());
        writeToCSV(news);
    }

    private static void viewListNews() {
        for (News news : newsHashtable.values()) {
            news.display();
            System.out.println();
        }
    }

    private static void calculateAndDisplayAverageRate() {
        for (News news : newsHashtable.values()) {
            news.calculate();
            news.display();
            System.out.println();
        }
    }

    private static void writeToCSV(News news) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("News.csv", true))) {
            writer.write(news.getID() + "," + news.getTitle() + "," + news.getPublishDate() + "," +
                    news.getAuthor() + "," + news.getContent() + "," + news.getAverageRate() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
