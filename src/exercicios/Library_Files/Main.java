package exercicios.Library_Files;

import exercicios.Library_Files.model.library.Library;
import exercicios.Library_Files.ui.LibraryUI;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library("DEIS-ISEC");
        LibraryUI libui = new LibraryUI(lib);
        libui.start();
    }
}