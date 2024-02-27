import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentCSVHandler {
    private static final String CSV_HEADER = "Full Name,Date of Birth,Native,Class,Phone No,Mobile,ID";

    public static List<Student> readCSV(String filename) {
        return getStudents(filename);
    }

    static List<Student> getStudents(String filename) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Skip header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    Student student = new Student();
                    student.setFullName(parts[0].trim());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                    try {
                        student.setDateOfBirth(dateFormat.parse(parts[1].trim()));
                    } catch (ParseException e) {
                        // Handle if date format is incorrect
                        e.printStackTrace();
                    }
                    student.setNativePlace(parts[2].trim());
                    student.setClassName(parts[3].trim());
                    student.setPhoneNo(parts[4].trim());
                    student.setMobile(Integer.parseInt(parts[5].trim()));
                    student.setID(Integer.parseInt(parts[6].trim()));

                    students.add(student);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }

        return students;
    }

    public static void writeCSV(List<Student> students, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(CSV_HEADER);
            bw.newLine();

            for (Student student : students) {
                bw.write(student.getFullName() + "," +
                        student.getDateOfBirth() + "," +
                        student.getNativePlace() + "," +
                        student.getClassName() + "," +
                        student.getPhoneNo() + "," +
                        student.getMobile() + "," +
                        student.getID());
                bw.newLine();
            }

            System.out.println("CSV file was created successfully.");
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}

