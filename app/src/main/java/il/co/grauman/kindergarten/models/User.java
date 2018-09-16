package il.co.grauman.kindergarten.models;

import il.co.grauman.kindergarten.enums.Role;


import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;


public class User {

    private String userID;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private byte[] picture;
    private Role category;
    private Date birthday;
    private Date startWorkDate;
    private String mail;
    private String jobs;
    private int validationQR;
    private Time generationTime;
    private Boolean enabled;



    public User(String userID,String x , Role role){
        this.userID=userID;
        this.category=role;

    }
    public User(String userID, String password, String firstName, String lastName, String address, String phoneNumber,
                byte[] picture, Role category,Date birthday, Date startWorkDate,
                String mail,String jobs,int validationQR,Time generationTime,Boolean enabled) {
        this.userID = userID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.picture = picture;
        this.category = category;
        this.birthday=birthday;
        this.startWorkDate=startWorkDate;
        this.mail=mail;
        this.jobs=jobs;
        this.validationQR=validationQR;
        this.generationTime=generationTime;
        this.enabled = enabled;
    }
    public User(String userID, String password, String firstName, String lastName, String address, String phoneNumber,
                byte[] picture, Role category,Boolean enabled) {
        this.userID = userID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.picture = picture;
        this.category = category;
        this.enabled = enabled;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Role getCategory() {
        return category;
    }

    public void setCategory(Role category) {
        this.category = category;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Date getStartWorkDate() {
        return startWorkDate;
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
