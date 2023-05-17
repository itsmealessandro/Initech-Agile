package controllers;

import business.BusinessException;
import business.InitechBusinessFactory;
import business.UtenteService;
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

public class GestioneMaestroController implements Initializable, DataInitializable<Maestro> {
    @FXML
    private TextField emailField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confermaPasswordField;
    @FXML
    private Button aggiungiButton;
    @FXML
    private Button eliminaButton;
    @FXML
    private Button salvaModificheButton;
    @FXML
    private Label erroreLabel;


    private ViewDispatcher dispatcher;
    private UtenteService utenteService;
    private Maestro maestro;

    public GestioneMaestroController() {
        InitechBusinessFactory factory = InitechBusinessFactory.getInstance();
        utenteService = factory.getUtenteService();
        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initializeData(Maestro maestro) {
        this.maestro = maestro;
        eliminaButton.setVisible(false);
        salvaModificheButton.setVisible(false);
        if (this.maestro.getId() != null) {
            this.usernameField.setText(this.maestro.getUsername());
            this.emailField.setText(this.maestro.getEmail());
            this.passwordField.setText(this.maestro.getPassword());
            this.confermaPasswordField.setText(this.maestro.getPassword());
            eliminaButton.setVisible(true);
            salvaModificheButton.setVisible(true);
            aggiungiButton.setVisible(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aggiungiButton.disableProperty().bind(usernameField.textProperty().isEmpty().
                or(passwordField.textProperty().isEmpty().
                        or(confermaPasswordField.textProperty().isEmpty().or(emailField.textProperty().isEmpty()))));

        erroreLabel.setVisible(false);

        salvaModificheButton.disableProperty().bind(usernameField.textProperty().isEmpty().
                or(passwordField.textProperty().isEmpty().
                        or(confermaPasswordField.textProperty().isEmpty().or(emailField.textProperty().isEmpty()))));
    }

    @FXML
    public void aggiungiMaestroAction(ActionEvent event) {
        try {
            if (passwordField.getText().equals(confermaPasswordField.getText())) {
                Maestro nuovomaestro = new Maestro();
                nuovomaestro.setUsername(usernameField.getText());
                nuovomaestro.setPassword(passwordField.getText());
                nuovomaestro.setEmail(emailField.getText());
                boolean esitoOperazione = utenteService.aggiungiMaestro(nuovomaestro);
                if (esitoOperazione == true)
                    dispatcher.renderView("visualizza-maestri", dispatcher.getLoggedUser());
                else {
                    erroreLabel.setVisible(true);
                    erroreLabel.setText("Username già esistente");
                }
            } else {
                erroreLabel.setVisible(true);
                erroreLabel.setText("Le password inserite non combaciano");
            }
        } catch (BusinessException e) {
            erroreLabel.setVisible(true);
            erroreLabel.setText("Utente già esistente");
        }
    }

    public void modificaUtenteAction(ActionEvent event) {
        try {
            utenteService.modificaUtente(maestro, usernameField.getText());
            dispatcher.renderView("visualizza-maestri", dispatcher.getLoggedUser());
        } catch (BusinessException e) {
            erroreLabel.setText(e.getMessage());
            erroreLabel.setVisible(true);
        }
    }

    public void rimuoviUtenteAction(ActionEvent event) {
        try {
            utenteService.rimuoviUtente(maestro.getId());
            dispatcher.renderView("visualizza-maestri", dispatcher.getLoggedUser());
        } catch (BusinessException e) {
            erroreLabel.setText(e.getMessage());
            erroreLabel.setVisible(true);
        }
    }

    public void goBack() {
        dispatcher.renderView("visualizza-maestri", dispatcher.getLoggedUser());
    }
}

