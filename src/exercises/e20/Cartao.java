package exercises.e20;

import java.util.HashMap;

public class Cartao {
    protected double saldo; 
    protected int numero; 
     protected HashMap<Integer, HashMap<Double,Double>> chamadas; 
                  // numero destino , minutos, custo

    public Cartao(int numero){
        this.numero = numero; 
        saldo = 0; 
        chamadas = new HashMap<Integer, HashMap<Double,Double>>();
    }

    public int getNumero(){
        return this.numero; 
    }

    public double getSaldo(){
        return this.saldo; 
    }

    public  HashMap<Integer, HashMap<Double,Double>> getChamadas(){
        return this.chamadas; 
    }

    public void carregaSaldo( double quantia ){
        this.saldo += quantia; 
    }

    public void gastaSalfo( double quantia ){
        this.saldo -= quantia; 
    }

    public boolean aceitaChamada( ){
        if( this.saldo >= 0 )
            return true; 
        return false;
    }

    public String efetuaRegistaChamada( int numeroDestino, double minutos ){
        return "\n> Chamada não efectdada por falta de tarifario ativo"; 
    }





    
}
