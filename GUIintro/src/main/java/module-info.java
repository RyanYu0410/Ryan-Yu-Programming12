module com.example.guiintro {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.guiintro to javafx.fxml;
    exports com.example.guiintro;
}