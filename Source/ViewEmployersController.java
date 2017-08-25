package employmentsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
public class ViewEmployersController implements Initializable{
    
    @FXML public TableView<Employers> table = new TableView<>();
    @FXML private TableColumn<Employers, Integer> id_col;
    @FXML private TableColumn<Employers, String> fullname_col;
    @FXML private TableColumn<Employers, String> department_col;
    @FXML private TableColumn<Employers, Integer> age_col;
    @FXML private TableColumn<Employers, String> gender_col;
    @FXML private TableColumn<Employers, String> education_col;
    @FXML private TableColumn<Employers, String> address_col;
    
    Connection con;
    Statement statement;
    ResultSet rs;
    
    @FXML private TextField SEARCH_TXT;
    
    public ObservableList<Employers> data = FXCollections.observableArrayList();
    
    @FXML
    public void Search(ActionEvent e){
        table.getItems().clear();
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            PreparedStatement PreState = (PreparedStatement) con.prepareStatement("SELECT * FROM employers_tbl WHERE fullname=?");
            PreState.setString(1, SEARCH_TXT.getText());
             rs = PreState.executeQuery();            
            while(rs.next()){
                
                data.add(new Employers(rs.getInt("id"), rs.getString("fullname"), rs.getString("department"),
                rs.getInt("age"), rs.getString("gender"), rs.getString("education"), rs.getString("address")));
                
            }
            
            con.close();
            
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
        id_col.setCellValueFactory(new PropertyValueFactory<Employers, Integer>("id"));
        fullname_col.setCellValueFactory(new PropertyValueFactory<Employers, String>("fullname"));
        department_col.setCellValueFactory(new PropertyValueFactory<Employers, String>("department"));
        age_col.setCellValueFactory(new PropertyValueFactory<Employers, Integer>("age"));
        gender_col.setCellValueFactory(new PropertyValueFactory<Employers, String>("gender"));
        education_col.setCellValueFactory(new PropertyValueFactory<Employers, String>("education"));
        address_col.setCellValueFactory(new PropertyValueFactory<Employers, String>("address"));
        
        table.setItems(data);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resource){
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee_db", "abdulmuaz", "");
            PreparedStatement PreState = (PreparedStatement) con.prepareStatement("SELECT * FROM employers_tbl");
             rs = PreState.executeQuery();            
            while(rs.next()){
                
                data.add(new Employers(rs.getInt("id"), rs.getString("fullname"), rs.getString("department"),
                rs.getInt("age"), rs.getString("gender"), rs.getString("education"), rs.getString("address")));
                
            }
            
            con.close();
            
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
        id_col.setCellValueFactory(new PropertyValueFactory<Employers, Integer>("id"));
        fullname_col.setCellValueFactory(new PropertyValueFactory<Employers, String>("fullname"));
        department_col.setCellValueFactory(new PropertyValueFactory<Employers, String>("department"));
        age_col.setCellValueFactory(new PropertyValueFactory<Employers, Integer>("age"));
        gender_col.setCellValueFactory(new PropertyValueFactory<Employers, String>("gender"));
        education_col.setCellValueFactory(new PropertyValueFactory<Employers, String>("education"));
        address_col.setCellValueFactory(new PropertyValueFactory<Employers, String>("address"));
        
        table.setItems(data);
    }
}
