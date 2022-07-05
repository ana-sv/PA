package exercicios.e15.ui;

import exercicios.e15.model.Dictionary;

public class DictionaryTextApp {

    
    public static void main(String[] args) {
 
        Dictionary d = new Dictionary();

        d.add("english", "BOOK", "book");
        d.add("francais", "BOOK", "livre");
        d.add("portugues", "BOOK", "livro");
        d.add("english", "YEAR", "year");
        d.add("francais", "YEAR", "an");
        d.add("portugues", "YEAR", "ano");
        
        d.setLanguage("english");
        System.out.println(d.get("YEAR")); // year
        
        d.setLanguage("portugues");
        System.out.println(d.get("YEAR")); // ano

        d.setLanguage("francais");
        System.out.println(d.get("BOOK")); // livre
    }

}
