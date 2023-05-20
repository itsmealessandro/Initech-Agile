package controllers;

import business.BusinessException;
import business.ImpiantoService;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.ImpiantoSportivo;
import domain.Maestro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.ViewDispatcher;

import java.net.URL;
import java.util.ResourceBundle;

public class GestioneImpiantiController implements Initializable, DataInitializable<ImpiantoSportivo> {
        @FXML
        private TextField nomeField;
        @FXML
        private TextField tipologiaField;
        @FXML
        private TextField prezzoField;
        @FXML
        private TextField terrenoField;
        @FXML
        private Button salvaButton;
        @FXML
        private Button eliminaButton;
        @FXML
        private Label erroreLabel;


        private ViewDispatcher dispatcher;
        private ImpiantoService impiantoService;
        private ImpiantoSportivo impiantoSportivo;

    public GestioneImpiantiController() {
            InitechBusinessFactory factory = InitechBusinessFactory.getInstance();
            impiantoService = factory.getImpiantoService();
            dispatcher = ViewDispatcher.getInstance();
        }

        @Override
        public void initializeData(ImpiantoSportivo impiantoSportivo) {
            this.impiantoSportivo = impiantoSportivo;
            eliminaButton.setVisible(false);
            if (this.impiantoSportivo.getId() != null) {
                this.nomeField.setText(this.impiantoSportivo.getNome());
                this.tipologiaField.setText(this.impiantoSportivo.getTipologia());
                this.prezzoField.setText(String.valueOf(this.impiantoSportivo.getPrezzo()));
                this.terrenoField.setText(this.impiantoSportivo.getTerreno());
                eliminaButton.setVisible(true);
                salvaButton.setVisible(true);
                }
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            salvaButton.disableProperty().bind(nomeField.textProperty().isEmpty().
                    or(tipologiaField.textProperty().isEmpty().
                            or(prezzoField.textProperty().isEmpty().or(terrenoField.textProperty().isEmpty()))));

            //@TODO erroreLabel.setVisible(false);
        }

        public void salvaAction(ActionEvent event) {
        ImpiantoSportivo nuovoImpianto = new ImpiantoSportivo();
        nuovoImpianto.setId(impiantoSportivo.getId());
        nuovoImpianto.setNome(nomeField.getText());
        nuovoImpianto.setTipologia(tipologiaField.getText());
        nuovoImpianto.setPrezzo(Integer.parseInt(prezzoField.getText()));
        nuovoImpianto.setTerreno(terrenoField.getText());
        try {
            if(impiantoSportivo.getId()== null){impiantoService.aggiungiImpianto(nuovoImpianto);}
            impiantoService.modificaImpianto(nuovoImpianto);
                dispatcher.renderView("amministratore-visualizza-impianti", dispatcher.getLoggedUser());
            } catch (BusinessException e) {
                erroreLabel.setText(e.getMessage());
                erroreLabel.setVisible(true);
            }
        }

        public void eliminaAction(ActionEvent event) {
            try {
                impiantoService.rimuoviImpianto(impiantoSportivo);
                dispatcher.renderView("amministratore-visualizza-impianti", dispatcher.getLoggedUser());
            } catch (BusinessException e) {
                erroreLabel.setText(e.getMessage());
                erroreLabel.setVisible(true);
            }
        }

        public void goBack() {
            dispatcher.renderView("amministratore-visualizza-impianti", dispatcher.getLoggedUser());
        }
    }

