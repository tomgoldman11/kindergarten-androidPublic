package il.co.grauman.kindergarten.models;


public class KidContact {
	private String kidID;
	private String contactID;

	public KidContact() {
	}

	public KidContact(String kidID, String contactID) {
		this.kidID = kidID;
		this.contactID = contactID;
	}

	public String getKidID() {
		return kidID;
	}

	public void setKidID(String kidID) {
		this.kidID = kidID;
	}

	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

}
