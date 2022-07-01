package exercises.e14;

import java.util.ArrayList;


public class Sistema {
    protected String nome;
    protected ArrayList<String> arrayPlanetas;
    protected ArrayList<String> arrayEstrelas;

    public Sistema(String nome) {
        this.nome = nome;
        this.arrayPlanetas = new ArrayList<String>();
        this.arrayEstrelas = new ArrayList<String>();
    }

    public void addPlanet(String nome) {
        if (!arrayPlanetas.contains(nome))
            arrayPlanetas.add(nome);
    }

    public void addStar(String nome) {
        if (!arrayEstrelas.contains(nome))
            arrayEstrelas.add(nome);
    }

    public String getName() {
        return this.getName();
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getArrayPlanets() {
        return this.arrayPlanetas;
    }

    public ArrayList<String> getArrayEstrelas() {
        return this.arrayEstrelas;
    }

    public String getArrayEstrelasToString() {

        String str = "";

        for (String s : arrayEstrelas ) 
            str += s + " "; 


        return str;
    }

}
