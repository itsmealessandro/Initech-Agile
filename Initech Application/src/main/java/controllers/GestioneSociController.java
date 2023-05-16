package controllers;

import business.BusinessException;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.Socio;
import domain.TipologiaSocio;
import domain.Utente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.ViewDispatcher;

import java.net.URL;
import java.util.ResourceBundle;

public class GestioneSociController implements Initializable, DataInitializable<Utente> {

    private ViewDispatcher dispatcher;
    private UtenteService utenteService;

    @FXML
    TableView sociTable;
    @FXML
    TableColumn<Socio, String> nomeColumn;
    @FXML
    TableColumn<Socio, String> cognomeColumn;
    @FXML
    TableColumn<Socio, TipologiaSocio> tipologiaColumn;
    @FXML
    TableColumn<Socio, String> emailColumn;
    @FXML
    Label errorLabel;

    public GestioneSociController() {
        dispatcher = ViewDispatcher.getInstance();
        utenteService = InitechBusinessFactory.getInstance().getUtenteService();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorLabel.setVisible(false);


        nomeColumn.setStyle("-fx-alignment: CENTER");
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));

        cognomeColumn.setStyle("-fx-alignment: CENTER");
        cognomeColumn.setCellValueFactory(new PropertyValueFactory<>("cognome"));

        tipologiaColumn.setStyle("-fx-alignment: CENTER");
        tipologiaColumn.setCellValueFactory(new PropertyValueFactory<>("tipologiaSocio"));

        emailColumn.setStyle("-fx-alignment: CENTER");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));


    }

    @Override
    public void initializeData(Utente utente) {

        try {
            ObservableList<Socio> socioObservableList = FXCollections.observableList(utenteService.getAllSoci());
            sociTable.setItems(socioObservableList);

        } catch (BusinessException e) {
            errorLabel.setText(e.getMessage());
            errorLabel.setVisible(true);
        }


    }
}
