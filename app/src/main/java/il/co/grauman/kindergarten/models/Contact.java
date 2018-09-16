package il.co.grauman.kindergarten.models;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Contact {
	private int contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private byte[] picture;
	private String relation;
	private Boolean enabled;

	public Contact() {

	}

	public Contact(int contactID, String firstName, String lastName, String phoneNumber, byte[] picture,
			String relation,Boolean enabled) {
		super();
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.picture = picture;
		this.relation = relation;
		this.enabled = enabled;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	

}
