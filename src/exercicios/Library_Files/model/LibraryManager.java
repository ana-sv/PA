package exercicios.Library_Files.model;

import exercicios.Library_Files.model.books.Book;
import exercicios.Library_Files.model.books.OldBook;
import exercicios.Library_Files.model.books.RecentBook;
import exercicios.Library_Files.model.files.LibraryFiles;
import exercicios.Library_Files.model.library.Library;

public class LibraryManager {
    protected Library library; 
    private String  nametxt = "LibraryData";
    private LibraryFiles libFiles; 

    public LibraryManager( String name ){
        this.library = new Library(name);
        this.libFiles = new LibraryFiles(library);
    }


    
    public boolean load(String fileName){
        return libFiles.loadtxt(fileName);
       }

    public boolean save(){
        return libFiles.savetxt(nametxt);
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
