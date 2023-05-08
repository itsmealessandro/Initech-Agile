package controllers;

import business.BusinessException;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.Utente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.ViewDispatcher;

import java.net.URL;
import java.util.ResourceBundle;

public class GestioneProfiloController implements DataInitializable<Utente>, Initializable {


    @FXML
    TextField usernameField;
    @FXML
    TextField emailField;
    @FXML
    PasswordField passwordField;
    @FXML
    Button salvaButton;
    @FXML
    Label errorLabel;


    Utente utente;
    UtenteService utenteService;

    ViewDispatcher dispatcher;

    public GestioneProfiloController() {
        utenteService = InitechBusinessFactory.getInstance().getUtenteService();
        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initializeData(Utente utente) {

        this.utente = utente;
        usernameField.setText(utente.getUsername());
        emailField.setText(utente.getEmail());
        passwordField.setText(utente.getPassword());


        // se non sono stati modificati i campi il bottone non è cliccabile
        salvaButton.disableProperty().bind(
                usernameField.textProperty().isEqualTo(utente.getUsername()).and(
                        emailField.textProperty().isEqualTo(utente.getEmail()).and(
                                passwordField.textProperty().isEqualTo(utente.getPassword())
                        )

                ));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        errorLabel.setVisible(false);


    }


    @FXML
    public void salvaAction() {

        try {
            Utente nuovoUtente = new Utente();

            nuovoUtente.setUsername(this.utente.getUsername());

            nuovoUtente.setEmail(emailField.getText());
            nuovoUtente.setPassword(passwordField.getText());

            utenteService.modificaUtente(nuovoUtente, usernameField.getText());
            nuovoUtente.setUsername(usernameField.getText());

            dispatcher.renderView("Home", nuovoUtente);

        } catch (BusinessException exception) {

            errorLabel.setText(exception.getMessage());
            errorLabel.setVisible(true);
        }


    }
}
