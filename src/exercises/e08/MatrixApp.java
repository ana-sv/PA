package exercises.e08;


public class MatrixApp {

    public static void main(String[] args){
        Matrix a = new Matrix();

        a.preencheMatrizAuto();
        a.mostraMatriz();

        a.alteraElemento(0,0,-1);
        a.mostraMatriz();

        a.somaLinhas();



    }

}
