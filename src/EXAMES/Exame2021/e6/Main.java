package EXAMES.Exame2021.e6;

import java.util.ArrayList;

import EXAMES.Exame2021.e6.model.OnlineCommerce;
import EXAMES.Exame2021.e6.model.CommandPattern.AddItensToClient;
import EXAMES.Exame2021.e6.model.CommandPattern.CommandManager;

public class Main{

    public static void main(String[] args)  {
        
    CommandManager manager = new CommandManager();
    OnlineCommerce myShop = new OnlineCommerce();

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("sabao");
        list1.add("escova");
        list1.add("esfregao");

        AddItensToClient cmd1 = new AddItensToClient(myShop, list1, 123456 );
        manager.invokeCommand(cmd1);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("alface");
        list2.add("cebola");

        AddItensToClient cmd2 = new AddItensToClient(myShop, list2, 654321 );
        manager.invokeCommand(cmd2);
        manager.undo(); 

    }

   
}


