/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nckey Larson
 */
public class LoginPageController implements Initializable {

    @FXML
    private JFXTextField tf_user;
    @FXML
    private JFXTextField tf_pass;
    @FXML
    private Button btn_login;
    @FXML
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) throws IOException {
      
        
    
    if((tf_pass.getText().equals("admin"))&&(tf_user.getText().equals("admin")))
    {
        Stage stage = (Stage) btn_login.getScene().getWindow();
        stage.close();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/GUI/Homepage_2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage1 = new Stage();
        stage1.setTitle("Back Office");
        stage1.setScene(scene);
        stage1.show();
        
    } 
    
    
    else {
       tf_pass.clear();
       tf_user.clear();
        loginfailed();
   
        }
    
    
     
        
    }
    
    
    private void loginfailed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
         alert.setHeaderText(null);
        alert.setContentText("username and password 8alet");
 
        alert.showAndWait();
    } 
}
