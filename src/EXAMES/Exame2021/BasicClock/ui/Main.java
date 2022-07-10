package EXAMES.Exame2021.BasicClock.ui;

import EXAMES.Exame2021.BasicClock.model.fsm.Context;

public class Main {

    public static void main(String[] args) {
       Context c = new Context(); 


       System.out.print(c.mostraRelogio());
       System.out.print(c.getState());
       c.ligaRelogio();
       System.out.print(c.mostraRelogio());
       System.out.print(c.getState());
       c.set();
       System.out.print(c.mostraRelogio());
       System.out.print(c.getState());

      






    }
    
}
