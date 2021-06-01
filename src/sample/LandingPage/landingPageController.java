package sample.LandingPage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class landingPageController {

    @FXML
    private JFXButton signupButton;
    @FXML
    private JFXButton loginButton;
    @FXML
    private JFXButton closeApp;
    @FXML
    private JFXButton adminBtn;

    @FXML
    void closeAppFunc(ActionEvent event) {
        Stage stage = (Stage) closeApp.getScene().getWindow();
        stage.close();
    }
    @FXML
    void signupEnter(ActionEvent event) throws IOException {
        Stage stClose = (Stage)signupButton.getScene().getWindow();
        stClose.close();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("../Signup/registrationPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void loginEnter(ActionEvent event) throws IOException {
        Stage stClose = (Stage)loginButton.getScene().getWindow();
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


    public void initialize(URL url, ResourceBundle rb){

    }
}
