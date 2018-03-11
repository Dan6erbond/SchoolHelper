package com.dan6erbond.schoolhelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework implements Comparable<Homework> {
    public String date;
    public String subject;
    public String job;

    public Homework(String d, String s, String j){
        date = d;
        subject = s;
        job = j;
    }

    @Override
    public int compareTo(Homework otherHomework) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date date1 = format.parse(date);
            Date date2 = format.parse(otherHomework.date);

            return date1.compareTo(date2);
        }
        catch (ParseException ex) {
            ex.printStackTrace();
            return 0; // or do something else
        }
    }

    @Override
    public boolean equals (Object object){
        try{
            Homework otherHomework = (Homework)object;

            if(otherHomework.subject == subject && otherHomework.date == date && otherHomework.job == job)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }
}
