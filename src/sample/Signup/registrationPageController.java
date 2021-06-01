package sample.Signup;

import com.jfoenix.controls.JFXButton;
import com.mysql.cj.protocol.Resultset;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Database.dbConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javax.swing.*;


public class registrationPageController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtPassword;
    @FXML
    private JFXButton btnBack;

    @FXML
    void backFunc(ActionEvent event) throws IOException {
        Stage stClose = (Stage)btnBack.getScene().getWindow();
        stClose.close();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../LandingPage/landingPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

@FXML
    private JFXButton BtnSignup;

    Connection conn = null;
    PreparedStatement pst = null;
    Resultset rs = null;

    @FXML
    void FuncSignup(ActionEvent event) {

        try{
            conn = dbConnection.connect();

            String check1 = txtName.getText();
            String check2 = txtUsername.getText();
            String check3 = txtEmail.getText();
            String check4 = txtPhone.getText();
            String check5 = txtPassword.getText();

            // Checking if user have not entered anything.
            if ("".equals(check1) || ("".equals(check2)) || ("".equals(check3)) || ("".equals(check4)) || ("".equals(check5))) {
                JOptionPane.showMessageDialog(null, "Please Fill all the fields");
            } else {
            // Entering the data into the database
            String sql = "INSERT INTO userstbl (name, username, email, phone, password) values (?, ? , ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtName.getText());
            pst.setString(2, txtUsername.getText());
            pst.setString(3, txtEmail.getText());
            pst.setString(4, txtPhone.getText());
            pst.setString(5, txtPassword.getText());
            // Committing to the database
            pst.execute();
            JOptionPane.showMessageDialog(null, "You are Signed up!");

            }
        // Catching an exception and displaying it.
        }catch(Exception exep){

            JOptionPane.showMessageDialog(null, exep);

        }
    }
}
