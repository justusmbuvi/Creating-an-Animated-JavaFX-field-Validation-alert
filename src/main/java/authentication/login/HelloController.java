package authentication.login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelloController {

    // Strings which hold css elements to easily re-use in the application
    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;");

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField userPassword;

    @FXML
    private Label invalidDetails;

    @FXML
    private Button cancelButton, loginButton, forgotButton;

    @FXML
    private ImageView usersIcon, passwordIcon;

    // Creation of methods which are activated on events in the forms

    // Close form
    @FXML
    protected void onCancelButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    // On login button click
    @FXML
    protected void onLoginButtonClick() throws InterruptedException {

        // In case the Username and Password fields are left blank then display the error message
        if (usernameTextField.getText().isBlank() || userPassword.getText().isBlank()) {
            invalidDetails.setStyle(errorMessage);

            // When the username and password are blank
            if (usernameTextField.getText().isBlank() && userPassword.getText().isBlank()) {
                invalidDetails.setText("The Login fields are required!");
                usernameTextField.setStyle(errorStyle);
                userPassword.setStyle(errorStyle);

                new animatefx.animation.Shake(usernameTextField).play();
                new animatefx.animation.Wobble(usersIcon).play();
                new animatefx.animation.Shake(userPassword).play();
                new animatefx.animation.Wobble(passwordIcon).play();

            } else // When only the username is blank
                if (usernameTextField.getText().isBlank()) {
                    usernameTextField.setStyle(errorStyle);
                    invalidDetails.setText("The Username or Email is required!");
                    userPassword.setStyle(successStyle);
                    new animatefx.animation.Shake(usernameTextField).play();
                    new animatefx.animation.Pulse(usersIcon).play();
                } else // When only the password is blank
                    if (userPassword.getText().isBlank()) {
                        userPassword.setStyle(errorStyle);
                        invalidDetails.setText("The Password is required!");
                        usernameTextField.setStyle(successStyle);
                        new animatefx.animation.Shake(userPassword).play();
                        new animatefx.animation.Wobble(passwordIcon).play();
                    }
        } else // Check if password is less than four characters, if so display error message
            if (userPassword.getText().length() < 4) {
                invalidDetails.setText("The Password can't be less than 4 characters!");
                invalidDetails.setStyle(errorMessage);
                userPassword.setStyle(errorStyle);
                new animatefx.animation.FadeIn(userPassword).play();
                new animatefx.animation.Wobble(passwordIcon).play();
            }
            // If all login details are entered as required then display success message
            else {
                invalidDetails.setText("Login Successful!");
                invalidDetails.setStyle(successMessage);
                usernameTextField.setStyle(successStyle);
                userPassword.setStyle(successStyle);
                new animatefx.animation.Tada(invalidDetails).play();
            }
    }
}