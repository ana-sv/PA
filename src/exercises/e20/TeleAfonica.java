package exercises.e20;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TeleAfonica {
    private int nFatura = 0;
    protected HashMap<Integer, Cartao> cartoes;

    public TeleAfonica() {
        this.cartoes = new HashMap<Integer, Cartao>();
    }

    public HashMap<Integer, Cartao> getArrayCartoes() {
        return this.cartoes;
    }

    public void exportarInfoTXT() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("src/exercises/e20/" + "CartoesAtivos")));

            pw.println("TeleAfonica: Cartoes Ativos");
            for (Map.Entry<Integer, Cartao> a : cartoes.entrySet())
                pw.println("[" + a.getKey() + "]" + a.getValue().toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
                pw.close();
        }

    }

    public void addCartaoPoucoTempo(int numero, double quantia) {
        PoucoTempo a = new PoucoTempo (numero);
        a.carregaSaldo(quantia);
        cartoes.put(numero, a);
    }


    public void addCartaoTagarela(int numero, double quantia) {
        Tagarela a = new Tagarela (numero);
        a.carregaSaldo(quantia);
        cartoes.put(numero, a);
    }

    public boolean registarChamada(int numeroOrigem, int numeroDestino, double duracao) {
        if (!cartoes.containsKey(numeroOrigem))
            return false;

        if (!cartoes.get(numeroOrigem).aceitaChamada()) 
            return false;

    
        cartoes.get(numeroOrigem).registaChamada(numeroDestino, duracao);      
        return true;
    }

    public double getSaldo(int numero) {
        return cartoes.get(numero).getSaldo();
    }

    public void carregarCartao( int numero, double quantia){
        if( cartoes.containsKey(numero) ){
            cartoes.get(numero).carregaSaldo(quantia);
        }
    }

    public void imprimeFaturaTXT(int numero) {
        if (!cartoes.containsKey(numero))
            return;

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("src/exercises/e20/" + "Fatura" + nFatura++ + "_" + numero+ ".txt")));
            pw.println("[ Fatura " + nFatura + " ] Numero:" + numero);
            for (Map.Entry<Integer, HashMap<Double, Double>> a : cartoes.get(numero).getChamadas().entrySet()){
                pw.println(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null)
                pw.close();
        }

    }

    public String listaCartoes() {
        return cartoes.keySet().toString() + "\n";
    }

    // https://www.geeksforgeeks.org/sorting-hashmap-according-key-value-java/
    public String listaCartoesOrdenadosNumero() {
        String s = "";

        TreeMap<Integer, Cartao> sorted = new TreeMap<Integer, Cartao>();
        sorted.putAll(this.cartoes);

        for (Map.Entry<Integer, Cartao> entry : sorted.entrySet()) {
            s += entry.getKey() + " [" + entry.getValue().getSaldo() + "] \n";
        }
        return s;
    }

    // https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/~
    // Using Streams in Java 8
    public String listaCartoesOrdenadosSaldo() {
        String s = "";

        HashMap<Integer, Cartao> temp = cartoes.entrySet().stream()
                .sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<Integer, Cartao> n : temp.entrySet()) {
            s += n.getKey() + " [" + n.getValue().getSaldo() + "] \n";
        }

        return s;
    }

}
