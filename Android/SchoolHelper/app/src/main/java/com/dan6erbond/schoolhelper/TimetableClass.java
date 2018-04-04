package com.dan6erbond.schoolhelper;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimetableClass {
    public Time startTime;
    public Time endTime;
    public String subject;
    public String teacher;
    public String location;
    public int day;

    public TimetableClass(String sT, String eT, String s, String t, String l, String d){
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        try {
            startTime = new Time(formatter.parse(sT).getTime());
            endTime = new Time(formatter.parse(eT).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        subject = s;
        teacher = t;
        location = l;
        day = Integer.parseInt(d);
    }
}
