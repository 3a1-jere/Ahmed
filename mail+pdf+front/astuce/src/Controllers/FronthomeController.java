/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import services.pdf;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nckey Larson
 */
public class FronthomeController implements Initializable {

    @FXML
    private Button logout;
   
    @FXML
    private BorderPane pane_front;
    @FXML
    private Button btn_jardin;
    @FXML
    private Button btn_astuce;
    @FXML
    private Button btn_contactez;
    @FXML
    private Button btn_home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout(MouseEvent event) throws IOException {
        
        Stage stage =(Stage) pane_front.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/LoginPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Go_jardin(MouseEvent event) {
        pdf p=new pdf();
   
   p.creation();
  
    }

    @FXML
    private void Go_Astuce(MouseEvent event) throws IOException {
       // LoadUi("ListAstuces");
    }

    @FXML
    private void Go_contactez(MouseEvent event) {
        SendEmail send = new SendEmail("abidi@technologuepro.com", "subjject", "mjessage");
     
    }
    
   
            
            public  void LoadUi(String ui) throws IOException
{   
    Parent root;
       root= FXMLLoader.load(getClass().getResource("/GUI/"+ui+".fxml"));
       pane_front.setCenter(root);
}

    @FXML
    private void Go_fronthome(MouseEvent event) throws IOException {
          pane_front.setCenter(null);
    }
    
    
    
    //**************************************************************************/
    
    
    
    
    
    
    
    
    
}
