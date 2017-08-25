package employmentsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ChangeAccessInfoController implements Initializable{
    
    @FXML private TextField NEW_USERNAME_TXT;
    @FXML private PasswordField NEW_PASSWORD_TXT;
    @FXML private Label STATUS_LBL;
    
    Connection con;
    
    
    int s = 0;
    @FXML
    public void SaveChanges(ActionEvent e){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            String sql = "UPDATE admins_tbl SET username=?, password=? WHERE id=1";
            PreparedStatement PreStat = (PreparedStatement) con.prepareStatement(sql);
            PreStat.setString(1, NEW_USERNAME_TXT.getText());
            PreStat.setString(2, NEW_PASSWORD_TXT.getText());
            s = PreStat.executeUpdate();
            
            STATUS_LBL.setStyle("-fx-text-fill: #66BB6A;"); 
            STATUS_LBL.setText("Status: <Info> Access info have been updated.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resource){
        ResultSet rs;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            if(!con.isClosed()){
                STATUS_LBL.setStyle("-fx-text-fill: #66BB6A;"); 
                STATUS_LBL.setText("Status: <Info> Connected to the database.");
                
                String sql = "SELECT * FROM admins_tbl WHERE id=1";
                PreparedStatement PreStat = (PreparedStatement) con.prepareStatement(sql);
                rs = PreStat.executeQuery();
                rs.last();                
                STATUS_LBL.setText("Status: <Current User: "+rs.getString("username")+", pass: "+rs.getString("password")+">");
            }else{
                STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
                STATUS_LBL.setText("Status: <Error> Not Connected to database.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
