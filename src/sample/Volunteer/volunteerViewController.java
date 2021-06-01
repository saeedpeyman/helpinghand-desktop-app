package sample.Volunteer;

import Models.voluntmdl;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Database.dbConnection;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class volunteerViewController implements Initializable {

    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton btnShow;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnInsert;
    @FXML
    private TextField txtIDSelect;
    @FXML
    private TableColumn<voluntmdl, String> tblTiming;
    @FXML
    private TableColumn<voluntmdl, String> tblDay;
    @FXML
    private TableColumn<voluntmdl, Integer> tblID;

    Connection conn = null;
    PreparedStatement pst = null;

    ObservableList<voluntmdl> list;
    @FXML
    private TableView<voluntmdl> tblSchedule;

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
    private void funcDelete(ActionEvent event) {
        conn = dbConnection.connect();

        String sql = "DELETE FROM volunteerstbl WHERE id=?";

        int index = tblSchedule.getSelectionModel().getSelectedIndex();
        Integer pID = tblID.getCellData(index);

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, pID);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Deleted");

        } catch (SQLException exc) {
            System.out.println(exc + "Happened");
        }
    }

    @FXML
    private void funcInsert(ActionEvent event) throws IOException {
        Stage stClose = (Stage)btnBack.getScene().getWindow();
        stClose.close();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../Volunteer/volunteerReg.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void funcShow(ActionEvent event) {
        list = dbConnection.getVolInfo();
        tblSchedule.setItems(list);
    }

    @FXML
    private void getSelectedRow(MouseEvent event) {
        int index = tblSchedule.getSelectionModel().getSelectedIndex();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblTiming.setCellValueFactory(new PropertyValueFactory<voluntmdl, String >("timing"));
        tblDay.setCellValueFactory(new PropertyValueFactory<voluntmdl, String > ("days"));
        tblID.setCellValueFactory(new PropertyValueFactory<voluntmdl, Integer>  ("id"));
    }
}
