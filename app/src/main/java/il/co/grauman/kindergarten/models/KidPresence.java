package il.co.grauman.kindergarten.models;
import java.sql.Date;
import java.sql.Time;
// to make sure if the library is correct
public class KidPresence {
    private int id;
    private String kidID;
    private Time entryHour;
    private  Time exitHour;
    private Date date;
    
    
    
    public KidPresence(int id, String kidID, Time entryHour, Time exitHour,Date date) {
        super();
        this.id = id;
        this.kidID = kidID;
        this.entryHour = entryHour;
        this.exitHour = exitHour;
        this.date=date;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getKidID() {
        return kidID;
    }
    public void setKidID(String kidID) {
        this.kidID = kidID;
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
    
    
    
}