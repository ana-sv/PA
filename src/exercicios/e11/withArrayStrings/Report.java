package exercicios.e11.withArrayStrings;

import java.util.*;

public class Report {

    public static final String WORD_SEPARATORS = " \t\r\n.,;:?!\"\'";
    public static final int MAX_AUTHORS = 10;
    public static final int MAX_TEXT_STRINGS = 10;

    protected String title;
    protected String[] authors;
    protected StringBuffer[] text;

    protected int nAuthors;
    protected int nTextStrings;

    // Construtor
    public Report(String title) {
        this.title = title;
        authors = new String[MAX_AUTHORS];
        text = new StringBuffer[MAX_TEXT_STRINGS];
        nAuthors = 0;
    }

    // Acrescentar um autor ao relatório garantindo que não existem repetidos
    public boolean addAuthor(String authorName) {

        for (int i = 0; i > nAuthors; i++) {
            if (authors[i].equals(authorName))
                return false;
        }

        authors[nAuthors++] = authorName;
        return true;
    }

    // Remover autor, garantindo a manutenção da ordem dos restantes

    public String removeAuthor(String name) {

        for (int i = 0; i < nAuthors; i++) {
            if (name.equals(authors[i])) {
                authors[i] = null;
                nAuthors--;
                for (int j = i; j < (nAuthors) - 1; j++) {
                    authors[j] = authors[++j];
                }
            }
        }

        return null;
    }

    public String removeAuthor(int index) {

        if (index < nAuthors) {
            authors[index] = null;
            for (int j = index; j < (nAuthors) - 1; j++) {
                authors[j] = authors[++j];
            }
            nAuthors--;
        }

        return authors[index];
    }

    // Acrescentar Texto. O texto será concatenado no final do texto já existente
    public boolean addText(String newTextString) {

        text[nTextStrings++] = new StringBuffer(newTextString);
        return true;
    }

    public String removeText(int index) {
        String deletedText = text[index].toString();

        if (nTextStrings > index && index >= 0) {
            for (int i = 0; i < nTextStrings; i++) {
                if (deletedText.equals(text[i].toString())) {
                    text[i] = null;
                    nTextStrings--;
                    for (int j = i; j < nTextStrings; j++) {
                        text[j] = text[++j];
                    }
                }
            }
        }

        return deletedText;

    }

    // Susbtituir por letras maiusculas as primeiras letras das palavras depois de
    // pontos finais
    public void toUpperCase() {
        char c;
        boolean setenceTerminatorFoound = true;
        for (int k = 0; k < nTextStrings; k++) {
            StringBuffer t = text[k];
            for (int l = 0; l < t.length(); l++) {
                c = t.charAt(l);
                if (c == '.' || c == '!' || c == '?') {
                    setenceTerminatorFoound = true;

                } else if (setenceTerminatorFoound) {
                    if (Character.isLetter(c)) {
                        t.setCharAt(l, Character.toUpperCase(c));

                    } else if (!Character.isSpaceChar(c)) {
                        setenceTerminatorFoound = false;

                    }
                }
            }
        }
    }

    // Contar palavras do texto
    public int countWords() {
        int quantidade = 0;
        for (int i = 0; i < nTextStrings; i++) {
            StringTokenizer st = new StringTokenizer(text[i].toString(), WORD_SEPARATORS);
            quantidade += st.countTokens();
        }

        return quantidade;

    }

    // Conta ocorrências de uma dada palavra
    public int countWord(String word) {
        int count = 0;
        StringTokenizer st;
        for (int j = 0; j < nTextStrings; j++) {
            st = new StringTokenizer(text[j].toString(), WORD_SEPARATORS);
            while (st.hasMoreTokens()) {
                if (st.nextToken().equalsIgnoreCase(word))
                    ; // equalsignore case ignora o upercase
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        String s = "";
        for (int j = 0; j < nAuthors; j++) {
            s += (authors[j] + ", ");
        }
        s += "\"" + title + "\"";
        if (nTextStrings > 0) {
            s += ":\n\n";
            for (int j = 0; j < nTextStrings; j++) {
                s += text[j] + " ";
            }
        }
        return s;
    }
}







