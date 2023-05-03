package controller;

import business.BusinessException;
import business.CouprojectBusinessFactory;
import business.UtenteNotFoundException;
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
import view.ViewException;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable, DataInitializable<Utente> {

    @FXML
    private Label loginErrorLabel;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Button registrazioneButton;

    private UtenteService utenteService;

    private ViewDispatcher dispatcher;

    public LoginController() {
        CouprojectBusinessFactory factory = CouprojectBusinessFactory.getInstance();
        utenteService = factory.getUtenteService();
        dispatcher = ViewDispatcher.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginButton.disableProperty().bind(username.textProperty().isEmpty().or(password.textProperty().isEmpty()));
    }

    @FXML
    public void loginAction(ActionEvent event) {
        try {
            Utente utente = utenteService.authenticate(username.getText(), password.getText());
            dispatcher.loggedIn(utente);
        } catch (UtenteNotFoundException e) {
            loginErrorLabel.setText("Username e/o password errati!");
        } catch (BusinessException e) {
            dispatcher.renderError(e);
        }
    }

    @FXML
    public void registrazioneAction(ActionEvent event) throws ViewException {
        dispatcher.registrazioneView();
    }
}
