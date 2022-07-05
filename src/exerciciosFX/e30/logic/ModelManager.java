package exerciciosFX.e30.logic;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ModelManager {

    private FiguresModel model;
    private final PropertyChangeSupport propertyChangeSupport;
    //private boolean visibilityState;

    public final static String FIGURES_SET_CHANGED = "figures set changed";
    public final static String NEW_FIGURE_CHANGED = "new figure changed";
    public final static String CURRENT_SHAPE_CHANGED = "current shape changed";
    public final static String CURRENT_COLOR_CHANGED = "current color changed";
    public final static String VISIBILITY_STATE_CHANGED = "visibility state changed";


    public ModelManager() {
        model = new FiguresModel();
        propertyChangeSupport = new PropertyChangeSupport(model);
        //visibilityState = false;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener ){
        propertyChangeSupport.addPropertyChangeListener(propertyName,listener);
    }

    public List<Figure> getFigures(){
        return model.getFigures();        
    }

    public Figure getNewFigure(){
        return model.getNewFigure();
    }

    public boolean isDrawingNewFigure(){
        return model.isDrawingNewFigure();
    }

    public Figure.EFigureType getCurrentShape(){
        return model.getCurrentShape();
    }

    public int getCurrentR() {
        return model.getCurrentR();
    }

    public int getCurrentG() {
        return model.getCurrentG();
    }

    public int getCurrentB() {
        return model.getCurrentB();
    }


    // =====================================================================================

    public void startDefiningNewFigure(int x, int y) {
        model.startDefiningNewFigure(x, y);
        //Notify observers
        propertyChangeSupport.firePropertyChange(NEW_FIGURE_CHANGED, null, null);

    }

    public void setNewFigureFinalCorner(int x, int y) {
        model.setNewFigureFinalCorner(x, y);
        //Notify observers
        propertyChangeSupport.firePropertyChange(NEW_FIGURE_CHANGED, null, null);
    }

    public void addNewFigureToFigures() {
        model.addNewFigureToFigures();
        //Notify observers
        propertyChangeSupport.firePropertyChange(FIGURES_SET_CHANGED, null, null);
    }

    public void setCurrentShape(Figure.EFigureType currentShape) {
        model.setCurrentShape(currentShape);
        propertyChangeSupport.firePropertyChange(CURRENT_SHAPE_CHANGED, null, null);
    }

    public void setCurrentColor(int r, int g, int b) {
        model.setCurrentColor(r, g, b);
        propertyChangeSupport.firePropertyChange(CURRENT_COLOR_CHANGED, null, null);
    }

    public void undo() {
        model.undo();
        //Notify observers
        propertyChangeSupport.firePropertyChange(FIGURES_SET_CHANGED, null, null);
    }

    public void clear() {
        model.clear();
        //Notify observers
        propertyChangeSupport.firePropertyChange(FIGURES_SET_CHANGED, null, null);
    }

    public void saveModel(String filePath) throws IOException {
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(filePath));
        oout.writeObject(model);
        oout.flush();;
        oout.close();
    }

    public void loadModel(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(filePath));
        model = (FiguresModel) oin.readObject();
        oin.close();

        // reset messages
        propertyChangeSupport.firePropertyChange(FIGURES_SET_CHANGED, null, null);
        propertyChangeSupport.firePropertyChange(NEW_FIGURE_CHANGED, null, null);
        propertyChangeSupport.firePropertyChange(NEW_FIGURE_CHANGED, null, null);
        propertyChangeSupport.firePropertyChange(CURRENT_COLOR_CHANGED, null, null);
        propertyChangeSupport.firePropertyChange(CURRENT_SHAPE_CHANGED, null, null);
        propertyChangeSupport.firePropertyChange(VISIBILITY_STATE_CHANGED, null, null);
    }

    public void setVisible(boolean visibilityState) {
        if(visibilityState == model.isVisible())
            return;

        model.setVisible(visibilityState);

        propertyChangeSupport.firePropertyChange(VISIBILITY_STATE_CHANGED, null, null);
    }

    public boolean isVisible() {
        return model.isVisible();
    }

    public void changeFiguresColors(){
        model.changeFiguresColors();

        propertyChangeSupport.firePropertyChange(FIGURES_SET_CHANGED, null, null);
    }

    public boolean isChangeColors() {
        return model.isAllowChangeColors();
    }

    public void setChangeColors(boolean changeColors) {
        model.setAllowChangeColors(changeColors);

        propertyChangeSupport.firePropertyChange(FIGURES_SET_CHANGED, null, null);
    }
}



    

