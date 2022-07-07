package exerciciosFX.teopropsjfx.ui.gui;

import exerciciosFX.teopropsjfx.model.ModelManager;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

// Árvore de objetos do Scene Graph da janela que permite a edição direta do valor

public class RootPane2 extends TextField {
    ModelManager mm;

    public RootPane2(ModelManager mm) {
        this.mm = mm;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        this.setAlignment(Pos.CENTER);
    }

    private void registerHandlers() {
        mm.addPropertyChangeListener(ModelManager.PROP_VALUE, evt -> {
            update();
        });

        this.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                try {
                    mm.setValue(Integer.parseInt(this.getText()));
                } catch (Exception e) {
                }
            }
        });
    }

    private void update() {
        this.setText(""+mm.getValue());
    }
}
