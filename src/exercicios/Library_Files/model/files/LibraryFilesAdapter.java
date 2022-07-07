package exercicios.Library_Files.model.files;

import exercicios.Library_Files.model.library.Library;

public abstract class LibraryFilesAdapter implements ILibraryFiles {

    protected Library lib; 


    public LibraryFilesAdapter(Library lib) {
        this.lib = lib;
    }
    @Override
    public boolean loadtxt(String fileName) {
        return false;
    }

    @Override
    public boolean savetxt(String fileName) {
        return false;
    }


    
}
