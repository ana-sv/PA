package exercises.e20;

import java.util.ArrayList;
import java.util.HashMap;

public class TeleAfonica {
    protected HashMap<Integer, Cartao> cartoes;

    public TeleAfonica() {
        this.cartoes = new HashMap<Integer, Cartao>();
    }

    public HashMap<Integer, Cartao> getArrayCartoes() {
        return this.cartoes;
    }

    public boolean exportarInfo() {
        //TODO
        return false;
    }

    public void addCartao(int numero, double quantia) {
        Cartao a = new Cartao(numero);
        a.carregaSaldo(quantia);
        cartoes.put(numero, a);
    }

    public boolean registarChamada(int numeroOrigem, int numeroDestino, int duracao) {
        //TODO
        return false;
    }

    public double getSaldo(int numero) {
        return cartoes.get(numero).getSaldo();
    }

    public boolean imprimeFatura( int numero ){
        //TODO
        return false;
    }

    public String listaCartoes(){
        //TODO
        return "";
        }

    public String listaCartoesOrdenadosNumero(){
        //TODO
        return "";
    }

    public String listaCartoesOrdenadosSaldo(){
        //TODO;
        return "" ; 
    }




    

}
