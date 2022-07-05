package exercicios.e20;

public class PoucoTempo extends Cartao {

    public PoucoTempo(int numero) {
        super(numero);

    }

    @Override
    protected double custoChamadas(double minutos ){
        return  minutos * 0.20;
    }




}
