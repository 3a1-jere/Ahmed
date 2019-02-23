/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Astuces;
import astuce.HomepageController;
import Utilities.datasource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Nckey Larson
 */
public class DivastuceController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private Pane sq;
    @FXML
    private Label nom;
    @FXML
    private Label id;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Label Desc;
    @FXML
    private Label type;
    @FXML
    private CheckBox btn_delete;
    @FXML
    private Button btn_validerdelete;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    public void LoadValues(Astuces e) throws IOException {
    
        nom.setText(e.getTitre_Astuce());
        Desc.setText(e.getDesc_Astuce());
        type.setText(e.getType_Astuce());
        id.setText(String.valueOf(e.getId_Astuce()));
        Image imageURI2 = new Image("file:C://xampp/htdocs/images/" + e.getImage_Astuce().toString());
        rectangle.setFill(new ImagePattern(imageURI2));
     
     ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                   // doubleclick(event, e);
                    System.out.println(e.getTitre_Astuce());
                    try {
                        Loadstucepage();
                    } catch (IOException ex) {
                        Logger.getLogger(DivastuceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }

            }
        });
    
    
    
    }
       
    
    
    
    public void doubleclick(MouseEvent event, Astuces selectedetab) throws IOException {
           if (event.getClickCount() == 2) {
               System.out.println("you clicked twice");
               
               
               
               
               
               
            
        }
    }  
    
    
    
    
    

    @FXML
    private void deleteAstuces(MouseEvent event) throws SQLException {
        
        if(btn_delete.isSelected())
        {
            System.out.println(nom.getText()+"delete me");
            
            Connection conn =datasource.getInstance().getConnection();
        String sql1= "delete from astuces where Titre_Astuce = ? ";
        PreparedStatement pst = conn.prepareStatement(sql1);
        pst.setString(1, nom.getText());
        int i =pst.executeUpdate();
        if(i==1)
            {   
                
            }
   
        }
        else  {}
       

   

    }

    @FXML
    private void clickx(MouseEvent event) {
    }
 
    
    
    

    public  void Loadstucepage() throws IOException
{   
    
       FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/GUI/AfficherAstuce.fxml"));
        /* 
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Affichage");
        stage.setScene(scene);
        stage.show();
        
       
}
    
    
    
    
    
    
    
    
    
}


