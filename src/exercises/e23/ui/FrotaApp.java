package exercises.e23.ui;

import exercises.e23.model.Frota;

public class FrotaApp {

    public static void main(String[] args) {

        Frota f = new Frota();
        f.addVeiculo("12-ab-34", 2022, 0 , 2);
        f.addVeiculo("12-ab-35", 2022, 3, 0);
        System.out.println(f.listaVeiculos());


        f.removeVeiculo("12-ab-34");

        System.out.println(f.listaVeiculos());





    }

    
}
