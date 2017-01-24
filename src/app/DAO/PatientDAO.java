package app.DAO;

import app.DbUtil.Util;
import app.Models.Patient;
import app.SecurityProvider.SecureProvider;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Piotr Urban on 13.01.2017.
 */
public class PatientDAO {

    private static final String create = "INSERT INTO Users (Personal_id, Pass, Name, Surname, Email, Birthday, Gender, " +
            "Mobile_no, Landline_no, Contact_name, Contact_no, City, Postal_code, Street, Dwelling) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String read = "Select * from Users where Personal_id = ?";
    private static final String authorize = "Select Pass from Users where Personal_id = ?";


    public Patient read(String pesel) {

        Patient resultPatient = null;

        try {
            Connection connection = Util.dbConnect();
            ResultSet resultSet;
            PreparedStatement preparedStatement = connection.prepareStatement(read);
            preparedStatement.setString(1, pesel);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                resultPatient = new Patient();
                resultPatient.setPesel(resultSet.getString("Personal_id"));
                resultPatient.setEmail(resultSet.getString("Email"));
                resultPatient.setImie(resultSet.getString("Name"));
                resultPatient.setNazwisko(resultSet.getString("Surname"));
                resultPatient.setHaslo(resultSet.getString("Pass"));
                resultPatient.setDataUrodzenia(resultSet.getDate("Birthday"));
                resultPatient.setPlec(resultSet.getString("Gender"));
                resultPatient.setNumerKomorkowy(resultSet.getString("Mobile_no"));
                resultPatient.setNumerStacjonarny(resultSet.getString("Landline_no"));
                resultPatient.setOsobaKontaktowa(resultSet.getString("Contact_name"));
                resultPatient.setOsobaKontaktowa_no(resultSet.getString("Contact_no"));
                resultPatient.setMiejscowosc(resultSet.getString("City"));
                resultPatient.setKodPocztowy(resultSet.getString("Postal_code"));
                resultPatient.setUlica(resultSet.getString("Street"));
                resultPatient.setNumerDomu(resultSet.getString("Dwelling"));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultPatient;
    }

    public static boolean create(Patient patient) {

        Connection conn = null;
        PreparedStatement prepStmt = null;
        int rows;
        boolean result = false;

        try {
            conn = Util.dbConnect();
            prepStmt = conn.prepareStatement(create);
            prepStmt.setString(1, patient.getPesel());
            prepStmt.setString(2, patient.getHaslo());
            prepStmt.setString(3, patient.getImie());
            prepStmt.setString(4, patient.getNazwisko());
            prepStmt.setString(5, patient.getEmail());
            prepStmt.setDate(6, patient.getDataUrodzenia());
            prepStmt.setString(7, patient.getPlec());
            prepStmt.setString(8, patient.getNumerKomorkowy());
            prepStmt.setString(9, patient.getNumerStacjonarny());
            prepStmt.setString(10, patient.getOsobaKontaktowa());
            prepStmt.setString(11, patient.getOsobaKontaktowa_no());
            prepStmt.setString(12, patient.getMiejscowosc());
            prepStmt.setString(13, patient.getKodPocztowy());
            prepStmt.setString(14, patient.getUlica());
            prepStmt.setString(15, patient.getNumerDomu());

            rows = prepStmt.executeUpdate();
            if (rows != 0) result = true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    public static boolean authorize(String pesel, String pass, Label label) {

        String password = "";
        Connection connection = null;
        boolean result = false;

        try {
            connection = Util.dbConnect();
            ResultSet resultSet;
            PreparedStatement preparedStatement = connection.prepareStatement(authorize);
            preparedStatement.setString(1, pesel);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                password = resultSet.getString("Pass");
                return result = SecureProvider.checkPassword(pass, password);

            } else {
                label.setText("Podany użytkownik nie istnieje");
                result = false;
                return result;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
