/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Utilities.datasource;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
Connection conn =datasource.getInstance().getConnection(); 
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
    private void Login(ActionEvent event) throws IOException, SQLException {
      
       
        
        String req11 = "Select * From users where username = ? and password = ? ";
             PreparedStatement pstm = conn.prepareStatement(req11);
             pstm.setString(1, tf_user.getText());
             pstm.setString(2, tf_pass.getText());
             
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) 
                {    
                                if (rs.getString(4).equals("1"))
                                 {
                                   System.out.println();
                                    loginsucces();
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
                        
                        if (rs.getString(4).equals("2"))
                            {
                               
           
                loginusersucces();
                     Stage stage = (Stage) btn_login.getScene().getWindow();
        stage.close();
        
        FXMLLoader fxmlLoader1 = new FXMLLoader();
        fxmlLoader1.setLocation(getClass().getResource("/GUI/Fronthome.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load());
        Stage stage1 = new Stage();
        stage1.setTitle("Front Office");
        stage1.setScene(scene1);
        stage1.show();    
                
                            }
                    
                }
                
            else     {
        tf_pass.clear();
       tf_user.clear();
        loginfailed(); 
                    }
            
            
            //login for client
            
            /*String req12 = "Select * From users where username = ? and password = ? and Type_user = 2";
             PreparedStatement pstm1 = conn.prepareStatement(req12);
             pstm.setString(1, tf_user.getText());
             pstm.setString(2, tf_pass.getText());
             
            ResultSet rs1 = pstm1.executeQuery();
            if (rs1.next()) 
                { loginsucces();
                     Stage stage = (Stage) btn_login.getScene().getWindow();
        stage.close();
        
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/GUI/Frontoffice.fxml"));
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
            
            */
            
            
            
            
            
            
   /*
            //////login statique//////////
            
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
    */
    
   
    
    
     
        
    }
    
    
    private void loginfailed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
         alert.setHeaderText(null);
        alert.setContentText("username et password incorrects");
 
        alert.showAndWait();
    } 
    
     private void loginsucces() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
         alert.setHeaderText(null);
        alert.setContentText("Bienvenue Admin");
 
        alert.showAndWait();
    } 
    
            
            
             private void loginusersucces() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
         alert.setHeaderText(null);
        alert.setContentText("Bienvenue user");
 
        alert.showAndWait();
    } 
    
}
