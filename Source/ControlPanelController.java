package employmentsystem;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControlPanelController implements Initializable{
    
    Connection con;
    
    @FXML private Label STATUS_LBL;
    
    @FXML
    public void ViewAllEmployers(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ViewEmployers.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("ViewEmployersStyle.css").toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("All Employers");
        stage.show();
    }
    
    @FXML
    public void AddNewEmployers(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AddNewEmployers.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("AddNewEmployersStyle.css").toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Add New Employers");
        stage.show();
    }
        @FXML
    public void UpdateDelete(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("UpdateDelete.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("UpdateDeleteStyle.css").toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Update/Delete Employers");
        stage.show();
    }

    @FXML
    public void ChangeAccessInfo(ActionEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ChangeAccessInfo.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("ChangeAccessInfoStyle.css").toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Change Access Info");
        stage.show();
    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            if(!con.isClosed()){
                STATUS_LBL.setStyle("-fx-text-fill: #66BB6A;"); 
                STATUS_LBL.setText("Status: <Info> Connected to the database.");
            }else{
                STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
                STATUS_LBL.setText("Status: <Error> Not Connected to database.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }   
}
