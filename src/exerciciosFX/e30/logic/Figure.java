package exerciciosFX.e30.logic;

import java.io.Serializable;

public class Figure implements Serializable {

    public static final long serialVersionUID = 1L;
    public static enum EFigureType{ RECT , OVAL, LINE};

    private int xi, yi;     // coordenadas iniciais 
    private int xf, yf;         // coordenadas finais 
    private int redComponent, greenComponent, blueComponent; // cor 
    private EFigureType figureType;     // tipo de figura

    public Figure(EFigureType figureType, int xi, int yi, int xf, int yf, int redComponent, int greenComponent,
    int blueComponent) {
this.xi = xi;
this.yi = yi;
this.xf = xf;
this.yf = yf;
this.redComponent = redComponent;
this.greenComponent = greenComponent;
this.blueComponent = blueComponent;
this.figureType = figureType;
}

public void setFinalCorner(int x, int y) {
xf = x;
yf = y;
}

public int getXf() {
return xf;
}

public int getXi() {
return xi;
}

public int getYf() {
return yf;
}

public int getYi() {
return yi;
}

public int getHeight() {
return Math.abs(yf-yi);
}

public int getWidth() {
return Math.abs(xf-xi);
}

public int getRedComponent() {
return redComponent;
}

public int getGreenComponent() {
return greenComponent;
}

public int getBlueComponent() {
return blueComponent;
}

public EFigureType getFigureType() {
return figureType;
}

public void setColor(int r, int g, int b) {
redComponent = r;
greenComponent = g;
blueComponent = b;
}

@Override
public String toString() {
return figureType + "{" +
  "xi=" + xi +
  ", yi=" + yi +
  ", xf=" + xf +
  ", yf=" + yf +
  ", R=" + redComponent +
  ", G=" + greenComponent +
  ", B=" + blueComponent +
  '}';
}
}
