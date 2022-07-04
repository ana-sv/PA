package exercises.e20;

import java.util.Comparator;
import java.util.HashMap;

public abstract class Cartao implements Comparable<Cartao> {
    protected double saldo;
    protected int numero;
    protected HashMap<Integer, HashMap<Double, Double>> chamadas;
    // numero destino , minutos, custo

    protected Cartao(int numero) {
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

    public void gastaSaldo(double quantia) {
        this.saldo -= quantia;
    }

    public boolean aceitaChamada() {
        if (this.saldo >= 0)
            return true;
        return false;
    }

   protected double custoChamadas(double minutos) {
        return  0; 
    }

    public String registaChamada(int numeroDestino, double minutos) {

        if (!aceitaChamada())
            return "\n[" + numero + "] Chamada não efetuada por falta de saldo; ";

        double custo = Math.round(custoChamadas(minutos) * 100.0) / 100.0;
        HashMap<Double, Double> a = new HashMap<Double, Double>();

        a.put(minutos, custo);
        chamadas.put(numeroDestino, a); // regista chamada
        gastaSaldo(custo); // cobra saldo

        return "\n[" + numero + "] Chamada efetuada  - custo: " + custo;
    }

    public String toString() {
        String s = "";
        s += "Cartao Numero: " + this.numero + "[ saldo: " + this.saldo + "]\n";
        s += "> Registo de Chamadas : " + this.chamadas.toString();
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
