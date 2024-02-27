import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private static final String STUDENT_FILE_PATH = "Student.csv";
    private static final String CLASSNAME_FILE_PATH = "ClassName.csv";
    public   void listStudents() {

        List<Student> students = FileUtils.readStudentsFromFile(STUDENT_FILE_PATH);
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
        List<Student> students = FileUtils.readStudentsFromFile(STUDENT_FILE_PATH);
        List<ClassName> classNames = FileUtils.readClassNamesFromFile(CLASSNAME_FILE_PATH);

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

        Student ClassName = null;
        if (!ClassName.contains(ClassName)){
//            classNames.add(ClassName);
        }


        FileUtils.writeStudentsToFile(STUDENT_FILE_PATH, students);
//        FileUtils.writeClassNamesToFile(CLASSNAME_FILE_PATH,classNames);
    }
}
