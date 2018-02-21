package com.dan6erbond.schoolhelper;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

public class ZusammenfassungenFragment extends Fragment {

    private String zusammenfassungenLink = "https://dan6erbond.github.io/I1A/Documents/Zusammenfassungen/Zusammenfassungen.json";
    private String content;

    private int previousId = 0;

    private RelativeLayout relativeLayout;

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
            File dir = new File(getActivity().getExternalFilesDir(null), "/Zusammenfassungen/");
            File[] files = dir.listFiles();
            for (File file:files) {
                Zusammenfassung zusammenfassung = new Zusammenfassung("","","","", file.getName());
                createZusammenfassungButton(zusammenfassung);
            }
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
        //Scan through all the zusammenfassungen
        for (int i = 0; i < zusammenfassungenArray.length(); i++) {
            //Get current Zusammenfassung
            JSONObject zusammenfassungJSON = zusammenfassungenArray.getJSONObject(i);
            Zusammenfassung zusammenfassung = new Zusammenfassung(zusammenfassungJSON.getString("fach"), zusammenfassungJSON.getString("thema"), zusammenfassungJSON.getString("datum"), zusammenfassungJSON.getString("autor"), "");
            Log.i("TAG", zusammenfassung.getFile(getActivity()).getPath());
            createZusammenfassungButton(zusammenfassung);
        }
    }

    private int convertDpToPx(int dp){
        return Math.round(dp*(getResources().getDisplayMetrics().xdpi/ DisplayMetrics.DENSITY_DEFAULT));
    }

    private void createZusammenfassungButton(Zusammenfassung z) {
        final Zusammenfassung zusammenfassung = z;
        //Create a new Button
        Button button = new Button(getActivity());
        //Generate an id for the Button and set it
        int id = ViewIdGenerator.generateViewId();
        button.setId(id);
        //Set the text of the button
        if (zusammenfassung.subject != "")
            button.setText(zusammenfassung.subject + " - " + zusammenfassung.topic);
        else
            button.setText(zusammenfassung.name);
        //Generate LayoutParams for the Button
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        //Place it under the previous Button created if there is one
        if (previousId != 0)
            buttonParams.addRule(RelativeLayout.BELOW, previousId);
            //Otherwise place it under the title
        else
            buttonParams.addRule(RelativeLayout.BELOW, R.id.zusammenfassung_title);
        //Save the Button in the previousId parameter to place the next button below it
        previousId = id;
        //Further styling
        buttonParams.setMargins(convertDpToPx(10), convertDpToPx(5), convertDpToPx(10), convertDpToPx(5));
        button.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        button.setTextColor(getResources().getColor(R.color.white));
        //Apply the LayoutParams to the button
        button.setLayoutParams(buttonParams);
        //Give the button an onclick listener
        if (zusammenfassung.subject != "") {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Build the AlertDialog, set the TextView's text and set the buttons actions.
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.ZusammenfassungDialogStyle);
                    View view = getLayoutInflater().inflate(R.layout.dialog_zusammenfassung, null);
                    TextView tvTitle = view.findViewById(R.id.dialog_zusammenfassung_title);
                    TextView tvSubject = view.findViewById(R.id.dialog_zusammenfassung_subject);
                    TextView tvTopic = view.findViewById(R.id.dialog_zusammenfassung_topic);
                    TextView tvDate = view.findViewById(R.id.dialog_zusammenfassung_date);
                    TextView tvLink = view.findViewById(R.id.dialog_zusammenfassung_link);
                    TextView tvAuthor = view.findViewById(R.id.dialog_zusammenfassung_author);
                    tvTitle.setText(zusammenfassung.name);
                    tvSubject.setText(zusammenfassung.subject);
                    tvTopic.setText(zusammenfassung.topic);
                    tvDate.setText(zusammenfassung.date);
                    tvLink.setText(zusammenfassung.link);
                    tvAuthor.setText(zusammenfassung.author);
                    builder.setPositiveButton(R.string.download, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                            downloadZusammenfassung(zusammenfassung);
                        }
                    });
                    builder.setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    final File zusammenfassungFile = zusammenfassung.getFile(getActivity());
                    if (zusammenfassungFile.exists()) {
                        builder.setNeutralButton(R.string.open, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                                openPDF(zusammenfassungFile);
                            }
                        });
                    }
                    builder.setView(view);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        } else {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openPDF(zusammenfassung.getFile(getActivity()));
                }
            });
        }

        relativeLayout.addView(button);
    }

    private void downloadZusammenfassung(Zusammenfassung zusammenfassung) {
        final File zusammenfassungFile = zusammenfassung.getFile(getActivity());
        if(zusammenfassungFile.exists()) {
            zusammenfassungFile.delete();
        }
        DownloadManager downloadManager = (DownloadManager)getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(zusammenfassung.link));
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(getActivity(), "Zusammenfassungen/", zusammenfassung.name);
        downloadManager.enqueue(request);
        BroadcastReceiver onComplete = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                openPDF(zusammenfassungFile);
            }
        };
        getActivity().registerReceiver (onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    private void openPDF(File file){
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(file),"application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(target, getString(R.string.open_file));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getActivity(), R.string.no_pdf_viewer, Toast.LENGTH_LONG).show();
        }
    }
}