package com.dan6erbond.schoolhelper;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.ShareActionProvider;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle nToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRequiredPermissions();
        createFirstFragment();

        drawerLayout = findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView mNavigationView = findViewById(R.id.navigation_menu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
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

    private void getRequiredPermissions() {
        int writeCheck = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (writeCheck != PackageManager.PERMISSION_GRANTED && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1024);
    }

    private void createFirstFragment(){
        HomeFragment fragment = new HomeFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.home_fragment_container, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    public void changeFragment(Fragment fragment){
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
        if(nToggle.onOptionsItemSelected(item)){
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

    private void share(){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = getString(R.string.share_text);
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.share_via)));
    }
}