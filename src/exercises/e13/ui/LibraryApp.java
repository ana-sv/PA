package exercises.e13.ui;

import exercises.e13.model.LibraryList;
import exercises.e13.model.LibraryMap;

public class LibraryApp {

    public static void main(String[] args) {

        //// LibraryList - using Library with Array List
        String[] authorsA = { "a1", "a2" };
        String[] authorsB = { "a3", "a4", "a5" };

        LibraryList li = new LibraryList("National Library");
        System.out.println(li);
        System.out.println();

        li.addBook("Title A", authorsA);
        li.addBook("Title B", authorsB);
        System.out.println(li);
        System.out.println();

        System.out.println("Book with id=3: " + li.getBook(3));
        System.out.println("Book with id=2: " + li.getBook(2));
        System.out.println();

        li.removeBook(0);
        System.out.println("After removing book with id=0:\r\n\r\n" + li);
        li.removeBook(1);
        System.out.println("After removing book with id=1:\r\n\r\n" + li);
        System.out.println();

        //// LibraryMap - using Library with HasMap
        String[] authorsC = { "c1", "c2" };
        String[] authorsD = { "d3", "d4", "d5" };

        LibraryMap lib = new LibraryMap("National Library");
        System.out.println(lib);
        System.out.println();

        lib.addBook("Title C", authorsC);
        lib.addBook("Title D", authorsD);
        System.out.println(lib);
        System.out.println();

        System.out.println("Book with id=3: " + lib.getBook(3));
        System.out.println("Book with id=2: " + lib.getBook(2));
        System.out.println();

        lib.removeBook(0);
        System.out.println("After removing book with id=0:\r\n\r\n" + lib);
        lib.removeBook(1);
        System.out.println("After removing book with id=1:\r\n\r\n" + lib);
        System.out.println();

        //// LibraryMap - using Library with HasSet

    }

}
