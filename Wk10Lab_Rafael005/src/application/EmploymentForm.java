package application;

public class EmploymentForm {

/*
 * Creating a Class to model Entity... given
 * in the qs. 	
 */

 
    private String username;
    private String lastName;
    private String firstName;
    private String password;
// getter , setter
    public String getUsername() {return username;}
    public String getLastName() {return lastName; }
    public String getFirstName() { return firstName; }
    public String getPassword() {return  password; }
    
    public void setUsername(String username) 
    { this.username = username;}

    public void setLastName(String lastName) 
    { this.lastName = lastName;}

    public void setFirstName(String firstName) 
    { this.firstName = firstName;}

    public void setPassword(String password) 
    { this.password = password; }
}
