package initechApplication;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewDispatcher;

public class InitechApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewDispatcher dispatcher = ViewDispatcher.getInstance();
        dispatcher.loginView(stage);
    }
}