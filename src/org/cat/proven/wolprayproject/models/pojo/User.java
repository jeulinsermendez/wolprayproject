
package org.cat.proven.wolprayproject.models.pojo;

import java.util.Map;


/**
 *
 * @author Lewis
 */
public class User {
    //Attrubutes
    private int id;
    private String userName;
    private String mail;
    private String password;
    private String streetName;
    private int streetNumber;
    private String postalCode;
    private String phone;
    private String city;
    private String birthDate;
    private String role;
    private String imageProfile;

    
    //Constructors
    public User(int id, String userName, String mail, String password, String streetName, int streetNumber, String postalCode, String phone, String city, String birthDate, String role, String imageProfile) {
        this.id = id;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.phone = phone;
        this.city = city;
        this.birthDate = birthDate;
        this.role = role;
        this.imageProfile = imageProfile;
    }

    public User(int id, String userName, String mail, String password, String streetName, int streetNumber, String postalCode, String phone, String city, String birthDate, String role) {
        this.id = id;
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.phone = phone;
        this.city = city;
        this.birthDate = birthDate;
        this.role = role;
    }

    public User(String userName, String mail, String password, String streetName, int streetNumber, String postalCode, String phone, String city, String birthDate, String role) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.phone = phone;
        this.city = city;
        this.birthDate = birthDate;
        this.role = role;
    }
    
    
    public User(Map<String,Object> json) {
        this.userName = (String) json.get("userName");
        this.mail = (String) json.get("mail");
        this.password = (String) json.get("password");
        this.streetName = (String) json.get("streetName");
        this.streetNumber = (int) json.get("streetNumber");
        this.postalCode = (String) json.get("postalCode");
        this.phone = (String) json.get("phone");
        this.city = (String) json.get("city");
        this.birthDate = (String) json.get("birthDate");
        this.role = (String) json.get("role");
    }
    
    
    
    

    public User(int userId) {
        this.id = userId;
    }

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }
    
    
    

    //Accesors
  
    
    /**
     * 
     * @return user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @param userName : User name to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    /**
     * 
     * @param mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @return street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * 
     * @param streetName : Street name to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * 
     * @return street Number
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    /**
     * 
     * @param streetNumber : Street number to set
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * 
     * @return  postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * @param postalCode : Postal code to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @param phone : Phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city : City to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return birthdate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate : Birthdate to set
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id : Id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return  Role of this user
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role : role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    /** equals()
	 * compares this user to another one
	 * two persons are equals if their nifs are equals.
	 * @param obj other: the other user to compare to
	 * @return true if they are equals, false otherwise
	 */
    @Override
    public boolean equals(Object obj) {
		boolean b = false;
		if (obj == null) {
			b= false;
		} else {
			if (obj == this) {
				b = true;
			} else {
				if (obj instanceof User) {
				    User other = (User) obj;
				    b = (this.id == other.id);
				} else {
					b = false;
				}
			}
		}
		return b;
	}
    
    
    
    
    

    @Override
    public String toString() {
        return "User{" + "userId=" + id + ", userName=" + userName + ", mail=" + mail + ", password=" + password + ", streetName=" + streetName + ", streetNumber=" + streetNumber + ", postalCode=" + postalCode + ", phone=" + phone + ", city=" + city + ", birthDate=" + birthDate + '}';
    }
    
    
}
