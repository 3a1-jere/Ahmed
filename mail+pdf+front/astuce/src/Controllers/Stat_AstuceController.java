package Controllers;

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Utilities.datasource;
import com.itextpdf.awt.geom.misc.Messages;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Nckey Larson
 */
public class Stat_AstuceController implements Initializable {
 Connection conn =datasource.getInstance().getConnection(); 
    @FXML
    private BarChart<String,Integer> bar_chart;
    @FXML
    private Button btn_load;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoadChart(ActionEvent event) throws SQLException {
       String query="SELECT Type_Astuce, COUNT(*) FROM astuces GROUP BY Type_Astuce";
        //String query="select Type_Astuce,Id_Astuce FROM astuces ORDER BY Id_Astuce asc ";
        XYChart.Series<String,Integer> series=new XYChart.Series<>();
        ResultSet rs=conn.createStatement().executeQuery(query);
        while (rs.next())
                    {            
                           series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));
                           bar_chart.getData().add(series);
                    }
        
    }
    
}
