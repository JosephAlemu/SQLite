package com.example.user.sqlite;

/**
 * Created by user on 1/16/2018.
 */

public class CelebrityData {

    Integer id;
    String strFirstName;
    String strLastName;
    String strTittle;
    String event_description;


    public CelebrityData(Integer id, String strFirstName, String strLastName, String strTittle, String event_description) {
        this.id = id;
        this.strFirstName = strFirstName;
        this.strLastName = strLastName;
        this.strTittle = strTittle;
        this.event_description = event_description;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrFirstName() {
        return strFirstName;
    }

    public void setStrFirstName(String strFirstName) {
        this.strFirstName = strFirstName;
    }

    public String getStrLastName() {
        return strLastName;
    }

    public void setStrLastName(String strLastName) {
        this.strLastName = strLastName;
    }

    public String getStrTittle() {
        return strTittle;
    }

    public void setStrTittle(String strTittle) {
        this.strTittle = strTittle;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }


    @Override
    public String toString() {
        return "CelebrityData{" +
                "id=" + id +
                ", strFirstName='" + strFirstName + '\'' +
                ", strLastName='" + strLastName + '\'' +
                ", strTittle='" + strTittle + '\'' +
                ", event_description='" + event_description + '\'' +
                '}';
    }
}
