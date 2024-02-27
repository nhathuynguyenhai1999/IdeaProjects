import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private static final String FILE_PATH = "Student.csv";
    public   void listStudents() {

        List<Student> students = FileUtils.readStudentsFromFile(FILE_PATH);
        System.out.println("List of Students:");
        for (Student student : students) {
            student.display();
        }
    }

    public  void classifyStudents() {
        // Implement classification logic here
        System.out.println("Classification of Students:");
        // Your classification logic
    }
    public  void addStudent(Scanner scanner) {
        List<Student> students = FileUtils.readStudentsFromFile(FILE_PATH);

        Student student = new Student();
        System.out.print("Enter student name: ");
        student.setName(scanner.nextLine());
        System.out.print("Enter student class: ");
        student.setClassName(scanner.nextLine());
        System.out.print("Enter math mark: ");
        student.setMath(Float.parseFloat(scanner.nextLine()));
        System.out.print("Enter physics mark: ");
        student.setPhysics(Float.parseFloat(scanner.nextLine()));
        System.out.print("Enter chemistry mark: ");
        student.setChemistry(Float.parseFloat(scanner.nextLine()));

        students.add(student);


        FileUtils.writeStudentsToFile(FILE_PATH, students);

    }
}
