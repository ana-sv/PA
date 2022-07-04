package exercises.e20;

import java.util.HashMap;

public class Tagarela extends Cartao {

    public Tagarela(int numero) {
        super(numero);
    }

    @Override
    public String efetuaRegistaChamada(int numeroDestino, double minutos) {

        if (!super.aceitaChamada())
            return "\n[" + super.numero + "] Chamada não efetuada por falta de saldo; ";

        double custo = custoChamadas(minutos);    
        HashMap<Double, Double> a = new HashMap<Double, Double>();

        a.put(minutos, custo);
        super.chamadas.put(numeroDestino, a); // regista chamada
        super.gastaSalfo(custo); // cobra saldo

        return "\n[" + super.numero + "] Chamada efetuada  - custo: " + custo;
    }

    private double custoChamadas(double minutos ){
        if (minutos <= 1) {
            return  minutos * 0.4;
        } else {
            return  1 * 0.4 + (minutos - 1) * 0.02;
        }

    }

    
}
