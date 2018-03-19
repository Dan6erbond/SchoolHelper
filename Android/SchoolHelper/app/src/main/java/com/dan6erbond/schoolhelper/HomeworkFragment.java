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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeworkFragment extends Fragment {

    //Tutorial used to get FTP knowledge: http://wiki-android.blogspot.ch/2012/12/creating-android-ftp-client-ftp.html
    private ArrayList<Homework> homeworkArray = new ArrayList<>();
    private String homeworkFileURL = "https://api.myjson.com/bins/1h8sp7";

    View view;

    @SuppressLint("HandlerLeak")
    Handler downloadHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            openHomeworkFile();
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_homework, container, false);

        final Button addHomeworkButton = view.findViewById(R.id.homework_add);

        if (isInternetWorking(getActivity())) {
            //Download the File in a seperate Thread
            Thread downloadFile = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        StringBuilder resultReader = new StringBuilder();
                        URL url = new URL(homeworkFileURL);
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        conn.setRequestMethod("GET");
                        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String line;
                        while ((line = rd.readLine()) != null) {
                            resultReader.append(line);
                        }
                        rd.close();
                        final File file = new File(getActivity().getExternalFilesDir(null), "/Homework.json");
                        FileWriter writer = new FileWriter(file);
                        writer.append(resultReader.toString());
                        writer.flush();
                        writer.close();
                        downloadHandler.sendEmptyMessage(0);
                    } catch (Exception e) {
                        Log.i("TAG", e.getMessage());
                    }
                }
            });
            downloadFile.start();

            addHomeworkButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //Build the AlertDialog, set the TextView's text and set the buttons actions.
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogStyle);
                            builder.setMessage(R.string.add_homework);
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
                    });
        } else {
            Toast.makeText(getActivity(), R.string.no_internet, Toast.LENGTH_LONG).show();
            addHomeworkButton.setClickable(false);
            addHomeworkButton.setAlpha(0.5f);
            openHomeworkFile();
        }
        return view;
    }

    private void addHomework(String d, String s, String j) {
        Homework h = new Homework(d, s, j);
        homeworkArray.add(h);
        //remove duplicates
        Set<Homework> hs = new HashSet<>(homeworkArray);
        homeworkArray = new ArrayList<>(hs);
        //sort array -> done after since HashSet doesn't retain order
        Collections.sort(homeworkArray);
        if (isInternetWorking(getActivity())) {
            deleteOldHomework();
            uploadHomework();
        }
        addHomeworkToTable(h);
    }

    private void openHomeworkFile() {
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

            JSONArray homeworkJSONArray = new JSONArray(text.toString());
            for (int i = 0; i < homeworkJSONArray.length(); i++) {
                JSONObject homework = homeworkJSONArray.getJSONObject(i);
                homeworkArray.add(new Homework(homework.getString("datum"), homework.getString("fach"), homework.getString("aufgabe")));
            }
            loadHomeworkTable();
        } catch (Exception e) {
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
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (date1.before(date2)) {
                toRemove.add(homework);
            }
        }
        homeworkArray.removeAll(toRemove);
    }

    private void loadHomeworkTable() {
        for (Homework h : homeworkArray) {
            addHomeworkToTable(h);
        }

        TableLayout tableLayout1 = view.findViewById(R.id.homework_table_tomorrow);
        TableLayout tableLayout2 = view.findViewById(R.id.homework_table_past);
        TableLayout tableLayout3 = view.findViewById(R.id.homework_table_future);
        if (tableLayout1.getChildCount() == 0) {
            TableRow tableRow = new TableRow(getActivity());
            TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(tableRowParams);
            TextView noHomework = new TextView(getActivity());
            noHomework.setText(R.string.no_homework);
            tableRow.addView(noHomework);
            tableRow.setBackgroundResource(R.drawable.homework_row);
            tableLayout1.addView(tableRow);
        }
        if (tableLayout2.getChildCount() == 0) {
            TableRow tableRow = new TableRow(getActivity());
            TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(tableRowParams);
            TextView noHomework = new TextView(getActivity());
            noHomework.setText(R.string.no_homework);
            tableRow.addView(noHomework);
            tableRow.setBackgroundResource(R.drawable.homework_row);
            tableLayout2.addView(tableRow);
        }
        if (tableLayout3.getChildCount() == 0) {
            TableRow tableRow = new TableRow(getActivity());
            TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(tableRowParams);
            TextView noHomework = new TextView(getActivity());
            noHomework.setText(R.string.no_homework);
            tableRow.addView(noHomework);
            tableRow.setBackgroundResource(R.drawable.homework_row);
            tableLayout3.addView(tableRow);
        }
    }

    private void addHomeworkToTable(Homework h) {
        //Format which is used to save the homework's date
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        //Date of the Homework
        Date date1 = new Date();
        //tomorrow's date
        Date date2 = new Date(date1.getTime() + 1 * 24 * 60 * 60 * 1000);
        try {
            date1 = format.parse(h.date);
        } catch (ParseException e) {
            Log.i("TAG", e.getMessage());
        }
        TableLayout tableLayout = view.findViewById(R.id.homework_table_future);
        if (format.format(date1).equals(format.format(date2))) {
            //Homework is for tomorrow
            tableLayout = view.findViewById(R.id.homework_table_tomorrow);
        } else if (date1.before(date2)) {
            //Homework should've been done already
            tableLayout = view.findViewById(R.id.homework_table_past);
        }
        //TableRows to hold subject & date
        TableRow tableRow1 = new TableRow(getActivity());
        TableRow tableRow2 = new TableRow(getActivity());
        //Styling for second TableRow (Job)
        tableRow2.setPadding(0, 5, 0, 5); //A little bit of a padding under each homework row
        tableRow2.setBackgroundResource(R.drawable.homework_row); //Underline the row
        //Date TextView
        TextView date = new TextView(getActivity());
        date.setText(h.date);
        //Subject TextView
        TextView subject = new TextView(getActivity());
        subject.setText(h.subject);
        subject.setPadding(0, 0, 20, 0);
        //Job TextView
        TextView job = new TextView(getActivity());
        job.setText(h.job);
        //Add the different views to the TableRows then to the TableLayout
        tableRow1.addView(date);
        tableRow1.addView(subject);
        tableRow2.addView(job);
        tableLayout.addView(tableRow1);
        tableLayout.addView(tableRow2);
    }

    private boolean isInternetWorking(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private void uploadHomework() {
        JSONArray jArray = new JSONArray();
        try {
            for (Homework h : homeworkArray) {
                JSONObject homeworkJSON = new JSONObject();
                homeworkJSON.put("datum", h.date);
                homeworkJSON.put("fach", h.subject);
                homeworkJSON.put("aufgabe", h.job);
                jArray.put(homeworkJSON);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String jsonContent = jArray.toString();
        final File file = new File(getActivity().getExternalFilesDir(null), "/Homework.json");
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
                try{
                    URL url = new URL(homeworkFileURL);
                    HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                    httpCon.setDoOutput(true);
                    httpCon.setRequestMethod("PUT");
                    httpCon.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                    OutputStreamWriter out = new OutputStreamWriter(
                            httpCon.getOutputStream());
                    out.write(jsonContent);
                    out.close();
                    httpCon.getInputStream();
                } catch (Exception e){
                    Log.i("TAG", e.getMessage());
                }
            }
        });
        uploadFile.start();
    }
}
