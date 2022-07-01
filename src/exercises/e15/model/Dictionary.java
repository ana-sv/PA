package exercises.e15.model;

import java.util.*;


public class Dictionary implements IDictionary {

    private String currentLanguage;
    private Map<String, Map<String,String> > dict;
         //Language        //word   //wordTranslated

    public Dictionary(){
        this.dict = new HashMap<>();
        this.currentLanguage = "ENGLISH";
    }

    @Override
    public void add(String language, String word, String wordTranslated) {
        if (!this.dict.containsKey(language.toUpperCase())) {
            this.dict.put(language.toUpperCase(), new HashMap<>());
        }

        this.dict.get(language.toUpperCase()).put(word.toUpperCase(), wordTranslated.toUpperCase());
    }


    @Override
    public boolean setLanguage(String language) {
        if (!this.dict.containsKey(language.toUpperCase())) {
            return false;
        }

        this.currentLanguage = language.toUpperCase();
        return true;
    }

    @Override
    public String get(String word) {
        if (!this.dict.get(this.currentLanguage.toUpperCase()).containsKey(word.toUpperCase())) {
            return "Concept not available.";
        }

        return this.dict.get(this.currentLanguage.toUpperCase()).get(word.toUpperCase());
                        
    }
    
}
