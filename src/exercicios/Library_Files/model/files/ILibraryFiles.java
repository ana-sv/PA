package exercicios.Library_Files.model.files;

import exercicios.Library_Files.model.library.Library;

public interface ILibraryFiles {
    boolean loadtxt(String fileName); 
    boolean savetxt(String fileName); 

    Library loadSerial(String fileName); 
    void  saveSerial(String fileName,Library lib); 
    
}
