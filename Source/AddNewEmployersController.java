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
import javafx.scene.control.*;

public class AddNewEmployersController implements Initializable{

    @FXML private Label STATUS_LBL;
    @FXML private TextField FULLNAME_TXT;
    @FXML private TextField DEPARTMENT_TXT;
    @FXML private TextField AGE_TXT;
    @FXML private TextField GENDER_TXT;
    @FXML private TextField EDUCATION_TXT;
    @FXML private TextField ADDRESS_TXT;
    
    Connection con;
    Statement statement;
    ResultSet ResSet;
    
    int ExeUpdt = 0;
    
    @FXML
    public void AddNewEmploer(ActionEvent e){
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            String InsertSQL = "INSERT INTO employers_tbl (fullname, department, age, gender, education, address) VALUES(?,?,?,?,?,?)";
            String SearchSQL = "SELECT * FROM employers_tbl WHERE fullname=?";
            PreparedStatement PreState = (PreparedStatement) con.prepareStatement(SearchSQL);
            PreState.setString(1, FULLNAME_TXT.getText());
            ResSet = PreState.executeQuery();
            ResSet.last();
            if(ResSet.getRow() > 0){
                STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
                STATUS_LBL.setText("Status: <Error> Employee name already exists.");
            }else{
                PreState = (PreparedStatement) con.prepareStatement(InsertSQL); 
                PreState.setString(1, FULLNAME_TXT.getText());
                PreState.setString(2, DEPARTMENT_TXT.getText());
                if(AGE_TXT.getText().trim().isEmpty())
                    PreState.setInt(3, 0);
                else
                    PreState.setInt(3, Integer.parseInt(AGE_TXT.getText()));
                PreState.setString(4, GENDER_TXT.getText());
                PreState.setString(5, EDUCATION_TXT.getText());
                PreState.setString(6, ADDRESS_TXT.getText());
                if(FULLNAME_TXT.getText().trim().isEmpty()){
                    STATUS_LBL.setStyle("-fx-text-fill: #FDD835;");
                    STATUS_LBL.setText("Status: <Error> Full Name Field Required");
                }else{
                    ExeUpdt = PreState.executeUpdate();
                    STATUS_LBL.setStyle("-fx-text-fill: #66BB6A;");
                    STATUS_LBL.setText("Status: <Info> New Employer has been added.");
                }
            }
            
            con.close();
        }catch(SQLException | NumberFormatException ex){
            ex.printStackTrace();
        }
        
    }
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
