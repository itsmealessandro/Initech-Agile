package controllers;

import business.BusinessException;
import business.InitechBusinessFactory;
import business.UtenteService;
import domain.Utente;
import domain.UtenteRegistrato;
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
    private TextField username;
    @FXML
    private TextField email;
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
        registrazioneButton.disableProperty().bind(username.textProperty().isEmpty().
                                        or(email.textProperty().isEmpty().
                                                or(password.textProperty().isEmpty().
                                                        or(confermaPassword.textProperty().isEmpty()))));

        erroreRegistrazioneLabel.setVisible(false);
    }

    @FXML
    public void registrazioneAction(ActionEvent event) {
        UtenteRegistrato utente=new UtenteRegistrato();
        utente.setUsername(username.getText());
        utente.setEmail(email.getText());
        utente.setPassword(password.getText());
        try {
            if (password.getText().equals(confermaPassword.getText())) {
                if (utenteService.registrazione(utente)) {
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
