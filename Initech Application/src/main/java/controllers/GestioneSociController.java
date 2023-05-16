package controllers;

import business.BusinessException;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.Socio;
import domain.Utente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import view.ViewDispatcher;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;

public class GestioneSociController implements Initializable, DataInitializable<Utente> {

    private ViewDispatcher dispatcher;
    private UtenteService utenteService;

    @FXML
    TableView sociTable;
    @FXML
    TableColumn<String, Socio> nomeColumn;
    @FXML
    TableColumn<String, Socio> cognomeColumn;
    @FXML
    TableColumn<String, Socio> tipologiaColumn;
    @FXML
    TableColumn<String, Socio> emailColumn;
    @FXML
    TableColumn<String, Button> azioneColumn;
    @FXML
    Label errorLabel;

    public GestioneSociController() {
        dispatcher = ViewDispatcher.getInstance();
        utenteService = InitechBusinessFactory.getInstance().getUtenteService();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorLabel.setVisible(false);


    }

    @Override
    public void initializeData(Utente utente) {

       


    }
}
