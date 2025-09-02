module com.ib.rentalManagementApplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    exports com.ib.rentalManagementApplication;
    opens com.ib.rentalManagementApplication to javafx.fxml;
    exports com.ib.rentalManagementApplication.controller;
    opens com.ib.rentalManagementApplication.controller to javafx.fxml;
}
