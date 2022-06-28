package exercises.e14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Galaxy {
    protected String name;
    protected Map <String, Map<ArrayList<String>,ArrayList<String>> > theSystem; 
                //nomeSistema  //arrayPanetas //arrayEstrelas

    public Galaxy(){
        theSystem = new HashMap<>();
        name = null; 
    }

    public boolean newSystem( String nome ){
       theSystem.put(nome,null);
        return true;
    }

    public boolean addPlanet(String nameSystem, String planet){
        if(theSystem.containsKey(nameSystem))
            return true; 
        return false;
    }
    
    public boolean addStar(String nameSystem, String star){
        if(theSystem.containsKey(nameSystem))
            return true;
        return false;
    }


    public String getPlanet(String nameSystem, int index){
        if ( theSystem.containsKey(nameSystem) ) {
          //// falta

        }
        return " ";
    }

    public String getStars(String nameStar){
        if ( theSystem.containsKey(nameStar) ) {
     // falta 
        }
        return " ";
    }

    public boolean existsSystem(String nameSystem ){
        if( theSystem.containsKey(nameSystem))
            return true;
        return false; 
    }





}
