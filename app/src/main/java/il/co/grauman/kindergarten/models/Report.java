package il.co.grauman.kindergarten.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import il.co.grauman.kindergarten.bl.reports.reportsModles.ReportType;

public class Report {
    private int id;
    private Date date;
    private ReportType type;
    private String description; // body of report
    private String from;
    private String to; 
  
    public Report(int id, Date date,ReportType type,String description,String from, String to) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.description = description;
        this.from = from;
        this.to = to;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ReportType getType() {
		return type;
	}
	public void setType(ReportType type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}




}
