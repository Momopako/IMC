module com.example.imc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.imc to javafx.fxml;
    exports com.example.imc;
}