package exercises.e20;

import java.util.Comparator;
import java.util.HashMap;

public class Cartao implements Comparable<Cartao> {
    protected double saldo;
    protected int numero;
    protected HashMap<Integer, HashMap<Double, Double>> chamadas;
    // numero destino , minutos, custo

    public Cartao(int numero) {
        this.numero = numero;
        saldo = 0;
        chamadas = new HashMap<Integer, HashMap<Double, Double>>();
    }

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public HashMap<Integer, HashMap<Double, Double>> getChamadas() {
        return this.chamadas;
    }

    public void carregaSaldo(double quantia) {
        this.saldo += quantia;
    }

    public void gastaSalfo(double quantia) {
        this.saldo -= quantia;
    }

    public boolean aceitaChamada() {
        if (this.saldo >= 0)
            return true;
        return false;
    }

    public String efetuaRegistaChamada(int numeroDestino, double minutos) {
        return "\n> Chamada não efectdada por falta de tarifario ativo";
    }

    public String toString() {
        String s = "";
        s += ">>>>>> Cartão Numero: " + this.numero + "[ saldo: " + this.saldo + "]\n";
        s += "Registo de Chamadas : " + this.chamadas.toString();
        return s;
    }

    // comparable
    @Override
    public int compareTo(Cartao o) {
        return (int) (this.saldo - o.saldo);
    }

    // comparator 
    public class CartaoComparator implements Comparator<Cartao> {

        @Override
        public int compare(Cartao o1, Cartao o2) {
            return o1.compareTo(o2);
        }

    }

}
