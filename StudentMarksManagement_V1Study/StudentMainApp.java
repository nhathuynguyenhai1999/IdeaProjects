import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMainApp {
    public static void main(String[] args) {

        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add a student");
            System.out.println("2. List students");
            System.out.println("3. Classify students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    studentManager.addStudent(scanner);
                    break;
                case "2":
                    studentManager.listStudents();
                    break;
                case "3":
                    studentManager.classifyStudents();
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
