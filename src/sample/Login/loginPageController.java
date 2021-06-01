package sample.Login;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Database.dbConnection;

import javax.swing.*;

public class loginPageController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private JFXButton BtnLogin;
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

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    Connection FuncLogin(ActionEvent event) {
        try{
            conn = dbConnection.connect();

            String sql = "SELECT * FROM userstbl WHERE username = ? and password = ?";

            pst = conn.prepareStatement(sql);
            pst.setString(1, txtUsername.getText());
            pst.setString(2, txtPassword.getText());

            rs = pst.executeQuery();

            if(rs.next()){

                JOptionPane.showMessageDialog(null, "Login Successful");
                try {
                    Stage stClose = (Stage)BtnLogin.getScene().getWindow();
                    stClose.close();
                    Parent root;
                    root = FXMLLoader.load(getClass().getResource("../Dashboard/dashboard.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.initStyle(StageStyle.UNDECORATED);
                    stage.setScene(scene);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception exc){
                    System.out.println(exc);
                }
            }else{

                JOptionPane.showMessageDialog(null, "Invalid username or password");

            }

        }catch (Exception ex){

        }

        return conn;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}