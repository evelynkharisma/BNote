package com.segid.bnote;

import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    TextView dUsername;
    TextView dUserID;
    ImageView pImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Intent intentExtras = getIntent();
        Bundle bundleExtras = intentExtras.getExtras();
        final String bundleUserid = bundleExtras.getString("userid");

        NavigationView navigationView = null;
        Toolbar toolbar = null;
        final Bundle bundle = new Bundle();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SemesterFragment fragment = new SemesterFragment();
        bundle.putInt("semester", 1);
        bundle.putString("userid", bundleUserid);
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

        dUsername = (TextView) findViewById(R.id.drawerusername);
        if(bundleUserid.equals("userid"))
        {
            dUsername.setText("First User");
        }
        else
        {
            dUsername.setText("Second User");
        }
        dUserID = (TextView) findViewById(R.id.draweruserid);
        dUserID.setText(bundleUserid);

        // Semester Button
        ImageButton semester1Button = (ImageButton) findViewById(R.id.nav_period1);
        semester1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SemesterFragment fragment = new SemesterFragment();
                bundle.putInt("semester",1);
                bundle.putString("userid", bundleUserid);
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
                bundle.putString("userid", bundleUserid);
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
                bundle.putString("userid", bundleUserid);
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
                bundle.putString("userid", bundleUserid);
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
                bundle.putString("userid", bundleUserid);
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
                bundle.putString("userid", bundleUserid);
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

        pImageView = (ImageView) findViewById(R.id.profile_picture);
        pImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                SettingFragment fragment = new SettingFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                TextView textView = (TextView) findViewById(R.id.toolbar_page);
                textView.setText("PROFILE");
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
        }else if (id == R.id.nav_logout) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }/*else if (id == R.id.nav_setting) {
            SettingFragment fragment = new SettingFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            TextView textView = (TextView) findViewById(R.id.toolbar_page);
            textView.setText("SETTINGS");
            Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
            textView.setTypeface(font);
        }*/

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}