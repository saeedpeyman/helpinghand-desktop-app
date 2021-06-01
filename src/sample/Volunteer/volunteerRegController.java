package sample.Volunteer;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Database.dbConnection;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class volunteerRegController {
    @FXML
    private TextField txtTiming;
    @FXML
    private JFXButton btnEven;
    @FXML
    private JFXButton btnOdd;
    @FXML
    private JFXButton btnFri;
    @FXML
    private JFXButton btnBack;
    @FXML

    Connection conn= null;
    PreparedStatement pst = null;

@FXML
    private void evenRegister(ActionEvent event) {
            String days = "Saturday, Monday, Wednesday";
        try {
            conn = dbConnection.connect();
            String sql = "INSERT INTO volunteerstbl (days, timing) values (?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, days);
            pst.setString(2, txtTiming.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Saved, We will call you to confirm registration");

        } catch (SQLException ex) {
            Logger.getLogger(volunteerRegController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void friRegister(ActionEvent event) {
            String days = "Fridays";
        try {
            conn = dbConnection.connect();
            String sql = "INSERT INTO volunteerstbl (days, timing) values (?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, days);
            pst.setString(2, txtTiming.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Saved, We will call you to confirm registration");

        } catch (SQLException ex) {
            Logger.getLogger(volunteerRegController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void oddRegister(ActionEvent event) {
            String days = "Sunday, Tuesday, Thursday";
        try {
            conn = dbConnection.connect();
            String sql = "INSERT INTO volunteerstbl (days, timing) values (?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, days);
            pst.setString(2, txtTiming.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Saved, We will call you to confirm registration");

        } catch (SQLException ex) {
            Logger.getLogger(volunteerRegController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void backFunc(ActionEvent event) throws IOException {
        Stage stClose = (Stage)btnBack.getScene().getWindow();
        stClose.close();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../Dashboard/dashboard.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }
}
