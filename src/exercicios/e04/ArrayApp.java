package exercicios.e04;

public class ArrayApp {


    public final static int TAM_ARRAY = 20;
    public final static int MAX_VALOR = 100;

    protected int[] a;
    protected int quantidadeValoresDuplicados;
    protected int pos;

    public  ArrayApp () {                       //Construtor
        a = new int[TAM_ARRAY];
        quantidadeValoresDuplicados = 0;
        pos = 0;
    }

    public void preencheArray() {
        int x;
        for (int i = 0; i < 20; i++) {
            x = (int) (Math.random() * MAX_VALOR);
            while (valorJaExistente(x)) {
                x = (int) (Math.random() * MAX_VALOR);
                quantidadeValoresDuplicados++;
                System.out.println(quantidadeValoresDuplicados);
            }
            a[pos] = x;
            pos++;
        } 

    }

    public boolean valorJaExistente(int valor) {
        for (int i = 0; i < a.length; i++) {
            if (valor == a[i]) {
                return true;
            }
        }
        return false;
    }

    public void listaConteudoArray() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public int getQuantidadeValoresDuplicados() {
        return quantidadeValoresDuplicados;
    }

    public static void main(String args[]) {
        ArrayApp ar = new  ArrayApp ();

        ar.preencheArray();

        ar.listaConteudoArray();
        System.out.println();
        System.out.println("Valores gerados duplicados: " + ar.getQuantidadeValoresDuplicados());

        System.out.println("Array: ");
    }

}
