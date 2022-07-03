package exercises.e19;

import exercises.e19.model.Library;
import exercises.e19.model.OldBook;
import exercises.e19.model.RecentBook;

public class LibraryApp {

    public static void main(String[] args) {

        OldBook old = new OldBook(" El Ingenioso Hidalgo Don Quixote de la Mancha", "Miguel de Cervantes",4 );
        RecentBook recent = new RecentBook("Harry Potter and the Deathly Hallows","J K Rowling ", "1a2b3c4d5e6", 29.99);

        Library lib = new Library(" Fantastic ");
        lib.addBook(old);
        lib.addBook(recent);

        System.out.println(lib.toString());

    

    }





    
}
