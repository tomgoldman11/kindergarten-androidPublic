package il.co.grauman.kindergarten.models;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kid {
	private String kidID;
	private String firstName;
	private String lastName;
	private byte[] picture;
	private Date birthDay;
	private String information;
	private Boolean enabled;
	
	 public Kid() {
		 
	 }
	public Kid(String kidID, String firstName, String lastName, byte[] picture,
			Date birthDay, String information,Boolean enabled) {
		super();
		this.kidID=kidID;
		this.firstName=firstName;
		this.lastName=lastName;
		this.picture=picture;
		this.birthDay=birthDay;
		this.information=information;
		 this.enabled = enabled;
	
	}
	public String getKidID() {
		return kidID;
	}
	public void setKidID(String kidID) {
		this.kidID = kidID;
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
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
    

}
