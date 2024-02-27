import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentCSVReader {
    public static List<Student> readCSV(String filename) {
        return StudentCSVHandler.getStudents(filename);
    }
}
