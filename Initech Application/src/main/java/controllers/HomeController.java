package controllers;

import domain.Utente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable, DataInitializable<Utente> {

    @FXML
    private Label benvenutoLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void initializeData(Utente utente) {
        benvenutoLabel.setText("Benvenuto, " + utente.getUsername());

    }
}
