import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

interface IMovie {
    int getID();
    String getName();
    Date getPublishDate();
    String getDirector();
    String getSubtitle();
    float getAverageRate();
    void display();
}

class Movie implements IMovie {
    private static int autoID = 1;
    private int ID;
    private String name;
    private Date publishDate;
    private String director;
    private String subtitle;
    private double[] rateList = new double[3];

    public Movie() {
        this.ID = autoID++;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getPublishDate() {
        return publishDate;
    }

    @Override
    public String getDirector() {
        return director;
    }

    @Override
    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public float getAverageRate() {
        return (float) Arrays.stream(rateList).average().orElse(0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublishDate(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        this.publishDate = format.parse(dateString);
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setRateList(double[] rateList) {
        this.rateList = rateList;
    }

    @Override
    public void display() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Director: " + director);
        System.out.println("Subtitle: " + subtitle);
        System.out.println("Average Rate: " + getAverageRate());
    }
}

class CustomList implements Iterable<IMovie> {
    private ArrayList<IMovie> movieList = new ArrayList<>();

    public void add(IMovie movie) {
        movieList.add(movie);
    }

    public void remove(IMovie movie) {
        movieList.remove(movie);
    }

    public void sort(Comparator<IMovie> comp) {
        movieList.sort(comp);
    }

    @Override
    public Iterator<IMovie> iterator() {
        return movieList.iterator();
    }
}

class CustomSort {
    public static void sortByAverageRate(CustomList customList) {
        customList.sort(Comparator.comparingDouble(IMovie::getAverageRate));
    }
}

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomList customList = new CustomList();

    public static void main(String[] args) throws ParseException {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    insertNewMovie();
                    break;
                case 2:
                    viewListOfMovies();
                    break;
                case 3:
                    sortMoviesByAverageRate();
                    break;
                case 4:
                    deleteMovie();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        } while (choice != 5);
    }

    private static void displayMenu() {
        System.out.println("PLEASE AN OPTION:");
        System.out.println("1. Insert new Movie");
        System.out.println("2. View list of Movie");
        System.out.println("3. Sort Movie by Average List");
        System.out.println("4. Delete a movie");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void insertNewMovie() throws ParseException {
        Movie movie = new Movie();
        System.out.print("Enter Name: ");
        movie.setName(scanner.nextLine());
        System.out.print("Enter Publish Date (dd-MM-yyyy): ");
        movie.setPublishDate(scanner.nextLine());
        System.out.print("Enter Director: ");
        movie.setDirector(scanner.nextLine());
        System.out.print("Enter Subtitle: ");
        movie.setSubtitle(scanner.nextLine());
        System.out.println("Enter 3 rating points:");
        double[] rates = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Rate " + (i + 1) + ": ");
            rates[i] = scanner.nextDouble();
        }
        movie.setRateList(rates);
        customList.add(movie);
        System.out.println("Movie added successfully with ID: " + movie.getID());
    }

    private static void viewListOfMovies() {
        for (IMovie movie : customList) {
            movie.display();
            System.out.println();
        }
    }

    private static void sortMoviesByAverageRate() {
        CustomSort.sortByAverageRate(customList);
        System.out.println("Movies sorted by Average Rate:");
        viewListOfMovies();
    }

    private static void deleteMovie() {
        System.out.print("Enter ID of the movie to delete: ");
        int id = scanner.nextInt();
        Iterator<IMovie> iterator = customList.iterator();
        while (iterator.hasNext()) {
            IMovie movie = iterator.next();
            if (movie.getID() == id) {
                iterator.remove();
                System.out.println("Movie with ID " + id + " deleted successfully.");
                return;
            }
        }
        System.out.println("Movie with ID " + id + " not found.");
    }
}

