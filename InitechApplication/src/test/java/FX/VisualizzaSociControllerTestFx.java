package FX;

import domain.Amministratore;
import domain.Utente;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import view.ViewDispatcher;
import view.ViewException;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

@ExtendWith(ApplicationExtension.class)
class VisualizzaSociControllerTestFx {


    @Start
    void onStart(Stage stage) throws ViewException {


        ViewDispatcher dispatcher = ViewDispatcher.getInstance();
        Utente admin = new Amministratore();
        dispatcher.loginView(stage);

        dispatcher.loggedIn(admin);
        dispatcher.renderView("visualizza-soci", new Amministratore());

    }

    @Test
    void verificaLabel() {
        verifyThat("#errorLabel", hasText("error label"));
    }


}