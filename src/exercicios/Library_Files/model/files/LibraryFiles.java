package exercicios.Library_Files.model.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import exercicios.Library_Files.model.books.OldBook;
import exercicios.Library_Files.model.books.RecentBook;
import exercicios.Library_Files.model.library.Library;

public class LibraryFiles extends LibraryFilesAdapter {

    public LibraryFiles(Library lib) {
        super(lib);
    }

    @Override
    public boolean loadtxt(String fileName) {
        String line;
        Scanner sc;

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                sc = new Scanner(line);
                sc.useDelimiter("\n");

                if (sc.hasNext()) {
                    if (sc.next() == "Old") {
                        String title = sc.next();
                        String str = sc.nextLine();
                        String[] author = str.split(":");
                        int copies = sc.nextInt();
                        OldBook b = new OldBook(title, author, copies);
                        lib.addBook(b);

                    } else if (sc.next() == "Recent") {
                        String title = sc.next();
                        String str = sc.nextLine();
                        String[] author = str.split(":");
                        String isbn = sc.next();
                        double cost = sc.nextDouble();
                        RecentBook b = new RecentBook(title, author, isbn, cost);
                        lib.addBook(b);

                    }

                }

            }
            br.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean savetxt(String fileName) {

        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(this.lib.toString());
            pw.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public Library loadSerial(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName))) {
            return (Library) ois.readObject();

        } catch (Exception e) {
            System.err.println("Error loading data");
            return null;
        }

    }

    @Override
    public void saveSerial(String fileName, Library lib) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            oos.writeObject(lib);
        } catch (Exception e) {
            System.err.println("Error saving data");
        }
    }


}
