package sample.Donations;

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
import sample.Volunteer.volunteerRegController;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class donationPageController {
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtAmount;
    @FXML
    private TextField txtPurpose;
    @FXML
    private TextField txtComment;
    @FXML
    private TextField txtCard;
    @FXML
    private TextField txtCVV;
    @FXML
    private JFXButton btnDonate;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnBack;

    Connection conn= null;
    PreparedStatement pst = null;

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
    @FXML
    void funcDonate(ActionEvent event) {
        try {
            conn = dbConnection.connect();
            String sql = "INSERT INTO donationstbl (amount, purpose, comment, cardno, cvv) values (?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txtAmount.getText());
            pst.setString(2, txtPurpose.getText());
            pst.setString(3, txtComment.getText());
            pst.setString(4, txtCard.getText());
            pst.setString(5, txtCVV.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Saved, Thank you for your support");

        } catch (SQLException ex) {
            Logger.getLogger(volunteerRegController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void funcDelete(ActionEvent event) {
        String ID = txtID.getText();
        try {
            conn = dbConnection.connect();
            Statement state = conn.createStatement();

            state.executeUpdate(" DELETE FROM donationstbl WHERE ID='"+ID+"'");

            JOptionPane.showMessageDialog(null, "Record Deleted, Sorry to see you go");
        }
        catch(Exception exc) {
            exc.printStackTrace();
        }
    }

    @FXML
    void funcUpdate(ActionEvent event) {
        String ID = txtID.getText();
        String Amount = txtAmount.getText();
        String Purpose = txtPurpose.getText();
        String Comment = txtComment.getText();
        String CardNo = txtCard.getText();
        String CVV = txtCVV.getText();

        try {
            conn = dbConnection.connect();
            Statement state = conn.createStatement();

            String sql=" update donationstbl set amount='"+Amount+"', purpose ='"+Purpose+"',comment = '"+Comment+"', cardno ='"+CardNo+"', cvv='"+CVV+"'  Where id ='"+ID+"'" ;
            state.execute(sql);

            int myresult = state.executeUpdate(sql);

            if(myresult == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Updated Record");
            }
            else {
                JOptionPane.showMessageDialog(null, "That Record Does Not Exist");
            }
        }
        catch(Exception exc) {
            exc.printStackTrace();
        }
    }
}
