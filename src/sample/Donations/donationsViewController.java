package sample.Donations;

import Models.donationmdl;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Database.dbConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class donationsViewController implements Initializable {

    @FXML
    private JFXButton btnBack;
    @FXML
    private TableView<donationmdl> tblDonations;
    @FXML
    private TableColumn<donationmdl, Integer> colID;
    @FXML
    private TableColumn<donationmdl, Integer> colAmount;
    @FXML
    private TableColumn<donationmdl, String> colPurpose;
    @FXML
    private TableColumn<donationmdl, String> colComment;

    Connection conn = null;
    PreparedStatement pst = null;
    ObservableList<donationmdl> list;

    @FXML
    private JFXButton btnShow;
    @FXML
    private JFXButton btnInsert;
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
    private void funcInsert(ActionEvent event) throws IOException {
        Stage stClose = (Stage)btnBack.getScene().getWindow();
        stClose.close();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../Donations/donationPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void funcShow(ActionEvent event) {
        list = dbConnection.getDonationInfo();
        tblDonations.setItems(list);
    }

    @FXML
    private void getSelectedRow(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colID.setCellValueFactory(new PropertyValueFactory<donationmdl, Integer>("id"));
        colAmount.setCellValueFactory(new PropertyValueFactory<donationmdl, Integer>("amount"));
        colPurpose.setCellValueFactory(new PropertyValueFactory<donationmdl, String>("purpose"));
        colComment.setCellValueFactory(new PropertyValueFactory<donationmdl, String>("comment"));
    }
}
