package com.project.vanswa.contactdao;

import java.util.Date;

/**
 * Created by vanswa on 11/13/2015.
 */
public class Contact {
    private String name;
    private int employeeId;
    private String company;
    private String detailsURL;
    private String smallImageURL;
    private Date  birthDate;
    private String workPhone;
    private String homePhone;
    private String mobilePhone;
    private int position;

    Contact(String name, int employeeId, String company,String detailsURL ,String smallImageURL, Date birthDate,String workPhone, String homePhone, String mobilePhone, int position){
        this.setEmployeeId(employeeId);
        this.setCompany(company);
        this.setDetailsURL(detailsURL);
        this.setSmallImageURL(smallImageURL);
        this.setBirthDate(birthDate);
        this.setWorkPhone(workPhone);
        this.setHomePhone(homePhone);
        this.setMobilePhone(mobilePhone);
        this.setPosition(position);
    }
    Contact(String name){
    this.setName(name);
    }
    Contact(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDetailsURL() {
        return detailsURL;
    }

    public void setDetailsURL(String detailsURL) {
        this.detailsURL = detailsURL;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setSmallImageURL(String smallImageURL) {
        this.smallImageURL = smallImageURL;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
