import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentCSVWriter {
    private static final String CSV_HEADER = "Full Name,Date of Birth,Native,Class,Phone No,Mobile,ID";

    public static void writeCSV(List<Student> students, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.append(CSV_HEADER);
            writer.append("\n");

            for (Student student : students) {
                writer.append(student.getFullName());
                writer.append(",");
                writer.append(student.getDateOfBirth().toString()); // You might want to format this date
                writer.append(",");
                writer.append(student.getNativePlace());
                writer.append(",");
                writer.append(student.getClassName());
                writer.append(",");
                writer.append(student.getPhoneNo());
                writer.append(",");
                writer.append(Integer.toString(student.getMobile()));
                writer.append(",");
                writer.append(Integer.toString(student.getID()));
                writer.append("\n");
            }

            System.out.println("CSV file was created successfully.");
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}
