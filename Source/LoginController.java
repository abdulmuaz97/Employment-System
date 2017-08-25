package employmentsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController implements Initializable {
        // Declaring the components that belong to FXML design as private.
    	@FXML private Button LOGIN_BTN;
	@FXML private Label STATUS_LBL;
	@FXML private TextField USERNAME_TXT;
	@FXML private PasswordField PASSWORD_TXT;
	
        
        // Needed declaration or variables..
        Connection con;
        Statement statement;
        ResultSet resultset;
        
        
    @FXML
    public void CheckAccessValidality(ActionEvent e) throws Exception {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            String sql = "SELECT * FROM admins_tbl WHERE username=? AND password=?";
            PreparedStatement PreState = (PreparedStatement) con.prepareStatement(sql);
            PreState.setString(1, USERNAME_TXT.getText());
            PreState.setString(2, PASSWORD_TXT.getText());
            resultset = PreState.executeQuery();
            resultset.last();
            if(resultset.getRow() > 0){
                Parent root = FXMLLoader.load(getClass().getResource("ControlPanel.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("ControlPanelStyle.css").toExternalForm());
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle("Control Panel");
                stage.show();

                // Closing the current frame.
                Stage currentStage = (Stage) LOGIN_BTN.getScene().getWindow();
                currentStage.close();
            }
            else{
                STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
                STATUS_LBL.setText("Status: <Protected System> Access Denied.");
            }
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
            STATUS_LBL.setText("Status: <Error> SQL Server.");
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            if(!con.isClosed()){
                STATUS_LBL.setStyle("-fx-text-fill: #66BB6A;"); 
                STATUS_LBL.setText("Status: <Info> Connected to the database.");
            }else{
                STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
                STATUS_LBL.setText("Status: <Error> Can't Access The Database.");
            }
            
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
            STATUS_LBL.setText("Status: <Error> Server Error.");
            USERNAME_TXT.setDisable(true);
            PASSWORD_TXT.setDisable(true);
            LOGIN_BTN.setDisable(true);
        }
    }    
    
}
