package exercises.e14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Galaxy {
    protected String name;
    protected Map <String,       Map<ArrayList<String>,ArrayList<String>> >  theSystem; 
                 //nomeSistema   //arrayPanetas       //arrayEstrelas

    public Galaxy(){
        theSystem = new HashMap<>();
        name = null; 
    }

    public boolean newSystem( String nome ){
        Map <ArrayList<String> ,ArrayList<String> > corposCelestes = new HashMap<>();
       theSystem.put(nome,corposCelestes);

        return true;
    }

    public boolean addPlanet(String nameSystem, String planet){
        if(theSystem.containsKey(nameSystem)){

            ArrayList<String> arrayPlanets= new ArrayList<String>(); 
            arrayPlanets.add(planet); 

            theSystem.get(nameSystem).put(arrayPlanets, null);

             return true; 
        }
           
        return false;
    }
    
    public boolean addStar(String nameSystem, String star){
        if(theSystem.containsKey(nameSystem)){

            ArrayList<String> arrayStars = new ArrayList<String>(); 
            arrayStars.add(star);

            theSystem.get(nameSystem).put(null, arrayStars);
          
            return true;
        }
            
        return false;
    }


    public String getPlanet(String nameSystem, int index){

        ///////////? 

        return " ";
    }

    public String getStars(String nameStar){


                 ///////////? 

        return " ";
    }

    public boolean existsSystem(String nameSystem ){
        if( theSystem.containsKey(nameSystem))
            return true;
        return false; 
    }





}
