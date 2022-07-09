package exercicios.Library_Files.model;

import java.io.Serializable;

import exercicios.Library_Files.model.books.Book;
import exercicios.Library_Files.model.books.OldBook;
import exercicios.Library_Files.model.books.RecentBook;
import exercicios.Library_Files.model.files.LibraryFiles;
import exercicios.Library_Files.model.library.Library;

public class LibraryManager implements Serializable {

    protected Library library;
    private String fileTxt = "LibraryData";
    private String fileSerial = "LibraryDataSerial";
    private LibraryFiles libFiles;

    public LibraryManager(String name) {
        this.library = new Library(name);
        this.libFiles = new LibraryFiles(library);
    }


    

    public boolean loadtxt() {
        return libFiles.loadtxt(fileTxt);
    }

    public boolean savetxt() {
        return libFiles.savetxt(fileTxt);
    }

    public void loadSerial() {
        library = libFiles.loadSerial(fileSerial);
    }

    public void saveSerial() {
        libFiles.saveSerial(fileSerial, library);
    }







    public int addBook(OldBook recentBook) {
        return library.addBook(recentBook);
    }

    public int addBook(RecentBook recentBook) {
        return library.addBook(recentBook);
    }

    public Book findBook(int bookId) {
        return library.findBook(bookId);
    }

    public boolean removeBook(int codigo) {
        return library.removeBook(codigo);
    }

    public String toStringOtherOrder() {
        return library.toStringOtherOrder();
    }

    public String getName() {
        return library.getName();
    }


    

}
