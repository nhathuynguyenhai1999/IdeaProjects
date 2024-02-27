import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<Student> readStudentsFromFile(String path)   {
        List<Student> students = new ArrayList<>();
        List<ClassName> classNames = readClassNamesFromFile("ClassName.csv");

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] items = line.split(",");
                Student student = new Student();
                student.setId(Integer.parseInt(items[0]));
                student.setName(items[1]);
                student.setClassName(classNames.get(Integer.parseInt(items[1])-1)); // Assuming class names are in the same order as in ClassName.csv
                student.setMath(Float.parseFloat(items[2].trim()));
                student.setPhysics(Float.parseFloat(items[3].trim()));
                student.setChemistry(Float.parseFloat(items[4].trim()));

                students.add(student);
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return students;
    }

    public static List<ClassName> readClassNamesFromFile(String filePath) {
        List<ClassName> classNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String [] items = line.split(",");
                int id = Integer.parseInt(items[0].trim());
                String name = items[1].trim();
                ClassName className = new ClassName(id, name);
                classNames.add(className);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classNames;
    }

    public static void writeStudentsToFile(String path, List<Student> students) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Student s : students) {
                bufferedWriter.write(s.toString() + "\n");
            }
            bufferedWriter.flush();

        } catch (IOException ioException) {

        }finally {
            try {
                fileWriter.close();
                bufferedWriter.close();
            } catch (Exception e) {
            }
        }
    }
    public static void writeClassNamesToFile(String filePath, List<Student> classNames) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Student className : classNames) {
                writer.println(className);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
