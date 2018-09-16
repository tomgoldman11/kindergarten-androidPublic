package il.co.grauman.kindergarten.models;


public class KidParent {
	private String kidID;
	private String parentID;

	public KidParent() {
	}
	public KidParent(String kidID, String parentID) {
		this.kidID=kidID;
		this.parentID=parentID;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}


	public String getKidID() {
		return kidID;
	}

	public void setKidID(String kidID) {
		this.kidID = kidID;
	}


}
