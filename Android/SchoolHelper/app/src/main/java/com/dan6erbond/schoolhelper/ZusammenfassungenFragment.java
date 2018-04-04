package com.dan6erbond.schoolhelper;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;

public class ZusammenfassungenFragment extends Fragment {


    private MainActivity mActivity;

    private int previousId = 0;

    private RelativeLayout relativeLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zusammenfassungen, container, false);

        mActivity = (MainActivity)getActivity();

        relativeLayout = view.findViewById(R.id.zusammenfassungen_layout);

        if(mActivity.isInternetWorking()) {
            while(!mActivity.loadedFiles);
            createButtons();
        } else {
            File dir = new File(getActivity().getExternalFilesDir(null), "/Zusammenfassungen/");
            File[] files = dir.listFiles();
            if(files != null){
                Toast.makeText(getActivity(), R.string.no_internet, Toast.LENGTH_LONG).show();
                for (File file:files) {
                    createZusammenfassungButton(new Zusammenfassung(file.getName()));
                }
            } else {
                Toast.makeText(getActivity(), R.string.no_downloaded_zusammenfassungen, Toast.LENGTH_LONG).show();
            }
        }

        return view;
    }

    private void createButtons() {
        //Scan through all the zusammenfassungen
        for (int i = 0; i < mActivity.zusammenfassungenArray.length(); i++) {
            Zusammenfassung zusammenfassung = null;
            try {
                zusammenfassung = new Zusammenfassung(mActivity.zusammenfassungenArray.getJSONObject(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogStyle);
                    View view = getLayoutInflater().inflate(R.layout.dialog_zusammenfassung, null);
                    builder.setMessage(zusammenfassung.name);
                    TextView tvSubject = view.findViewById(R.id.dialog_zusammenfassung_subject);
                    TextView tvTopic = view.findViewById(R.id.dialog_zusammenfassung_topic);
                    TextView tvDate = view.findViewById(R.id.dialog_zusammenfassung_date);
                    TextView tvLink = view.findViewById(R.id.dialog_zusammenfassung_link);
                    TextView tvAuthor = view.findViewById(R.id.dialog_zusammenfassung_author);
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
                                mActivity.openPDF(zusammenfassungFile);
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
                    mActivity.openPDF(zusammenfassung.getFile(getActivity()));
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
                mActivity.openPDF(zusammenfassungFile);
            }
        };
        getActivity().registerReceiver (onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }
}