package com.segid.bnote;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        NavigationView navigationView = null;
        Toolbar toolbar = null;
        final Bundle bundle = new Bundle();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SemesterFragment fragment = new SemesterFragment();
        bundle.putInt("semester", 1);
        fragment.setArguments(bundle);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        TextView textView = (TextView) findViewById(R.id.toolbar_page);
        textView.setText("SEMESTER 1");
        Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
        textView.setTypeface(font);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Drawer Button
        ImageButton drawerOpenButton = (ImageButton) findViewById(R.id.navButtonOpen);
        drawerOpenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        ImageButton drawerCloseButton = (ImageButton) findViewById(R.id.navButtonClose);
        drawerCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        // Semester Button
        ImageButton semester1Button = (ImageButton) findViewById(R.id.nav_period1);
        semester1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemesterFragment fragment = new SemesterFragment();
                bundle.putInt("semester",1);
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                TextView textView = (TextView) findViewById(R.id.toolbar_page);
                textView.setText("SEMESTER 1");
                Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
                textView.setTypeface(font);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ImageButton semester2Button = (ImageButton) findViewById(R.id.nav_period2);
        semester2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemesterFragment fragment = new SemesterFragment();
                bundle.putInt("semester",2);
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                TextView textView = (TextView) findViewById(R.id.toolbar_page);
                textView.setText("SEMESTER 2");
                Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
                textView.setTypeface(font);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ImageButton semester3Button = (ImageButton) findViewById(R.id.nav_period3);
        semester3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemesterFragment fragment = new SemesterFragment();
                bundle.putInt("semester",3);
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                TextView textView = (TextView) findViewById(R.id.toolbar_page);
                textView.setText("SEMESTER 3");
                Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
                textView.setTypeface(font);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ImageButton semester4Button = (ImageButton) findViewById(R.id.nav_period4);
        semester4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemesterFragment fragment = new SemesterFragment();
                bundle.putInt("semester",4);
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                TextView textView = (TextView) findViewById(R.id.toolbar_page);
                textView.setText("SEMESTER 4");
                Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
                textView.setTypeface(font);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ImageButton semester5Button = (ImageButton) findViewById(R.id.nav_period5);
        semester5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemesterFragment fragment = new SemesterFragment();
                bundle.putInt("semester",5);
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                TextView textView = (TextView) findViewById(R.id.toolbar_page);
                textView.setText("SEMESTER 5");
                Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
                textView.setTypeface(font);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        ImageButton semester6Button = (ImageButton) findViewById(R.id.nav_period6);
        semester6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemesterFragment fragment = new SemesterFragment();
                bundle.putInt("semester",6);
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                TextView textView = (TextView) findViewById(R.id.toolbar_page);
                textView.setText("SEMESTER 6");
                Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
                textView.setTypeface(font);
                drawer.closeDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_setting) {
            //drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            //drawer.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_help) {
            HelpFragment fragment = new HelpFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            TextView textView = (TextView) findViewById(R.id.toolbar_page);
            textView.setText("HELP");
            Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
            textView.setTypeface(font);
        }  else if (id == R.id.nav_about) {
            AboutFragment fragment = new AboutFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            TextView textView = (TextView) findViewById(R.id.toolbar_page);
            textView.setText("ABOUT");
            Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
            textView.setTypeface(font);
        }else if (id == R.id.nav_setting) {
            SettingFragment fragment = new SettingFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            TextView textView = (TextView) findViewById(R.id.toolbar_page);
            textView.setText("SETTINGS");
            Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
            textView.setTypeface(font);
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}