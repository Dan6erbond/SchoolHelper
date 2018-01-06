package com.dan6erbond.schoolhelper;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ZusammenfassungenFragment extends Fragment {

    private String zusammenfassungenLink = "https://dan6erbond.github.io/I1A/Documents/Zusammenfassungen/Zusammenfassungen.json";
    private String content;

    private RelativeLayout relativeLayout;

    DownloadManager downloadManager;

    @SuppressLint("HandlerLeak")
    Handler downloadHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            try {
                //Convert the json string to an array
                JSONArray zusammenfassungenArray = new JSONArray(content.substring(4));

                //Create Buttons
                createButtons(zusammenfassungenArray);
            } catch (JSONException e) {
                Log.i("TAG", e.getMessage());
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zusammenfassungen, container, false);

        relativeLayout = view.findViewById(R.id.zusammenfassungen_layout);

        if(isInternetWorking(getActivity())) {
            //Download the File in a seperate Thread
            Thread downloadFile = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = new URL(zusammenfassungenLink);
                        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                        String str;
                        //Add each line of the text to a string
                        while ((str = in.readLine()) != null) {
                            content += str;
                        }
                        in.close();
                    } catch (Exception e) {
                        Log.i("TAG", e.getMessage());
                    }
                    //Call downloadHandler's handleMessage
                    downloadHandler.sendEmptyMessage(0);
                }
            });
            downloadFile.start();
        } else {
            Toast.makeText(getActivity(), R.string.no_internet, Toast.LENGTH_LONG).show();
        }

        return view;
    }

    private boolean isInternetWorking(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private void createButtons(JSONArray zusammenfassungenArray) throws JSONException {
        int previousId = 0;

        //Scan through all the zusammenfassungen
        for (int i = 0; i < zusammenfassungenArray.length(); i++){
            //Get current Zusammenfassung
            JSONObject zusammenfassung = zusammenfassungenArray.getJSONObject(i);
            //Get its Data
            String subject = zusammenfassung.getString("fach");
            String topic = zusammenfassung.getString("thema");
            String date = zusammenfassung.getString("datum");

            //Create a new Button
            Button button = new Button(getActivity());
            //Generate an id for the Button and set it
            int id = View.generateViewId();
            button.setId(id);
            //Set the text of the button
            button.setText(subject + " - " + topic);
            //Generate LayoutParams for the Button
            RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
            //Place it under the previous Button created if there is one
            if(previousId != 0)
                buttonParams.addRule(RelativeLayout.BELOW, previousId);
                //Otherwise place it under the title
            else
                buttonParams.addRule(RelativeLayout.BELOW, R.id.zusammenfassung_title);
            //Further styling
            buttonParams.setMargins(convertDpToPx(10), convertDpToPx(5), convertDpToPx(10), convertDpToPx(5));
            button.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            button.setTextColor(Color.parseColor("#FFFFFF"));
            //Save the Button in the previousId parameter to place the next button below it
            previousId = id;
            //Apply the LayoutParams to the button
            button.setLayoutParams(buttonParams);
            //Give the button an onclick listener
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    downloadZusammenfassung(v);
                }
            });

            relativeLayout.addView(button);
        }
    }

    private int convertDpToPx(int dp){
        return Math.round(dp*(getResources().getDisplayMetrics().xdpi/ DisplayMetrics.DENSITY_DEFAULT));
    }

    private void downloadZusammenfassung(View v){
        downloadManager = (DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        Button button = (Button)v;
        String zusammenfassungLink = "https://dan6erbond.github.io/I1A/Documents/Zusammenfassungen/" + button.getText() + ".pdf";
        Log.i("TAG", zusammenfassungLink);
        Uri uri = Uri.parse(zusammenfassungLink);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        Long reference = downloadManager.enqueue(request);
    }

}