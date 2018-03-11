package com.dan6erbond.schoolhelper;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.Optional;

public class Zusammenfassung{
    public String subject = "";
    public String topic = "";
    public String date = "";
    public String link = "";
    public String name = "";
    public String author = "";
    //TODO: add description for Zusammenfassung

    public Zusammenfassung(JSONObject data, String n) throws JSONException {
        if(n == ""){
            subject = data.getString("fach");
            topic = data.getString("thema");
            date = data.getString("datum");
            author = data.getString("autor");
            name = subject + " - " + topic + " - " + author + ".pdf";
            name = name.replace(" - RaviAnand Mohabir", "");
        } else {
            name = n;
        }
        link = "https://dan6erbond.github.io/I1A/Documents/Zusammenfassungen/" + name;
        link = link.replaceAll(" ", "%20");
    }

    public File getFile(Context context){
        File file = new File(context.getExternalFilesDir(null), "/Zusammenfassungen/" + name);
        return file;
    }
}
