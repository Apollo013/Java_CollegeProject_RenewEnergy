package Models.Concrete;

import Models.Abstract.ErrorBase;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class User extends ErrorBase implements Serializable, Comparable<User>{
    
    // <editor-fold defaultstate="collapsed" desc="Properties"> 
    
    private int         id;
    
    @RequiredValidator
    private String      firstName;
    @RequiredValidator
    private String      lastName;
    @RequiredValidator
    private String      address1;
    private String      address2;
    @RequiredValidator
    private String      city;
    @RequiredValidator
    private String      county;
    @RequiredValidator
    private String      country;
    private String      postCode;
    @RequiredValidator
    private String      email;
    private String      password;
    private byte        userType;
    private Timestamp   lastUpdated;    

   // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    
    public User(){}

    public User(int id) {
        this.id = id;
    }
    
    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public User(int id, String firstName, String lastName, String email, byte userType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.setUserType(userType);
    }

    public User(int id, String firstName, String lastName, String address1, String address2, String city, String county, String country, String postCode, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postCode = postCode;
        this.email = email;
    }

    public User(int id, String firstName, String lastName, String address1, String address2, String city, String county, String country, String postCode, String email, String password, byte userType, Timestamp lastUpdated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.county = county;
        this.country = country;
        this.postCode = postCode;
        this.email = email;
        this.setPassword(password);
        this.setUserType(userType);
        this.lastUpdated = lastUpdated;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        if(userType < 1){
            userType = 2; // default to general member
        }
        this.userType = userType;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
    // </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Custom">

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }
    
    public String getFullAddress(){
        
        String address = this.address1 + "\n";
        
        try{
            address = this.address2.isEmpty() ?  this.address1 + "\n" : address + this.address2 + "\n";
        }
        catch(NullPointerException npe){
            address = address;
        }

        address += this.city + "\n" + this.county + "\n" + this.country + "\n";
        
        try{
            address = this.postCode.isEmpty() ?  address : address +  "\n" + this.postCode;            
        }
        catch(NullPointerException npe){   
            address = address;            
        }        

        return address;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Overrides">  
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", county=" + county + ", country=" + country + ", postCode=" + postCode + ", email=" + email + ", password=" + password + ", userType=" + userType + ", lastUpdated=" + lastUpdated + '}';
    }

    @Override
    public int compareTo(User user) {
        return this.lastName.compareToIgnoreCase(user.lastName);
    }
        
    // </editor-fold>   

}
