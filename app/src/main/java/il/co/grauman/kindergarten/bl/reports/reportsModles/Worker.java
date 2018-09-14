package il.co.grauman.kindergarten.bl.reports.reportsModles;

import java.sql.Time;
import java.util.Date;

import il.co.grauman.kindergarten.enums.Role;
import il.co.grauman.kindergarten.models.User;

public class Worker extends User {
    Date birthday;
    Date startWorkDate;
    String mail;
    String jobs;
    int validationQR;
    Time generationTime;

    public Worker(String username, String password, Role role, Date birthday, Date startWorkDate, String mail, String jobs, int validationQR, Time generationTime) {
        super(username, password, role);
        this.birthday = birthday;
        this.startWorkDate = startWorkDate;
        this.mail = mail;
        this.jobs = jobs;
        this.validationQR = validationQR;
        this.generationTime = generationTime;
    }



    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public int getValidationQR() {
        return validationQR;
    }

    public void setValidationQR(int validationQR) {
        this.validationQR = validationQR;
    }

    public Time getGenerationTime() {
        return generationTime;
    }

    public void setGenerationTime(Time generationTime) {
        this.generationTime = generationTime;
    }
}
