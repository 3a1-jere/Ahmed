/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astuce;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nckey Larson
 */
public class HomepageController implements Initializable {

    @FXML
    public BorderPane borderpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Go_Home(MouseEvent event) {
         borderpane.setCenter(null);
    }

    @FXML
    private void Go_Add(MouseEvent event) throws IOException {
        LoadUi("Add");
    }

    @FXML
    private void Go_Afficher(MouseEvent event) throws IOException {
        LoadUi("ListAstuces");
    }

    @FXML
    private void Go_stat(MouseEvent event) throws IOException {
        LoadUi("Stat_Astuce");
    }

    @FXML
    private void Exit(MouseEvent event) throws IOException {
        Stage stage =(Stage) borderpane.getScene().getWindow();
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/LoginPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    public  void LoadUi(String ui) throws IOException
{   
    Parent root;
       root= FXMLLoader.load(getClass().getResource("/GUI/"+ui+".fxml"));
       borderpane.setCenter(root);
}
}
