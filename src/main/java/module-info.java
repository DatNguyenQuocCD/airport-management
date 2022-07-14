module com.example.datnguyen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.datnguyen to javafx.fxml;
    exports com.example.datnguyen;
}