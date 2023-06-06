package controllers;

import business.BusinessException;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.Maestro;
import domain.Utente;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.ViewDispatcher;

import java.net.URL;
import java.util.ResourceBundle;

public class VisualizzaMaestriController implements Initializable, DataInitializable<Utente> {

    private ViewDispatcher dispatcher;
    private UtenteService utenteService;

    @FXML
    private TableView maestriTable;
    @FXML
    private TableColumn<Maestro, String> usernameColumn;
    @FXML
    private TableColumn<Maestro, String> emailColumn;
    @FXML
    private TableColumn<Maestro, Button> gestioneColumn;
    @FXML
    private Button aggiungiButton;
    @FXML
    private Label errorLabel;

    public VisualizzaMaestriController() {
        dispatcher = ViewDispatcher.getInstance();
        utenteService = InitechBusinessFactory.getInstance().getUtenteService();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorLabel.setVisible(false);

        usernameColumn.setStyle("-fx-alignment: CENTER");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        emailColumn.setStyle("-fx-alignment: CENTER");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        gestioneColumn.setStyle("-fx-alignment: CENTER;");
        gestioneColumn.setCellValueFactory(param -> {
            final Button gestioneButton = new Button("Gestione");

            gestioneButton.setOnAction(event -> dispatcher.renderView("gestione-maestro", param.getValue()));

            return new SimpleObjectProperty<>(gestioneButton);
        });
    }

    @Override
    public void initializeData(Utente utente) {

        try {
            ObservableList<Maestro> maestroObservableList = FXCollections.observableList(utenteService.getAllMaestri());
            maestriTable.setItems(maestroObservableList);

        } catch (BusinessException e) {
            errorLabel.setText(e.getMessage());
            errorLabel.setVisible(true);
        }
    }

    public void aggiungiAction() {
        Maestro nuovomaestro = new Maestro();
        dispatcher.renderView("gestione-maestro", nuovomaestro);
    }
}
