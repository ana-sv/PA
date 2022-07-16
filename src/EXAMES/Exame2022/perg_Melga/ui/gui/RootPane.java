package EXAMES.Exame2022.perg_Melga.ui.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;



import EXAMES.Exame2022.perg_Melga.model.MelgaManager;

public class RootPane extends BorderPane {
    MelgaManager MelgaManager;

    Button btTentaEsmagar, btMexe;
    Label lblMexidas, lblTentativasEsmagamento, lblSituacao;

    HBox btBox, hbox;
    VBox lblBox, situacaoBox;

    public RootPane(MelgaManager melgaManager) {
        this.MelgaManager = melgaManager;

        createViews();
        registerHandlers();
        update();

    }

    private void createViews() {
        btMexe = new Button("Mexe");
        btMexe.setPrefSize(60, 20);
        btTentaEsmagar = new Button("Esmaga");
        btTentaEsmagar.setPrefSize(60, 20);

        btBox = new HBox();
        btBox.getChildren().addAll(btMexe, btTentaEsmagar);
        btBox.setSpacing(10);
        btBox.setPadding(new Insets(10));
        btBox.setAlignment(Pos.CENTER);
        this.setBottom(btBox);
        btBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));



        lblMexidas = new Label("Mexidas:" + MelgaManager.getNumMexidas());
        lblTentativasEsmagamento = new Label("Tentativas de Esmagamento: " + MelgaManager.getTentatidasEsmagamento());

        lblBox = new VBox(lblMexidas, lblTentativasEsmagamento);
        lblBox.setAlignment(Pos.CENTER_RIGHT);
        lblBox.setPadding(new Insets(10));
       // lblBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));

        lblSituacao = new Label(MelgaManager.getState().toString());
        lblSituacao.setPadding(new Insets(10));

        hbox = new HBox();
        hbox.getChildren().addAll(lblBox, lblSituacao);
        hbox.setAlignment(Pos.CENTER);
        this.setLeft(hbox);
        hbox.setPadding( new Insets(20));



    }

    private void registerHandlers() {
        MelgaManager.addPropertyChangeListener( evt -> { update(); });

        btMexe.setOnAction(evt -> { MelgaManager.mexe(); });
        btTentaEsmagar.setOnAction( evt -> { MelgaManager.tentaEsmagar(); });

    }

    private void update() {
        lblMexidas.setText("Mexidas: " + MelgaManager.getNumMexidas());
        lblTentativasEsmagamento.setText("Tentativas de Esmagamento: " + MelgaManager.getTentatidasEsmagamento());
        lblSituacao.setText(MelgaManager.getState().toString());

    }

}
