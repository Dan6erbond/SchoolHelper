package com.dan6erbond.schoolhelper;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class HomeworkFragment extends Fragment {

    //Tutorial used to get FTP knowledge: http://wiki-android.blogspot.ch/2012/12/creating-android-ftp-client-ftp.html
    private FTPClient mFTPClient = new FTPClient();
    ArrayList<Homework> homeworkArray = new ArrayList<Homework>();

    @SuppressLint("HandlerLeak")
    Handler downloadHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            openHomeworkFile();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homework, container, false);

        if(isInternetWorking(getActivity())){
            //Download the File in a seperate Thread
            Thread downloadFile = new Thread(new Runnable() {
                @Override
                public void run() {
                    //Connect to the host
                    try {
                        mFTPClient.connect("dan6erbond.bplaced.net", 21);
                    } catch (IOException e) {
                        Log.i("TAG", e.getMessage());
                    }
                    try {
                        mFTPClient.login("dan6erbond_I1A", "I1A_2017_18");
                    } catch (IOException e) {
                        Log.i("TAG", e.getMessage());
                    }
                    //Check the reply code, if positive mean connection success
                    if (FTPReply.isPositiveCompletion(mFTPClient.getReplyCode())) {
                        //Set File Transfer Mode to ASCII File Type to transfer basic text
                        try {
                            mFTPClient.setFileType(FTP.ASCII_FILE_TYPE);
                        } catch (IOException e) {
                            Log.i("TAG", e.getMessage());
                        }
                        mFTPClient.enterLocalPassiveMode();

                        String desFilePath = new File(getActivity().getExternalFilesDir(null), "/Homework.json").getPath();
                        FileOutputStream desFileStream = null;
                        try {
                            desFileStream = new FileOutputStream(desFilePath);
                        } catch (FileNotFoundException e) {
                            Log.i("TAG", e.getMessage());
                        }
                        try {
                            mFTPClient.retrieveFile("Hausaufgaben.json", desFileStream);
                        } catch (IOException e) {
                            Log.i("TAG", e.getMessage());
                        }
                        try {
                            desFileStream.close();
                        } catch (IOException e) {
                            Log.i("TAG", e.getMessage());
                        }

                        //Call downloadHandler's handleMessage
                        downloadHandler.sendEmptyMessage(0);
                    }
                }
            });
            downloadFile.start();
        } else {
            Toast.makeText(getActivity(), R.string.no_internet, Toast.LENGTH_LONG).show();
            openHomeworkFile();
        }

        final Button addHomeworkButton = view.findViewById(R.id.homework_add);
        addHomeworkButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //Build the AlertDialog, set the TextView's text and set the buttons actions.
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogStyle);
                        View view = getLayoutInflater().inflate(R.layout.dialog_add_homework, null);
                        final DatePicker datePicker = view.findViewById(R.id.dialog_add_homework_date);
                        final Spinner subject = view.findViewById(R.id.dialog_add_homework_subject);
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.subjects, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        subject.setAdapter(adapter);
                        final EditText job = view.findViewById(R.id.dialog_add_homework_job);
                        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Calendar calendar = Calendar.getInstance();
                                calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                                Date dateUnform = calendar.getTime();
                                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                                String date = format.format(dateUnform);

                                addHomework(date, subject.getSelectedItem().toString(), job.getText().toString());
                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                        builder.setView(view);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
        );

        return view;
    }

    private void addHomework(String d, String s, String j){
        Homework h = new Homework(d, s, j);
        homeworkArray.add(h);
        addHomeworkToTable(h);
        uploadHomework();
    }

    private void openHomeworkFile(){
        //Create new file variable by using desFilePath as path
        File file = new File(getActivity().getExternalFilesDir(null), "/Homework.json");
        //Read text from file
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
        }
        catch (IOException e) {
            Log.i("TAG", e.getMessage());
        }
        try {
            JSONArray homeworkJSONArray = new JSONArray(text.toString());
            for (int i = 0; i < homeworkJSONArray.length(); i++) {
                JSONObject homework = new JSONObject();
                try {
                    homework = homeworkJSONArray.getJSONObject(i);
                } catch (JSONException e) {
                    Log.i("TAG", e.getMessage());
                }
                homeworkArray.add(new Homework(homework.getString("datum"), homework.getString("fach"), homework.getString("aufgabe")));
            }
            Collections.sort(homeworkArray);
            deleteOldHomework();
            uploadHomework();
            loadHomeworkTable();
        } catch (JSONException e) {
            Log.i("TAG", e.getMessage());
        }
    }

    private void deleteOldHomework() {
        List<Homework> toRemove = new ArrayList<>();
        for (Homework homework : homeworkArray) {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");

            Date date1 = new Date();
            Date date2 = new Date(date1.getTime() - 3 * 24 * 60 * 60 * 1000);

            try {
                date1 = format.parse(homework.date);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }

            if(date1.before(date2)){
                Log.i("TAG", homework.job);
                toRemove.add(homework);
            }
        }
        homeworkArray.removeAll(toRemove);
    }

    private void loadHomeworkTable() {
        for (Homework h : homeworkArray){
            addHomeworkToTable(h);
        }
    }

    private void addHomeworkToTable(Homework h){
        TableLayout tableLayout = getActivity().findViewById(R.id.homework_table);
        TableRow tableRow = new TableRow(getActivity());
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tableRow.setLayoutParams(tableRowParams);
        TextView date = new TextView(getActivity());
        date.setText(h.date);
        date.setEms(6);
        TextView subject = new TextView(getActivity());
        subject.setText(h.subject);
        subject.setEms(10);
        TextView job = new TextView(getActivity());
        job.setText(h.job);
        tableRow.addView(date);
        tableRow.addView(subject);
        tableRow.addView(job);
        tableRow.setBackgroundResource(R.drawable.homework_row);
        tableLayout.addView(tableRow);
    }

    private boolean isInternetWorking(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private void uploadHomework(){
        JSONArray jArray = new JSONArray();
        try
        {
            for (Homework h : homeworkArray)
            {
                JSONObject homeworkJSON = new JSONObject();
                homeworkJSON.put("datum", h.date);
                homeworkJSON.put("fach", h.subject);
                homeworkJSON.put("aufgabe", h.job);
                jArray.put(homeworkJSON);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonContent = jArray.toString();
        final File file = new File(getActivity().getExternalFilesDir(null), "/Homework.json");
        if(file.exists())
            file.delete();
        try {
            FileWriter writer = new FileWriter(file);
            writer.append(jsonContent);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Upload the File in a seperate thread
        Thread uploadFile = new Thread(new Runnable() {
            @Override
            public void run() {
                FileInputStream srcFileStream = null;
                try {
                    srcFileStream = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    mFTPClient.storeFile("Hausaufgaben.json", srcFileStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    srcFileStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        uploadFile.start();
    }

    @Override
    public void onDestroy() {
        try {
            mFTPClient.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mFTPClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }
}
