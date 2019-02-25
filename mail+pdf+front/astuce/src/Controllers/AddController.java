/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entites.Astuces;
import Utilities.datasource;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import services.ServiceAstuces;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * FXML Controller class
 *
 * @author Nckey Larson
 */
public class AddController implements Initializable {
 Connection conn =datasource.getInstance().getConnection(); 
    @FXML
    private TextField tf_titre;
    @FXML
    private TextField tf_type;
    @FXML
    private TextField tf_desc;
    @FXML
    private Button btn_ajouter;
    
    
     @FXML
  private FontAwesomeIconView image1;
    @FXML
    private ImageView pic1;
    @FXML
 
    public ComboBox<String> Cb_type;
    ObservableList<String> list = FXCollections.observableArrayList("Avant Plantation","Plantation","Apres Plantation");
    @FXML
    private StackPane rootpane;
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Cb_type.setItems(list);
    }    
    @FXML
    private void combochanged(ActionEvent event) {
        tf_type.setText(Cb_type.getValue());
    }

    @FXML
    private void ajouterastuce(ActionEvent event) throws SQLException {
         if ((tf_titre.getText().length() > 0)&&(tf_type.getText().length() > 0)&&(tf_desc.getText().length() > 0))
{
    Image image1 = pic1.getImage();
            String nameImage1 = saveToFileImageNormal(image1);
      
        String Titre_Astuce = tf_titre.getText();
        tf_type.setText(Cb_type.getValue());
        String Type_Astuce = tf_type.getText();
        String Desc_Astuce = tf_desc.getText();
        
        
        Astuces p =new Astuces(Titre_Astuce, Type_Astuce, Desc_Astuce);
        p.setImage_Astuce(nameImage1);
        ServiceAstuces sa = new ServiceAstuces();
        
sa.ajouterpersonne(p);
 tf_titre.clear();
        tf_type.clear();
        tf_desc.clear();
        Ajoutsucces();
}
        
       
        
        
else
{
    tf_titre.clear();
        tf_type.clear();
        tf_desc.clear();
ajoutfailer();
}
        
        
       
       

    }
    
    public static String saveToFileImageNormal(Image image)throws SQLException  {

        String ext = "jpg";
        File dir = new File("C:/xampp/htdocs/images");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    @FXML
    private void addImage(MouseEvent event) throws IOException{
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            pic1.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    private void Ajoutsucces() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(null);
         alert.setHeaderText(null);
        alert.setContentText("Astuce ajouter avec succes");
 
        alert.showAndWait();
    }
     private void ajoutfailer() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(null);
         alert.setHeaderText(null);
        alert.setContentText("Astuce  n'est pas ajouter avec succes");
 
        alert.showAndWait();
    }
    
}
