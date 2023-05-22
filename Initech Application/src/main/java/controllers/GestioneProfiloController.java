package controllers;

import business.BusinessException;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.Socio;
import domain.Utente;
import domain.UtenteRegistrato;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import view.ViewDispatcher;

import java.net.URL;
import java.util.*;

public class GestioneProfiloController implements DataInitializable<Utente>, Initializable {

    @FXML
    Text commentText;
    @FXML
    Separator centerSeparator;
    @FXML
    TextField usernameField;
    @FXML
    TextField emailField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label walletLabel;
    @FXML
    ComboBox<Double> walletComboBox;
    @FXML
    Button salvaButton;
    @FXML
    Button confermaButton;
    @FXML
    Label errorLabel;

    private HashSet<Double> ricarica;

    Utente utente;
    UtenteService utenteService;
    ViewDispatcher dispatcher;

    public GestioneProfiloController() {
        utenteService = InitechBusinessFactory.getInstance().getUtenteService();
        dispatcher = ViewDispatcher.getInstance();
        ricarica = new HashSet<>();
        ricarica.add(5.0);ricarica.add(10.0);ricarica.add(15.0);ricarica.add(20.0);ricarica.add(25.0);
        ricarica.add(30.0);ricarica.add(35.0);ricarica.add(40.0);ricarica.add(45.0);ricarica.add(50.0);

    }

    @Override
    public void initializeData(Utente utente) {

        this.utente = utente;
        usernameField.setText(utente.getUsername());
        emailField.setText(utente.getEmail());
        passwordField.setText(utente.getPassword());

        confermaButton.setVisible(false);
        commentText.setVisible(false);
        centerSeparator.setVisible(false);
        walletLabel.setVisible(false);
        walletComboBox.setVisible(false);
        List<Double> sortedRicarica = new ArrayList<>(ricarica);
        Collections.sort(sortedRicarica);
        walletComboBox.getItems().addAll(sortedRicarica);

        if(utente instanceof UtenteRegistrato){
            UtenteRegistrato utenteRegistrato = (UtenteRegistrato)utente;
            walletLabel.setText("Questo è il tuo credito: " + utenteRegistrato.getWallet());
            walletComboBox.setVisible(true);
            walletLabel.setVisible(true);
            centerSeparator.setVisible(true);
            commentText.setVisible(true);
            confermaButton.setVisible(true);
        } else if (utente instanceof Socio){
            Socio socio = (Socio) utente;
            walletLabel.setText("Questo è il tuo credito: " + socio.getWallet());
            walletComboBox.setVisible(true);
            walletLabel.setVisible(true);
            centerSeparator.setVisible(true);
            commentText.setVisible(true);
            confermaButton.setVisible(true);
        }


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

    @FXML
    public void confermaAction(){

        if(utente instanceof UtenteRegistrato){
            UtenteRegistrato utenteRegistrato = (UtenteRegistrato)utente;
            utenteRegistrato.setWallet(utenteRegistrato.getWallet() + walletComboBox.getValue());
        } else if (utente instanceof Socio){
            Socio socio = (Socio) utente;
            socio.setWallet(socio.getWallet() + walletComboBox.getValue());
        }
        dispatcher.renderView("gestione-profilo",utente);
    }

}
