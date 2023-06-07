import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import view.ViewDispatcher;
import view.ViewException;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;


@ExtendWith(ApplicationExtension.class)
class LoginControllerTest {

    @Start
    void onStart(Stage stage) throws ViewException {
        ViewDispatcher dispatcher = ViewDispatcher.getInstance();
        dispatcher.loginView(stage);
    }

    @Test
    void errorLabelText() {
        verifyThat("#loginErrorLabel", hasText(""));
    }

    @Test
    void ShouldClickOnLoginButton(FxRobot robot) {
        // when:
        robot.clickOn("#loginButton");

        // then:
        verifyThat("#loginButton", hasText("Login"));
    }
}