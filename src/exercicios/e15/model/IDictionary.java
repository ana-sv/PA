package exercicios.e15.model;

public interface IDictionary {
    void add( String language, String word, String wordTranslated );
    boolean setLanguage( String language );
    String get( String word );
    
}
