package il.co.grauman.kindergarten.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SummaryPicture {
	private int pictureID;
	private int summaryID;
	
	public SummaryPicture(int pictureID, int summaryID) {
		super();
		this.pictureID = pictureID;
		this.summaryID = summaryID;
	}

	public int getPictureID() {
		return pictureID;
	}
	public void setPictureID(int pictureID) {
		this.pictureID = pictureID;
	}
	public int getSummaryID() {
		return summaryID;
	}
	public void setSummaryID(int summaryID) {
		this.summaryID = summaryID;
	}
	
}
