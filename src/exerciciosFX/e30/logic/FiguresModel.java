package exerciciosFX.e30.logic;

import java.io.Serializable;
import java.util.ArrayList;

public class FiguresModel implements Serializable {

    public static final long serialVersionUID = 10L;

    private ArrayList<Figure> figures;
    private Figure newFigure;

    private Figure.EFigureType currentShape;
    private int currentR, currentG, currentB;

    private boolean visibilityState;
    private boolean allowChangeColors;

    public FiguresModel(){
        figures = new ArrayList<>();
        newFigure = null;

        visibilityState = false;
        allowChangeColors = false;

        currentShape = Figure.EFigureType.RECT;
        currentR = 255;
        currentG = 0;
        currentB = 0;
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public Figure getNewFigure() {
        return newFigure;
    }

    public Figure.EFigureType getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(Figure.EFigureType currentShape) {
        this.currentShape = currentShape;
    }

    public int getCurrentR() {
        return currentR;
    }

    public int getCurrentG() {
        return currentG;
    }

    public int getCurrentB() {
        return currentB;
    }

    public void setCurrentColor(int r, int g, int b) {
        this.currentR = r;
        this.currentG = g;
        this.currentB = b;
    }

    public boolean isAllowChangeColors() {
        return allowChangeColors;
    }

    public void setAllowChangeColors(boolean allowChangeColors) {
        this.allowChangeColors = allowChangeColors;
    }

    public boolean isDrawingNewFigure() {
        return newFigure != null;
    }

    public boolean isOvalsEmpty() {
        return figures.isEmpty();
    }

    public void startDefiningNewFigure(int x, int y) {
        newFigure = new Figure(currentShape, x, y, x, y, currentR, currentG, currentB);
    }

    public void setNewFigureFinalCorner(int x, int y) {
        if(newFigure != null)
            newFigure.setFinalCorner(x, y);
    }

    public void addNewFigureToFigures() {
        if(newFigure == null)
            return;

        figures.add(newFigure);
        newFigure = null;
    }

    public void undo() {
        if(figures.isEmpty())
            return;

        figures.remove(figures.size()-1);
    }

    public void clear() {
        figures.clear();
    }

    public void setVisible(boolean visibilityState) {
        this.visibilityState = visibilityState;
    }

    public boolean isVisible() {
        return visibilityState;
    }

    public void changeFiguresColors() {
        int r, g, b;

        if(!allowChangeColors)
            return;

        for(Figure f:figures){
            r = f.getRedComponent();
            g = f.getGreenComponent();
            b = f.getBlueComponent();
            f.setColor(b, r, g);
        }
    }
}
