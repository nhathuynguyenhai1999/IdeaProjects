import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    private static final HashMap<Integer, Student> listDictionary = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "ListStudent.csv";
        List<Student> students = createSampleStudents();
        // Ghi danh sách sinh viên vào tệp CSV
        StudentCSVWriter.writeCSV(students, filename);
        System.out.println("CSV file has been created successfully.");
        List<Student> studentsFromFile = StudentCSVReader.readCSV(filename);
        // In thông tin của sinh viên từ tệp CSV
        for (Student student : studentsFromFile) {
            student.display();
            System.out.println();
        }
        while (true) {
            System.out.println("+----------------------------+");
            System.out.println("| STUDENTS MANAGEMENT SYSTEM |");
            System.out.println("+----------------------------+");
            System.out.println("|1. Insert new Student       |");
            System.out.println("|2. View list of Students    |");
            System.out.println("|3. Search Students          |");
            System.out.println("|4. Exit                     |");
            System.out.println("+----------------------------+");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertStudent();
                    break;
                case 2:
                    viewList();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    return;
            }
        }
    }

    private static void search() {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        System.out.print("Input Class: ");
        String search = scanner.nextLine();
        System.out.println("All students of class " + search);
        for (Student student : listDictionary.values()) {
            if (student.getClassName().equals(search)) {
                System.out.println("----------------------------");
                student.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students were found!");
        }
    }

    private static void viewList() {
        for (Student student : listDictionary.values()) {
            System.out.println("----------------------------");
            student.display();
        }
    }

    private static void insertStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        // Increment ID
        student.setID(listDictionary.size() + 1);

        // Input name
        System.out.print("Enter Fullname: ");
        student.setFullName(scanner.nextLine());

        // Input date
        while (true) {
            System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date dateOfBirth = dateFormat.parse(dateStr);
                student.setDateOfBirth(dateOfBirth);
                break;
            } catch (ParseException e) {
                System.out.println("The date is not in the correct format!");
            }
        }

        // Input Native
        System.out.print("Enter Native: ");
        student.setNativePlace(scanner.nextLine());

        // Input Class
        System.out.print("Enter Class: ");
        student.setClassName(scanner.nextLine());

        // Input Phone No
        System.out.print("Enter Phone No: ");
        student.setPhoneNo(scanner.nextLine());

        // Input Mobile
        while (true) {
            System.out.print("Enter Mobile: ");
            try {
                student.setMobile(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("The number is not in the correct format!");
            }
        }

        listDictionary.put(student.getID(), student);
        System.out.println("Successfully inserted a student!");
    }

    private static List<Student> createSampleStudents() {
        List<Student> students = new ArrayList<>();

        // Thêm các sinh viên vào danh sách
        Student student1 = new Student();
        student1.setFullName("John Doe");
        student1.setDateOfBirth(new Date());
        student1.setNativePlace("New York");
        student1.setClassName("Class A");
        student1.setPhoneNo("1234567890");
        student1.setMobile(987654321);
        student1.setID(1);
        students.add(student1);

        // Thêm các sinh viên khác tại đây nếu cần

        return students;
    }
}
