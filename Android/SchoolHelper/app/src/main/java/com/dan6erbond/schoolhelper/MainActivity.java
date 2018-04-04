package com.dan6erbond.schoolhelper;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle nToggle;

    //Public variables for other fragments to access
    public List<TimetableClass> timetable = new ArrayList<>();
    public List<Homework> homeworks = new ArrayList<>();
    public JSONArray zusammenfassungenArray = new JSONArray();
    public boolean loadedFiles;

    @SuppressLint("HandlerLeak")
    Handler updateAvailable = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            showUpdateMessage();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRequiredPermissions();
        createFirstFragment();
        initializeNavigationDrawer();

        if (isInternetWorking()) {
            startInternetThread();
        } else {
            Thread loadFiles = new Thread(new Runnable() {
                @Override
                public void run() {
                    loadFiles();
                }
            });
            loadFiles.start();
        }
    }

    private void initializeNavigationDrawer() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();

        NavigationView mNavigationView = findViewById(R.id.navigation_menu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        changeFragment(new HomeFragment());
                        break;
                    case R.id.nav_zusammenfassungen:
                        changeFragment(new ZusammenfassungenFragment());
                        break;
                    case R.id.nav_french_times:
                        changeFragment(new FrenchTimesFragment());
                        break;
                    case R.id.nav_french:
                        changeFragment(new FrenchFragment());
                        break;
                    case R.id.nav_timetable:
                        changeFragment(new TimetableFragment());
                        break;
                    case R.id.nav_homework:
                        changeFragment(new HomeworkFragment());
                        break;
                    case R.id.nav_about:
                        changeFragment(new AboutFragment());
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    private void loadFiles() {
        //timetable
        try {
            File timetableFile = new File(getExternalFilesDir(null), "/Timetable.json");
            StringBuilder text = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(timetableFile));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
            JSONArray JSONTimetable = new JSONArray(text.toString());
            for (int i = 0; i < JSONTimetable.length(); i++) {
                JSONObject classObject = JSONTimetable.getJSONObject(i);
                TimetableClass timetableClass = new TimetableClass(classObject.getString("startTime"), classObject.getString("endTime"), classObject.getString("subject"), classObject.getString("teacher"), classObject.getString("location"), classObject.getString("day"));
                timetable.add(timetableClass);
            }
        } catch (Exception e) {
            Log.i("TAG", e.getMessage());
        }

        //homework
        try {
            String line;
            StringBuilder text = new StringBuilder();
            File homeworkFile = new File(getExternalFilesDir(null), "/Homework.json");
            BufferedReader br = new BufferedReader(new FileReader(homeworkFile));
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();

            JSONArray homeworkJSONArray = new JSONArray(text.toString());
            for (int i = 0; i < homeworkJSONArray.length(); i++) {
                JSONObject homework = homeworkJSONArray.getJSONObject(i);
                homeworks.add(new Homework(homework.getString("datum"), homework.getString("fach"), homework.getString("aufgabe")));
            }
        } catch (Exception e) {
            Log.i("TAG", e.getMessage());
        }

        loadedFiles = true;
    }

    private void startInternetThread() {
        Thread internetThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //check for updates
                try {
                    StringBuilder resultReader = new StringBuilder();
                    URL url = new URL("https://api.github.com/repos/Dan6erbond/SchoolHelper/releases/latest");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line;
                    while ((line = rd.readLine()) != null) {
                        resultReader.append(line);
                    }
                    JSONObject object = new JSONObject(resultReader.toString());
                    PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                    if (Float.parseFloat(object.get("tag_name").toString()) > Float.parseFloat(pInfo.versionName)) {
                        updateAvailable.sendEmptyMessage(0);
                    }
                } catch (Exception e) {
                    Log.i("TAG", "Error: " + e.getMessage());
                }

                //download timetable file
                int count;
                File timetableFile = new File(getExternalFilesDir(null), "/Timetable.json");
                try {
                    URL url = new URL("https://dan6erbond.github.io/I1A/Documents/Timetable.json");
                    URLConnection conection = url.openConnection();
                    conection.connect();

                    InputStream input = new BufferedInputStream(url.openStream(),
                            8192);

                    OutputStream output = new FileOutputStream(timetableFile.getPath());

                    byte data[] = new byte[1024];

                    while ((count = input.read(data)) != -1) {
                        output.write(data, 0, count);
                    }

                    output.flush();

                    output.close();
                    input.close();
                } catch (Exception e) {
                    Log.i("TAG", e.getMessage());
                }

                //download homework file
                try {
                    StringBuilder resultReader = new StringBuilder();
                    URL url = new URL("https://api.myjson.com/bins/1h8sp7");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line;
                    while ((line = rd.readLine()) != null) {
                        resultReader.append(line);
                    }
                    rd.close();
                    File homeworkFile = new File(getExternalFilesDir(null), "/Homework.json");
                    FileWriter writer = new FileWriter(homeworkFile);
                    writer.append(resultReader.toString());
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    Log.i("TAG", e.getMessage());
                }

                //download summary file and load summary array for online users
                try {
                    URL url = new URL("https://dan6erbond.github.io/I1A/Documents/Zusammenfassungen/Zusammenfassungen.json");
                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                    String str;
                    String content = "";
                    while ((str = in.readLine()) != null) {
                        content += str;
                    }
                    in.close();

                    zusammenfassungenArray = new JSONArray(content);
                } catch (Exception e) {
                    Log.i("TAG", e.getMessage());
                }

                loadFiles();
            }
        });
        internetThread.start();
    }

    private void showUpdateMessage() {
        //Build the AlertDialog, set the TextView's text and set the buttons actions.
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyle);
        builder.setMessage("An Update is available!");
        View view = getLayoutInflater().inflate(R.layout.dialog_update_available, null);
        builder.setPositiveButton("Download", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Dan6erbond/SchoolHelper"));
                startActivity(browserIntent);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Ignore", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public boolean isInternetWorking() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }

    private void addNotification(int hour, int min, int reqCode) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), reqCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmManager.INTERVAL_DAY, pendingIntent);
    }

    private void getRequiredPermissions() {
        int writeCheck = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (writeCheck != PackageManager.PERMISSION_GRANTED && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1024);
    }

    private void createFirstFragment() {
        HomeFragment fragment = new HomeFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.home_fragment_container, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.home_fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (nToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.main_menu_about:
                changeFragment(new AboutFragment());
                break;
            case R.id.main_menu_share:
                share();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void share() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = getString(R.string.share_text);
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.share_via)));
    }

    public void openPDF(File file) {
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(file), "application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        Intent intent = Intent.createChooser(target, getString(R.string.open_file));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, R.string.no_pdf_viewer, Toast.LENGTH_LONG).show();
        }
    }
}