package exerciciosFX.gamebw.ui.gui;

import exerciciosFX.gamebw.model.GameBWManager;
import exerciciosFX.gamebw.ui.gui.resources.CSSManager;
import exerciciosFX.gamebw.ui.gui.resources.ImageManager;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class RootPane extends BorderPane {
    GameBWManager gameBWManager;

    public RootPane(GameBWManager gameBWManager) {
        this.gameBWManager = gameBWManager;

        createViews();
        registerHandlers();
        update();
    }

    private void createViews() {
        CSSManager.applyCSS(this,"styles.css");
        StackPane stackPane = new StackPane(
                new BeginUI(gameBWManager),
                new WaitBetUI(gameBWManager),
                new LostWaitDecisionUI(gameBWManager)
        );
        stackPane.setBackground(new Background(new BackgroundImage(
                ImageManager.getImage("background.png"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1,1,true,true,true,false)
        )));
        this.setCenter(stackPane);

        this.setRight(
                new BallsWon(gameBWManager)
        );
        this.setBottom(
                new BallsOut(gameBWManager)
        );

    }

    private void registerHandlers() {
    }

    private void update() {
    }
}
