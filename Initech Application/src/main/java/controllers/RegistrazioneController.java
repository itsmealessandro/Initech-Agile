package controllers;

import business.BusinessException;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.Utente;
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

public class RegistrazioneController implements Initializable, DataInitializable<Utente>{

    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField eta;
    @FXML
    private TextField codiceFiscale;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confermaPassword;
    @FXML
    private Button registrazioneButton;
    @FXML
    private Label erroreRegistrazioneLabel;

    private ViewDispatcher dispatcher;
    private UtenteService utenteService;

    public RegistrazioneController() {
        InitechBusinessFactory factory = InitechBusinessFactory.getInstance();
        utenteService = factory.getUtenteService();
        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registrazioneButton.disableProperty().bind(nome.textProperty().isEmpty().
                or(cognome.textProperty().isEmpty().
                        or(eta.textProperty().isEmpty().
                                or(codiceFiscale.textProperty().isEmpty().
                                        or(username.textProperty().isEmpty().
                                                or(password.textProperty().isEmpty().
                                                        or(confermaPassword.textProperty().isEmpty())))))));

        erroreRegistrazioneLabel.setVisible(false);
    }

    @FXML
    public void registrazioneAction(ActionEvent event) {

        try {
            if (password.getText().equals(confermaPassword.getText())) {
                if (utenteService.registrazione(nome.getText(), cognome.getText(),
                        Integer.valueOf(eta.getText()), codiceFiscale.getText(), username.getText(), password.getText())) {
                    dispatcher.logout();
                } else {
                    erroreRegistrazioneLabel.setVisible(true);
                    erroreRegistrazioneLabel.setText("Username già esistente");
                }

            } else {
                erroreRegistrazioneLabel.setVisible(true);
                erroreRegistrazioneLabel.setText("Le password inserite non combaciano");
            }
        } catch (BusinessException e) {
            erroreRegistrazioneLabel.setVisible(true);
            erroreRegistrazioneLabel.setText("Utente già esistente");
        }

    }

    public void goBack() {
        dispatcher.logout();;
    }

}
