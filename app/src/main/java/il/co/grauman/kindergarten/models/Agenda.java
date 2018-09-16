package il.co.grauman.kindergarten.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;


public class Agenda {
	private int agendaID;
	private Date date;
	private Time fromHour;
	private Time toHour;
	private String description;

	public Agenda(int agendaID, Date date, Time fromHour, Time toHour, String description) {
		this.agendaID = agendaID;
		this.date = date;
		this.fromHour = fromHour;
		this.toHour = toHour;
		this.description = description;

	}

	public int getAgendaID() {
		return agendaID;
	}

	public void setAgendaID(int agendaID) {
		this.agendaID = agendaID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getFromHour() {
		return fromHour;
	}

	public void setFromHour(Time fromHour) {
		this.fromHour = fromHour;
	}

	public Time getToHour() {
		return toHour;
	}

	public void setToHour(Time toHour) {
		this.toHour = toHour;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
