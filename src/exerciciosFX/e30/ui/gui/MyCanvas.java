package exerciciosFX.e30.ui.gui;


import static exerciciosFX.e30.logic.ModelManager.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import exerciciosFX.e30.logic.Figure;
import exerciciosFX.e30.logic.ModelManager;
import exerciciosFX.e30.ui.resources.ImageLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class MyCanvas extends Canvas {

    ModelManager model;
    PropertyChangeListener listener;
    Image backgroundImage;

    public MyCanvas(ModelManager model, double width, double height) {

        super(width, height);
        this.model = model;

        listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                drawFigures();
            }
        };

       model.addPropertyChangeListener(FIGURES_SET_CHANGED, listener);
        model.addPropertyChangeListener(NEW_FIGURE_CHANGED, listener);
        //model.addPropertyChangeListener(listener);
        //model.addPropertyChangeListener(OvalsObservableModel.NEW_OVAL_CHANGED, evt->drawOvals());

        backgroundImage = ImageLoader.getImage("egg.png");

        setTranslateY(5);
        drawFigures();

        // Set the event handlers
        setOnMousePressed((mouseEvent) -> {
            model.startDefiningNewFigure((int)mouseEvent.getX(), (int)mouseEvent.getY());
            showMousePosition(mouseEvent.getX(), mouseEvent.getY());
        });
        setOnMouseDragged(mouseEvent -> {
            model.setNewFigureFinalCorner((int)mouseEvent.getX(), (int)mouseEvent.getY());
            showMousePosition(mouseEvent.getX(), mouseEvent.getY());
        });
        setOnMouseReleased(mouseEvent -> {
            model.addNewFigureToFigures();
            ((DrawingPane)this.getParent()).update();
        });
    }

    private void showMousePosition(double x, double y) {
        GraphicsContext gc = getGraphicsContext2D();

        gc.setFill(Color.WHITE);
        gc.setFont(Font.font(Font.getDefault().getName(), FontWeight.THIN, FontPosture.ITALIC,10));
        gc.fillText("(" + x +" ; " + y + ")", 5,15);
    }

    void drawFigures() {
        GraphicsContext gc = getGraphicsContext2D();

        eraseCanvas();

        //gc.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight());
        int div = 2;
        for(int x=0; x<getWidth(); x+=getWidth()/div){
            for (int y = 0; y < getHeight(); y +=getHeight()/div) {
                gc.drawImage(backgroundImage, x, y, getWidth()/div, getHeight()/div);
            }
        }

        for(Figure figure : model.getFigures()) {
            drawFigure(figure);
        }

        if(model.isDrawingNewFigure()) {
            drawFigure(model.getNewFigure());
        }

    }

    private void drawFigure(Figure figure) {
        GraphicsContext gc = getGraphicsContext2D();
        int x = Math.min(figure.getXi(), figure.getXf());
        int y = Math.min(figure.getYi(), figure.getYf());

        gc.setStroke(Color.DARKGRAY);
        gc.setLineWidth(Constants.BORDER_WIDTH);
        gc.setFill(Color.rgb(figure.getRedComponent(), figure.getGreenComponent(), figure.getBlueComponent()));

        switch(figure.getFigureType()) {

            case OVAL -> {
                gc.fillOval(x, y, figure.getWidth(), figure.getHeight());
                gc.strokeOval(x, y, figure.getWidth(), figure.getHeight());
            }

            case RECT -> {
                gc.fillRect(x, y, figure.getWidth(), figure.getHeight());
                gc.strokeRect(x, y, figure.getWidth(), figure.getHeight());
            }
            case LINE -> {
                gc.setStroke(Color.rgb(figure.getRedComponent(), figure.getGreenComponent(), figure.getBlueComponent()));
                gc.strokeLine(figure.getXi(), figure.getYi(), figure.getXf(), figure.getYf());
            }

        }
    }

    private void eraseCanvas() {
        GraphicsContext gc = getGraphicsContext2D();

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, getWidth(), getHeight());
    }

}
