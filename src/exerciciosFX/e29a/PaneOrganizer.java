package exerciciosFX.e29a;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
 
public class PaneOrganizer extends Pane {
    //vai extender sempre um dos containers possiveis,  extends Pane
 
    Figura fig;
    Ellipse elipse;
 
    public PaneOrganizer() {
        fig = new Figura();
        fig.setPrimeiroPonto(0, 0);
        fig.setSegundoPonto(100, 50);
        fig.setRGB(0, 50, 0);
 
        criaLayout(); //para criar os componentes que vão surgir no ecrã
        registaListeners(); // registar os comportamentos dos objectos
        atualizaElipse();
 
    }
 
    void criaLayout() {
        //adicionar o elemento ao Pane
        elipse = new Ellipse();
        this.getChildren().add(elipse);
    }
 
    public void registaListeners() {
        //detectar as ações do rato
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                fig.setPrimeiroPonto((int) t.getX(), (int) t.getY());
                fig.setSegundoPonto((int) t.getX(), (int) t.getY());
                fig.setRGB((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
                atualizaElipse();
            }
        });
 
        //usando lambda functions
        this.setOnMouseReleased((t) -> {
            fig.setSegundoPonto((int) t.getX(), (int) t.getY());
            atualizaElipse();
        });
        this.setOnMouseDragged((t) -> {
            fig.setSegundoPonto((int) t.getX(), (int) t.getY());
            atualizaElipse();
        });
 
    }
 
    //para desenhar a elipse
    void atualizaElipse() {
        //elipse.setFill(Color.GREEN);
        elipse.setFill(Color.rgb(fig.getR(), fig.getG(), fig.getB())); //para ir buscar as informações à fig
        //elipse.setCenterX(200.0);
        elipse.setCenterX((fig.getXi() + fig.getXf()) / 2);
        //elipse.setCenterY(200.0);
        elipse.setCenterY((fig.getYi() + fig.getYf()) / 2);
        //elipse.setRadiusX(150.0);
        elipse.setRadiusX(fig.getLargura() / 2);
        //elipse.setRadiusY(100.0);
        elipse.setRadiusY(fig.getAltura() / 2);
    }
 
}