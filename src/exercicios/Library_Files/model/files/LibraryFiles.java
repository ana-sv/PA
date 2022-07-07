package exercicios.Library_Files.model.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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


            // TODO terminar 




            while ((line = br.readLine()) != null) {
                sc = new Scanner(line);
                sc.useDelimiter(",");

               
                if (sc.hasNext()) {
                    if(sc.next() == "*OldBook" ){


                    }else if(sc.next() == "*RecentBook" ){
                        

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

}
