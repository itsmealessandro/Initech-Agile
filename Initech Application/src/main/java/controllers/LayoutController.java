package controllers;

import domain.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import view.MenuElement;
import view.ViewDispatcher;

import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable, DataInitializable<Utente> {


    private static final MenuElement MENU_HOME = new MenuElement("Home", "home");

    private static final MenuElement[] MENU_AMMINISTRATORE = {
            //new MenuElement("Visualizza Calendario", "amministratore-calendario"),
            new MenuElement("Profilo", "gestione-profilo")
    };
    private static final MenuElement[] MENU_UTENTE_NON_REGISTRATO = {
            new MenuElement("Profilo", "gestione-profilo")
    };
    private static final MenuElement[] MENU_MAESTRO = {
            new MenuElement("Profilo", "gestione-profilo")
    };
    private static final MenuElement[] MENU_CLIENTE = {
            new MenuElement("Profilo", "gestione-profilo")
    };
    @FXML
    private VBox menuBar;

    private ViewDispatcher dispatcher;

    private Utente utente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initializeData(Utente utente) {
        this.utente = utente;
        menuBar.getChildren().addAll(createButton(MENU_HOME));
        menuBar.getChildren().add(new Separator());

        if (utente instanceof Amministratore) {
            for (MenuElement menu : MENU_AMMINISTRATORE) {
                menuBar.getChildren().add(createButton(menu));
            }
        }
        if (utente instanceof UtenteRegistrato || utente instanceof Socio) {
            for (MenuElement menu : MENU_CLIENTE) {
                menuBar.getChildren().add(createButton(menu));
            }
        }

        if (utente instanceof Maestro) {
            for (MenuElement menu : MENU_MAESTRO) {
                menuBar.getChildren().add(createButton(menu));
            }
        }
    }

    private Button createButton(MenuElement viewItem) {
        Button button = new Button(viewItem.getNome());
        button.setStyle("-fx-background-color: transparent; -fx-font-size: 14;");
        button.setTextFill(Paint.valueOf("white"));
        button.setPrefHeight(10);
        button.setPrefWidth(180);
        button.setOnAction((ActionEvent event) -> {
            dispatcher.renderView(viewItem.getVista(), utente);
        });
        return button;
    }

    @FXML
    public void logoutAction(MouseEvent event) {
        dispatcher.logout();
    }

}
