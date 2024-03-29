package exerciciosFX.gamebw.ui.gui;

import exerciciosFX.gamebw.model.GameBWManager;
import exerciciosFX.gamebw.model.fsm.GameBWState;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BeginUI extends BorderPane {
    GameBWManager gameBWManager;
    Button btnStart,btnExit;

    public BeginUI(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        
        btnStart = new Button("Start");
        btnStart.setMinWidth(100);
        btnExit  = new Button("Exit");
        btnExit.setMinWidth(100);
        HBox hBox = new HBox(btnStart,btnExit);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        this.setCenter(hBox);
    }

    private void registerHandlers() {
        gameBWManager.addPropertyChangeListener(evt -> { update(); });
        btnStart.setOnAction( event -> {
            gameBWManager.start();
        });
        btnExit.setOnAction( event -> {
            Platform.exit();
        });
    }

    private void update() {
        if (gameBWManager.getState() != GameBWState.BEGIN) {
            this.setVisible(false);
            return;
        }
        this.setVisible(true);

    }
}
