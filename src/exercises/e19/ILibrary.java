package exercises.e19;
import java.util.*;

public interface ILibrary {

    int addBook(String title, String[] authors);

    int addBook(String title, List<String> authors);

    Book getBook(int id);

    boolean removeBook(int id);
}