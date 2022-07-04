package exercises.e20;

public class Tagarela extends Cartao {

    public Tagarela(int numero) {
        super(numero);
    }

    @Override
    protected double custoChamadas(double minutos) {
        if (minutos <= 1) {
            return minutos * 0.4;
        } else {
            return 1 * 0.4 + (minutos - 1) * 0.02;
        }

    }

}
