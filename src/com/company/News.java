package com.company;

import java.sql.Timestamp;

public class News {
    private int ID;
    private String title;
    private String texts;
    private Timestamp time_of_publishing;

    public News() {
    }

    public News(String title, String texts) {
        this.title = title;
        this.texts = texts;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public Timestamp getTime_of_publishing() {
        return time_of_publishing;
    }

    public void setTime_of_publishing(Timestamp time_of_publishing) {
        this.time_of_publishing = time_of_publishing;
    }
}
