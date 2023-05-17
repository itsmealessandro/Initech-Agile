package controllers;

import business.BusinessException;
import business.ImpiantoService;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.ImpiantoSportivo;
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
import java.util.List;
import java.util.ResourceBundle;

public class AmministratoreVisualizzaImpiantiController implements Initializable, DataInitializable<Utente> {

private ViewDispatcher dispatcher;
private ImpiantoService impiantoService;

@FXML
private TableView impiantiTable;
@FXML
private TableColumn<ImpiantoSportivo, Integer> idColumn;
@FXML
private TableColumn<ImpiantoSportivo, String> tipologiaColumn;
    @FXML
    private TableColumn<ImpiantoSportivo, String> prezzoColumn;
    @FXML
    private TableColumn<ImpiantoSportivo, String> terrenoColumn;
@FXML
private TableColumn<ImpiantoSportivo, Button> gestioneColumn;
@FXML
private Button aggiungiButton;
@FXML
private Label errorLabel;

public AmministratoreVisualizzaImpiantiController() {
        dispatcher = ViewDispatcher.getInstance();
        impiantoService = InitechBusinessFactory.getInstance().getImpiantoService();
        }

@Override
public void initialize(URL location, ResourceBundle resources) {
        errorLabel.setVisible(false);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        prezzoColumn.setCellValueFactory(new PropertyValueFactory<>("prezzo"));
        tipologiaColumn.setCellValueFactory(new PropertyValueFactory<>("tipologia"));
        terrenoColumn.setCellValueFactory(new PropertyValueFactory<>("terreno"));

        gestioneColumn.setStyle("-fx-alignment: CENTER;");
        gestioneColumn.setCellValueFactory(param -> {
final Button gestioneButton = new Button("Gestione");

        gestioneButton.setOnAction(event -> dispatcher.renderView("gestione-impianto", param.getValue()));

        return new SimpleObjectProperty<>(gestioneButton);
        });
        }

@Override
public void initializeData(Utente utente) {
        try {
                List<ImpiantoSportivo> listaImpianti = impiantoService.getAllImpianti();
        ObservableList<ImpiantoSportivo> impiantiObservableList = FXCollections.observableList(listaImpianti);
        impiantiTable.setItems(impiantiObservableList);

        } catch (BusinessException e) {
        errorLabel.setText(e.getMessage());
        errorLabel.setVisible(true);
        }
        }

public void aggiungiAction() {
        ImpiantoSportivo nuovoImpianto = new ImpiantoSportivo();
        dispatcher.renderView("gestione-impianto", nuovoImpianto);
        }
        }
