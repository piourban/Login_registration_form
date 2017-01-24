package app.Controllers;

import app.DAO.PatientDAO;
import app.DbUtil.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    TextField txtPesel;
    @FXML
    TextField txtPassword;
    @FXML
    Button btnLogin;
    @FXML
    Button btnRegister;
    @FXML
    Label passwordError;
    @FXML
    Label peselError;


    @FXML
    private void createPress(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/app/Views/register.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        root1.getStylesheets().add("/app/Views/gui.css");
        Stage stage = new Stage();
        stage.setTitle("Registration form");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void loginPressed(ActionEvent event) throws IOException {

        String pesel = txtPesel.getText();
        String haslo = txtPassword.getText();


        if (pesel.equals("")) {

            txtPassword.setStyle(null);
            txtPesel.setStyle("-fx-border-color: red;");
            peselError.setText("Podaj numer pesel");

        } else if (haslo.equals("")) {

            txtPesel.setStyle(null);
            txtPassword.setStyle("-fx-border-color: red;");
            passwordError.setText("Podaj hasło");

        } else {
            txtPesel.setStyle(null);
            txtPassword.setStyle(null);
            passwordError.setText("");
            peselError.setText("");

            if (PatientDAO.authorize(pesel, haslo, peselError)) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You have logged in successfully", ButtonType.OK);
                alert.initStyle(StageStyle.UTILITY);
                alert.show();

                if (alert.getResult() == ButtonType.OK) {
                    alert.close();
                }
            } else passwordError.setText("Podano nieprawidłowe hasło");

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
