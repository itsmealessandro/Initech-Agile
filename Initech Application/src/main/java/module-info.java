module initechapp.initechapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens initechapp.initechapplication to javafx.fxml;
    exports initechapp.initechapplication;
}