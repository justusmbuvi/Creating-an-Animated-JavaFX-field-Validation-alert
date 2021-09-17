module authentication.login {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires AnimateFX;

    opens authentication.login to javafx.fxml;
    exports authentication.login;
}