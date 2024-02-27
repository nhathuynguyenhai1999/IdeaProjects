import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Define the interface
interface IStudentMark {
    // Properties
    String fullName();
    int ID();
    String classname();
    int semester();
    float averageMark();

    // Method
    void display();
}

/**
 * @param fullName Properties
 */ // Define the class implementing the interface
record StudentMark(String fullName, int ID, String classname, int semester, float averageMark) implements IStudentMark {
    // Constructor

    @Override
    public void display() {
        System.out.println("Fullname: " + fullName);
        System.out.println("ID: " + ID);
        System.out.println("Class: " + classname);
        System.out.println("Semester: " + semester);
        System.out.println("Average Mark: " + averageMark);
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        // Create an instance of StudentMark
        StudentMark student = new StudentMark("John Doe", 123456, "Computer Science", 2, 85.5f);
        List<StudentMark> studentMarks = new ArrayList<>();
        // Display student details
        student.display();
        int choice;
        Scanner scanner = null;
        do {
            System.out.println("Menu:");
            System.out.println("1. Display all student marks");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            assert false;
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayAllStudentMarks(studentMarks);
                    break;
                case 2:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 2);

        scanner.close();
    }
    private static void readDataFromCSV(String fileName, List<StudentMark> studentMarks) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String fullName = data[0];
                int ID = Integer.parseInt(data[1]);
                String classname = data[2];
                int semester = Integer.parseInt(data[3]);
                float averageMark = Float.parseFloat(data[4]);

                studentMarks.add(new StudentMark(fullName, ID, classname, semester, averageMark));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void displayAllStudentMarks(List<StudentMark> studentMarks) {
        if (studentMarks.isEmpty()) {
            System.out.println("No student marks available.");
            return;
        }

        System.out.println("All student marks:");
        for (StudentMark student : studentMarks) {
            student.display();
            System.out.println();
        }
    }
    }

