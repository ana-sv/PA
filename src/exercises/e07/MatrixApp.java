package exercises.e07;



public class MatrixApp {
    public static void main(String[] args){

        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];


        //Inicializa as matrizes com valores entre 0 e 100, ambas vão ser iguais

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int num = (int) (Math.random() * 101);

                m1[i][j] = num;
                m2[i][j] = num;
            }
        }

        System.out.println("Matrizes: \n");
        System.out.println(Matrix.seeElements(m1));

        int[][] nova = Matrix.sum(m1, m2);  // com o metodo estatico 

        if(nova != null){
            System.out.println(Matrix.seeElements(nova));
        }
        else
            System.out.println("\n\nMatrizes nao tem a mesma dimensao, soma impossível");


        
        Matrix a = new Matrix(m1);   
        System.out.println( Matrix.seeElements(a.sum(m2))); // com o metodo menbro  




    }
}
