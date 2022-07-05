package exerciciosFX.e29a;

public class Figura {
    //métodos necessários para gerir a figura
     
        int xi, yi, xf, yf; //posicao e tamanho
        int r, g, b; //para a cor
     
        public Figura() {
     
        }
     
        public int getXi() {
            return xi;
        }
     
        public int getYi() {
            return yi;
        }
     
        public int getXf() {
            return xf;
        }
     
        public int getYf() {
            return yf;
        }
     
        public int getR() {
            return r;
        }
     
        public int getG() {
            return g;
        }
     
        public int getB() {
            return b;
        }
     
        public void setRGB(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
     
        public void setPrimeiroPonto(int x, int y) {
            this.xi = x;
            this.yi = y;
        }
     
        public void setSegundoPonto(int x, int y) {
            this.xf = x;
            this.yf = y;
        }
     
        public int getLargura() {
            return Math.abs(xf - xi); //não interessa a ordem dos valores
        }
     
        public int getAltura() {
            return Math.abs(yf - yi); //não interessa a ordem dos valores
        }
    }