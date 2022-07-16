package EXAMES.Exame2022.perg_Melga.ui.txt;

import EXAMES.Exame2022.perg_Melga.model.fsm.MelgaContext;

public class Maintxt {

    public static void main(String[] args) {

        MelgaContext context = new MelgaContext(); 

 
        System.out.println("\nEstado: " + context.getState().toString());
        context.mexe(); 
        System.out.println("\nEstado: " + context.getState().toString());
        context.pica();
        System.out.println("\nEstado: " + context.getState().toString());
        context.mexe();
        System.out.println("\nEstado: " + context.getState().toString());
        context.tentaEsmagar();
        System.out.println("\nEstado: " + context.getState().toString());
        context.tentaEsmagar();
        System.out.println("\nEstado: " + context.getState().toString());
        context.descola();
        System.out.println("\nEstado: " + context.getState().toString());
        context.descola();
        System.out.println("\nEstado: " + context.getState().toString());


    }

    
}
