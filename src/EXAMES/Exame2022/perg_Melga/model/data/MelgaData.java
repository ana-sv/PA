package EXAMES.Exame2022.perg_Melga.model.data;

public class MelgaData {
    long mexidas; 
    long tentativasEsmagamento;
    long picadas; 

    public boolean tentaEsmagar(){ 
        return true;
    };

    public void mexe(){
        this.mexidas++;
    }

    public void pica(){
        this.picadas++;
    }

    public void descola(){
    }


    public boolean isPousadaEmAnimal(){
        return true; 
    }

    public boolean isPousadaEmObjecto(){
        return true; 
    }

    public long getNumMexidas(){
        return this.mexidas;
    }

    public long getNumTentativasEsmagamento(){
        return this.tentativasEsmagamento;
    }

    public long getNumPicadas(){
        return this.picadas; 
    }

    public void incrementaPicada(){
        picadas++; 
    }

    public void incrementaMexidas(){
        mexidas++;
    }

    public void incrementaTentativas(){
        tentativasEsmagamento++; 
    }


}
