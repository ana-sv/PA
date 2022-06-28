package exercises.e13.model;

import java.util.*;

public class LibrarySet implements LibraryInterface {

    protected String name;
    protected Set<Book> books; // using HasSet

    public LibrarySet(String name) {
        this.name = name;
        books = new HashSet<>();

    }

    public int addBook(String title, String[] authors) {
        Book new1 = new Book(title, authors);

        if (!this.books.add(new1)) {
            return -1;
        }

        return new1.getCode();

    }

    public int addBook(String title, List<String> authors) {

        Book new1 = new Book(title, authors);

        if (!this.books.add(new1)) {
            return -1;
        }

        return new1.getCode();
    }

    class compareTitle implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public Book getBook(int code) {
        Iterator<Book> it = this.books.iterator();

        while (it.hasNext()) {
            Book book = it.next();

            if (book.getCode() == code) {
                return book;
            }
        }

        return null;

    }

    public boolean removeBook(int code) {
        return this.books.remove(new Book(code));

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Biblioteca %s: ", name));
        List<Book> list = new ArrayList<>();
        list.addAll(this.books);
        // Collections.sort(list);
        Iterator<Book> it = books.iterator();

        while (it.hasNext()) {
            Book book = it.next();
            sb.append("\n\t- ");
            sb.append(book.toString());
        }

        return sb.toString();
    }

}