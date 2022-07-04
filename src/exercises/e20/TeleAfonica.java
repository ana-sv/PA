package exercises.e20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.spec.ChaCha20ParameterSpec;

public class TeleAfonica {
    protected HashMap<Integer, Cartao> cartoes;

    public TeleAfonica() {
        this.cartoes = new HashMap<Integer, Cartao>();
    }

    public HashMap<Integer, Cartao> getArrayCartoes() {
        return this.cartoes;
    }

    public boolean exportarInfoTXT() {
        // TODO
        return false;
    }

    public void addCartao(int numero, double quantia) {
        Cartao a = new Cartao(numero);
        a.carregaSaldo(quantia);
        cartoes.put(numero, a);
    }

    public boolean registarChamada(int numeroOrigem, int numeroDestino, int duracao) {
        // TODO
        return false;
    }

    public double getSaldo(int numero) {
        return cartoes.get(numero).getSaldo();
    }

    public boolean imprimeFaturaTXT(int numero) {
        // TODO
        return false;
    }

    public String listaCartoes() {
        return cartoes.keySet().toString();
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

    // https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
    public String listaCartoesOrdenadosSaldo() {
         
    



        return "";
    }

}
