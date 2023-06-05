package initechApplication;

import domain.Amministratore;
import domain.Utente;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import view.ViewDispatcher;
import view.ViewException;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

@ExtendWith(ApplicationExtension.class)
class InitechApplicationTest {


    private ViewDispatcher dispatcher;
    private Stage stage;


    @Start
    void onStart(Stage stage) throws ViewException {

        this.stage = stage;
        dispatcher = ViewDispatcher.getInstance();
        dispatcher.loginView(stage);

    }

    @Test
    void should_contain_first_button() throws ViewException {
        // expect:

        verifyThat("#loginButton", hasText("Login"));
    }


}