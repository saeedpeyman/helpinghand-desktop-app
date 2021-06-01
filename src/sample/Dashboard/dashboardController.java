package sample.Dashboard;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {

    @FXML
    private JFXButton btnMakeDonation;
    @FXML
    private JFXButton btnViewDonations;
    @FXML
    private JFXButton btnRegisterVolunteering;
    @FXML
    private JFXButton btnViewVolunteering;
    @FXML
    private JFXButton btnBack;

//    Button Actions
    @FXML
    void donationsMake(ActionEvent event) {
        try{
            Stage stClose = (Stage)btnMakeDonation.getScene().getWindow();
            stClose.close();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("../Donations/donationPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();

        }catch(Exception ex){
            System.out.println(ex + "Happened");
        }
    }

    @FXML
    private void volunteerReg(ActionEvent event) {
        try{
            Stage stClose = (Stage)btnRegisterVolunteering.getScene().getWindow();
            stClose.close();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("../Volunteer/volunteerReg.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
        }catch(Exception ex){
            System.out.println(ex + "Happened");
        }
    }

    @FXML
    private void donationsView(ActionEvent event) {
        try{
            Stage stClose = (Stage)btnViewDonations.getScene().getWindow();
            stClose.close();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("../Donations/donationsView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
        }catch(Exception ex){
            System.out.println(ex + "Happened");
        }
    }

    @FXML
    private void volunteerView(ActionEvent event) {
        try{
            Stage stClose = (Stage)btnViewVolunteering.getScene().getWindow();
            stClose.close();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("../Volunteer/volunteerView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.setScene(scene);
            stage.show();
        }catch(Exception ex){
            System.out.println(ex + "Happened");
        }
    }

    @FXML
    void backFunc(ActionEvent event) throws IOException {
        Stage stClose = (Stage)btnBack.getScene().getWindow();
        stClose.close();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../Login/loginPage.fxml"));
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
}
