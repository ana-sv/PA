package exercicios.Library_Files;

import exercicios.Library_Files.model.LibraryManager;
import exercicios.Library_Files.ui.LibraryUI;

public class Main {
    public static void main(String[] args) {
        LibraryManager lib = new LibraryManager("DEIS-ISEC");
        LibraryUI libui = new LibraryUI(lib);
        libui.start();
    }
}