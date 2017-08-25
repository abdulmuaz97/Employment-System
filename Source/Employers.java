package employmentsystem;

public class Employers {
	
    private int id;
    private String fullname;
    private String department;
    private int age;
    private String gender;
    private String education;
    private String address;
    
    
    public Employers() {
            super();
            // TODO Auto-generated constructor stub
    }


    public Employers(int id, String fullname, String department, int age, String gender, String education, String address) {
        super();
        this.id = id;
        this.fullname = fullname;
        this.department = department;
        this.age = age;
        this.gender = gender;
        this.education = education;
        this.address = address;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getFullname() {
        return fullname;
    }


    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getEducation() {
        return education;
    }


    public void setEducation(String education) {
        this.education = education;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
