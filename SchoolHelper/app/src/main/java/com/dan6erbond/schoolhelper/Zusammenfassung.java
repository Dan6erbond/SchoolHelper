package com.dan6erbond.schoolhelper;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.Optional;

public class Zusammenfassung{
    public String subject;
    public String topic;
    public String date;
    public String link;
    public String name;
    public String author;

    public Zusammenfassung(String s, String t, String d, String a, String n){
        subject = s;
        topic = t;
        date = d;
        author = a;
        if(n == "")
            name = subject + " - " + topic + " - " + author + ".pdf";
        else
            name = n;
        name = name.replace(" - RaviAnand Mohabir", "");
        link = "https://dan6erbond.github.io/I1A/Documents/Zusammenfassungen/" + name;
        link = link.replaceAll(" ", "%20");
    }

    public File getFile(Context context){
        File file = new File(context.getExternalFilesDir(null), "/Zusammenfassungen/" + name);
        return file;
    }
}
