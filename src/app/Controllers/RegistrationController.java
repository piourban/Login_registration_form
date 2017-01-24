package app.Controllers;

import app.DAO.PatientDAO;
import app.Models.Patient;
import app.SecurityProvider.SecureProvider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 * Created by Piotr Urban on 13.01.2017.
 */
public class RegistrationController extends SecureProvider implements Initializable {

    //Account details
    @FXML
    TextField txtPassword;
    @FXML
    TextField txtRepeated;
    @FXML
    TextField txtEmail;

    //Dane personalne
    @FXML
    TextField txtImie;
    @FXML
    TextField txtNazwisko;
    @FXML
    TextField txtPesel;
    @FXML
    DatePicker dataUrodzenia;
    @FXML
    ChoiceBox choicePlec;

    //Dane kontaktowe
    @FXML
    TextField txtKom;
    @FXML
    TextField txtStacj;
    @FXML
    TextField txtImieKontakt;
    @FXML
    TextField txtNumerKontakt;

    //Adres
    @FXML
    TextField txtMiejscowosc;
    @FXML
    TextField txtKod;
    @FXML
    TextField txtUlica;
    @FXML
    TextField txtLokal;

    @FXML
    Label errorOut;
    @FXML
    Button btnRegister;
    @FXML
    Button btnClose;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ObservableList<String> options = FXCollections.observableArrayList("Kobieta", "Mężczyzna");
        choicePlec.setItems(options);
        choicePlec.getSelectionModel().selectFirst();

        validateImie();
        validateNazwisko();
        validatePesel();
        validateEmail();
        validatePassword();
        validateContactPersonName();
        validateContactPersonNo();
        validateDataUrodzenia();
        validateLandlinePhone();
        validateMobilePhone();
        validatePostalCode();
        validateCity();
        validateStreet();
        validateRepeatedPassword();
        validateLocale();

    }

    // Walidacja szczegolow konta

    private void validatePesel() {

        txtPesel.setOnKeyReleased(event -> {

            if (txtPesel.isPressed() == false) {

                Pattern p = Pattern.compile("^[0-9]{11}$");
                Matcher m = p.matcher(txtPesel.getText());


                if (m.find()) {
                    errorOut.setVisible(false);
                    validateGender();
                } else {
                    txtPesel.getStyleClass().add("errorOut");
                    errorOut.setText("Numer pesel jest nieprawidłowy");
                }
            }
        });
    }

    private void validatePassword() {

        validationKeyReleased(txtPassword, "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", "Hasło musi zawierać minimum 8 znaków" + "\n" + "w tym 1 dużą literę, cyfrę oraz znak specjalny");
    }

    private void validateRepeatedPassword() {

        txtRepeated.setOnKeyReleased(event -> {

            if (txtPassword.getText().equals(txtRepeated.getText())) {
                errorOut.setVisible(false);
                txtRepeated.getStyleClass().remove("errorOut");

            } else {
                txtRepeated.getStyleClass().add("errorOut");
                errorOut.setText("Podane hasła nie są zgodne");
            }
        });
    }

    private void validateEmail() {

        validationKeyReleased(txtEmail, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", "Podany email jest nieprawidłowe");
    }

    // Walidacja danych presonalnych

    private void validateImie() {

        validationKeyReleased(txtImie, "^[a-zA-Z]{3,}$", "Podane imię jest nieprawidłowe");
    }

    private void validateNazwisko() {

        validationKeyReleased(txtNazwisko, "^[a-zA-Z]{3,}+$", "Podane nazwisko jest nieprawidłowe");
    }


    public void validateDataUrodzenia() {

        dataUrodzenia.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                if (dataUrodzenia.getValue() != null) {

                    LocalDate todayDate = LocalDate.now();
                    LocalDate birthday = dataUrodzenia.getValue();
                    int userAge = (int) ChronoUnit.YEARS.between(birthday, todayDate);

                    if (birthday.isAfter(todayDate)) {
                        errorOut.setText("Data urodzenia jest nieprawidłowa");

                    } else if (userAge < 18) {
                        errorOut.setText("Jedynie osoby pełnoletnie mogą sie zarejestrować");
                    } else {
                        errorOut.setVisible(false);
                    }
                }
            }
        });
    }

    public void validateGender() {

        String gender = "";
        choicePlec.setValue(gender = txtPesel.getText().charAt(9) % 2 == 0 ? "Kobieta" : "Mężczyzna");
    }

// Walidacja danych kontaktowych

    private void validateMobilePhone() {

        validationKeyReleased(txtKom, "^\\d{9}$", "Podane numer komórkowy jest nieprawidłowy");
    }

    private void validateLandlinePhone() {

        validationKeyReleased(txtStacj, "^\\d{11}$", "Podane numer stacjonarny jest nieprawidłowy");
    }

    private void validateContactPersonName() {

        validationKeyReleased(txtImieKontakt, "^[a-zA-Z]{3,}+$", "Podane imie jest nieprawidłowe");
    }

    private void validateContactPersonNo() {

        validationKeyReleased(txtNumerKontakt, "^\\d{11}$|^\\d{9}$", "Podane numer jest nieprawidłowy");
    }

// Walidacja adresu

    private void validateCity() {

        validationKeyReleased(txtMiejscowosc, "^[a-zA-Z]{3,}+$", "Podana miejscowość nie istnieje");
    }

    private void validatePostalCode() {

        validationKeyReleased(txtKod, "^\\d{2}-\\d{3}$", "Kod pocztowy ma niewłaściwy format");
    }

    private void validateStreet() {

        validationKeyReleased(txtUlica, "^[a-zA-Z]{3,}+$", "Podana ulica nie istnieje");
    }

    private void validateLocale() {

        validationKeyReleased(txtLokal, "^[a-zA-Z_0-9-/]+$", "Podany numer jest nieprawidłowy");
    }

    private void validationKeyReleased(TextField txt, String pattern, String error) {

        txt.setOnKeyReleased(event -> {

            if (txt.isPressed() == false) {

                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(txt.getText());

                if (m.find()) {
                    errorOut.setVisible(false);
                    txt.getStyleClass().remove("errorOut");
                    btnRegister.setDisable(false);
                    //System.out.println(txtImie.getText().toLowerCase().substring(0,1).toUpperCase()+txtImie.getText().toLowerCase().substring(1,txtImie.getLength()));
                } else {
                    btnRegister.setDisable(true);
                    txt.getStyleClass().add("errorOut");
                    errorOut.getStyleClass().add("labelError");
                    errorOut.setText(error);
                }
            }
        });
    }

    @FXML
    private void submitPress(ActionEvent event) throws IOException {

        String hashed = SecureProvider.hashPassword(txtPassword.getText());
        boolean result = false;

        ArrayList<TextField> txt = new ArrayList<>();
        txt.add(txtEmail);
        txt.add(txtImie);
        txt.add(txtNazwisko);
        txt.add(txtPesel);
        txt.add(txtPassword);
        txt.add(txtRepeated);
        txt.add(txtKom);
        txt.add(txtImieKontakt);
        txt.add(txtNumerKontakt);
        txt.add(txtMiejscowosc);
        txt.add(txtKod);
        txt.add(txtUlica);
        txt.add(txtLokal);

        for (TextField tf : txt) {

            try {
                if (tf.getText().equals("") || choicePlec.getValue().equals("") || dataUrodzenia.getValue().equals(null)) {
                    result = false;
                    break;
                } else result = true;
            } catch (NullPointerException e) {
                result = false;
            }
        }

        if (result == true)

        {
            Patient patient = new Patient();
            patient.setHaslo(hashed);
            patient.setEmail(txtEmail.getText());
            patient.setImie(txtImie.getText());
            patient.setNazwisko(txtNazwisko.getText());
            patient.setPesel(txtPesel.getText());
            patient.setDataUrodzenia(Date.valueOf(dataUrodzenia.getValue()));
            patient.setPlec(String.valueOf(choicePlec.getValue()));
            patient.setNumerKomorkowy(txtKom.getText());
            patient.setNumerStacjonarny(txtStacj.getText());
            patient.setOsobaKontaktowa(txtImieKontakt.getText());
            patient.setOsobaKontaktowa_no(txtNumerKontakt.getText());
            patient.setMiejscowosc(txtMiejscowosc.getText());
            patient.setKodPocztowy(txtKod.getText());
            patient.setUlica(txtUlica.getText());
            patient.setNumerDomu(txtLokal.getText());

            PatientDAO.create(patient);

            for (TextField tf : txt) {

                tf.clear();
            }
            dataUrodzenia.setValue(null);
            txtStacj.setText("");

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Registration successfully", ButtonType.OK);
            alert.initStyle(StageStyle.UTILITY);
            alert.show();

            if (alert.getResult() == ButtonType.OK) {
                alert.close();
            }

        } else errorOut.setText("Uzupełnij wszystkie potrzebne informacje");
    }

    @FXML
    private void cancelAction(ActionEvent event) throws IOException {

        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}





