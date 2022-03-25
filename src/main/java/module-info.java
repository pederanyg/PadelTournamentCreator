module edu.ntnu.k2g3.idatt1002.Controllers {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens edu.ntnu.k2g3.idatt1002 to javafx.fxml;
    exports edu.ntnu.k2g3.idatt1002;
    opens edu.ntnu.k2g3.idatt1002.Controllers to javafx.fxml;
    exports edu.ntnu.k2g3.idatt1002.Controllers;
}