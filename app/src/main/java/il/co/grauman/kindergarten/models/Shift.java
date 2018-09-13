package il.co.grauman.kindergarten.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class Shift {
	private int id;
	private String workerId;
	private Time startHour;
	private Time endHour;
	private Time entryHour;
	private Time exitHour;
	private Date date;
	public Shift() {

	}

	

	public Shift(int id, String workerId, Time startHour, Time endHour, Time entryHour, Time exitHour, Date date) {
		
		this.id = id;
		this.workerId = workerId;
		this.startHour = startHour;
		this.endHour = endHour;
		this.entryHour = entryHour;
		this.exitHour = exitHour;
		this.date = date;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getWorkerId() {
		return workerId;
	}



	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}



	public Time getStartHour() {
		return startHour;
	}



	public void setStartHour(Time startHour) {
		this.startHour = startHour;
	}



	public Time getEndHour() {
		return endHour;
	}



	public void setEndHour(Time endHour) {
		this.endHour = endHour;
	}



	public Time getEntryHour() {
		return entryHour;
	}



	public void setEntryHour(Time entryHour) {
		this.entryHour = entryHour;
	}



	public Time getExitHour() {
		return exitHour;
	}



	public void setExitHour(Time exitHour) {
		this.exitHour = exitHour;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}

         
	
	             
}
