package employmentsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpdateDeleteController implements Initializable{
    
    @FXML private TextField ID_TXT;
    @FXML private TextField FULLNAME_TXT;
    @FXML private TextField DEPARTMENT_TXT;
    @FXML private TextField AGE_TXT;
    @FXML private TextField EDUCATION_TXT;
    @FXML private TextField GENDER_TXT;
    @FXML private TextField ADDRESS_TXT;
    @FXML private TextField SEARCH_TXT;
    @FXML private Button UPDATE_BTN;
    @FXML private Button DELETE_BTN;
    @FXML private Label STATUS_LBL;
    
    
    Connection con;
    Statement statement;
    ResultSet rs;
    
    @FXML
    public void SearchResults(ActionEvent e){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            String sql = "SELECT * FROM employers_tbl WHERE fullname=?";
            PreparedStatement PreStat = (PreparedStatement) con.prepareStatement(sql);
            PreStat.setString(1, SEARCH_TXT.getText());
            rs = PreStat.executeQuery();
            rs.last();
            
            if(rs.getRow() > 0){
                DELETE_BTN.setDisable(false);
                UPDATE_BTN  .setDisable(false);
                ID_TXT.setDisable(false);
                FULLNAME_TXT.setDisable(false);
                DEPARTMENT_TXT.setDisable(false);
                AGE_TXT.setDisable(false);
                GENDER_TXT.setDisable(false);
                EDUCATION_TXT.setDisable(false);
                ADDRESS_TXT.setDisable(false);
                
                ID_TXT.setText(rs.getString("id"));
                FULLNAME_TXT.setText(rs.getString("fullname"));
                DEPARTMENT_TXT.setText(rs.getString("department"));
                AGE_TXT.setText(rs.getString("age"));
                GENDER_TXT.setText(rs.getString("gender"));
                EDUCATION_TXT.setText(rs.getString("education"));
                ADDRESS_TXT.setText(rs.getString("address"));
                
                STATUS_LBL.setStyle("-fx-text-fill: #66BB6A;");
                STATUS_LBL.setText("Status: <Info> Employer Found.");
            }else{
                DELETE_BTN.setDisable(true);
                UPDATE_BTN .setDisable(true);
                ID_TXT.setDisable(true);
                FULLNAME_TXT.setDisable(true);
                DEPARTMENT_TXT.setDisable(true);
                AGE_TXT.setDisable(true);
                GENDER_TXT.setDisable(true);
                EDUCATION_TXT.setDisable(true);
                ADDRESS_TXT.setDisable(true);
                
                ID_TXT.clear();
                FULLNAME_TXT.clear();
                DEPARTMENT_TXT.clear();
                AGE_TXT.clear();
                GENDER_TXT.clear();
                EDUCATION_TXT.clear();
                ADDRESS_TXT.clear();
                // SEARCH_TXT.clear(); // No need to clear this text field :D
                
                STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
                STATUS_LBL.setText("Status: <Error> Employer not found.");
            }
        }catch(Exception ex){
            
            ex.printStackTrace();
        }
    }
    
    int s = 0;
    @FXML
    public void Delete(ActionEvent e){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            String sql = "DELETE FROM employers_tbl WHERE id=?";
            PreparedStatement PreStat = (PreparedStatement) con.prepareStatement(sql);
            PreStat.setInt(1, Integer.parseInt(ID_TXT.getText()));
            s = PreStat.executeUpdate();
            
            DELETE_BTN.setDisable(true);
            UPDATE_BTN  .setDisable(true);
            ID_TXT.setDisable(true);
            FULLNAME_TXT.setDisable(true);
            DEPARTMENT_TXT.setDisable(true);
            AGE_TXT.setDisable(true);
            GENDER_TXT.setDisable(true);
            EDUCATION_TXT.setDisable(true);
            ADDRESS_TXT.setDisable(true);
            
            ID_TXT.clear();
            FULLNAME_TXT.clear();
            DEPARTMENT_TXT.clear();
            AGE_TXT.clear();
            GENDER_TXT.clear();
            EDUCATION_TXT.clear();
            ADDRESS_TXT.clear();
            SEARCH_TXT.clear();
            
            STATUS_LBL.setStyle("-fx-text-fill: #66BB6A;");
            STATUS_LBL.setText("Status: <Info> Employer Deleted Sucessfully.");
        }catch(SQLException | NumberFormatException ex){
            STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
            STATUS_LBL.setText("Status: <Error> Couldn't Delete..!");
            ex.printStackTrace();
        }
    }
    
    @FXML
    public void Update(ActionEvent e){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            String sql = "UPDATE employers_tbl SET fullname=?, department=?, age=?, gender=?, education=?, address=? WHERE id=?";
            PreparedStatement PreStat = (PreparedStatement) con.prepareStatement(sql);
            PreStat.setString(1, FULLNAME_TXT.getText());
            PreStat.setString(2, DEPARTMENT_TXT.getText());
            PreStat.setInt(3, Integer.parseInt(AGE_TXT.getText()));
            PreStat.setString(4, GENDER_TXT.getText());
            PreStat.setString(5, EDUCATION_TXT.getText());
            PreStat.setString(6, ADDRESS_TXT.getText());
            PreStat.setInt(7, Integer.parseInt(ID_TXT.getText()));
            s = PreStat.executeUpdate();
            
            DELETE_BTN.setDisable(true);
            UPDATE_BTN  .setDisable(true);
            ID_TXT.setDisable(true);
            FULLNAME_TXT.setDisable(true);
            DEPARTMENT_TXT.setDisable(true);
            AGE_TXT.setDisable(true);
            GENDER_TXT.setDisable(true);
            EDUCATION_TXT.setDisable(true);
            ADDRESS_TXT.setDisable(true);
            
            ID_TXT.clear();
            FULLNAME_TXT.clear();
            DEPARTMENT_TXT.clear();
            AGE_TXT.clear();
            GENDER_TXT.clear();
            EDUCATION_TXT.clear();
            ADDRESS_TXT.clear();
            SEARCH_TXT.clear();
            
            STATUS_LBL.setStyle("-fx-text-fill: #66BB6A;");
            STATUS_LBL.setText("Status: <Info> Employer info has been updated.");
        }catch(SQLException | NumberFormatException ex){
            STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
            STATUS_LBL.setText("Status: <Error> Couldn't Update..!");
            ex.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DELETE_BTN.setDisable(true);
        UPDATE_BTN  .setDisable(true);
        ID_TXT.setDisable(true);
        FULLNAME_TXT.setDisable(true);
        DEPARTMENT_TXT.setDisable(true);
        AGE_TXT.setDisable(true);
        GENDER_TXT.setDisable(true);
        EDUCATION_TXT.setDisable(true);
        ADDRESS_TXT.setDisable(true);
    }
    
}
