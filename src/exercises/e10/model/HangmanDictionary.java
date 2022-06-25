package exercises.e10.model;

// everything was translated to English, just in case
// Except the dictionary itself (TPC)

public class HangmanDictionary {

    private static final String[] words = { "AMANHA", "ARQUIMEDES", "LEAO", "TIGRE", "ZEBRA", "PRATO",
            "CASTANHO", "LARANJA", "ERVILHA", "LONTRA", "LASTRO", "ORANGOTANGO", "DISCIPLINA", "PROGRAMACAO",
            "BATATA", "PALHACO", "CEREBRO", "ATUM", "PORTUGAL", "SILVESTRE", "ANIMAL", "IRRACIONAL", "MATEMATICA",
            "DISCRETO", "EFICAZ", "EFICIENTE", "MARAVILHA", "SINOPSE", "DISPOSITIVO", "LINEAR", "LIMAO", "LAMPADA",
            "ORELHA", "BUFALO", "SAPATO", "LAGOSTA", "ARRISCADO", "RISCADO", "CARNAVAL", "ARROJADO", "LIBERTADO",
            "SIMPLES", "COMPLEXO", "AGRAFADOR", "MONITOR", "TECLADO", "CHAVE", "RELOGIO", "LENCO", "JANELA", "CORDA",
            "VIOLA", "GUITARRA", "PONTEIRO", "ARGUENTE", "SAGAZ", "ERRONEO", "INSTITUTO", "SUPERIOR", "ENGENHARIA",
            "DEPARTAMENTO", "INFORMATICA", "SISTEMA", "CONVOCATORIA", "PRESIDENTE", "FEVEREIRO", "AUMENTO", "SALARIO",
            "DINHEIRO", "IMEDIATO", "FLAMINGO", "RINOCERONTE", "HIPOPOTAMO", "BACALHAU", "PARGO", "SARDINHA", "CARACOL",
            "INSECTO", "VOADOR", "LARANJA", "ASPERSAO", "EXTINTO", "EXTERIOR", "AMBIVALENTE" };

    private HangmanDictionary() {
    } // try to avoid creation of objects of this class. It's just a toolbox

    public static int getNumWords() {
        return words.length;
    }

    public static String getWord(int index) {
        if (index < 0 || index >= words.length)
            return null;
        return words[index];
    }
}