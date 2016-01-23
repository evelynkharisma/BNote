package com.segid.bnote;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.segid.bnote.Object.Course;
import com.segid.bnote.Object.Global;
import com.segid.bnote.Object.User;

import java.util.ArrayList;

public class LoginActivity extends Activity  {
    ImageButton mSign_in;
    EditText mNim;
    EditText mPassword;
    final Bundle bundle = new Bundle();

    private ArrayList<String> userid = new ArrayList<String>();
    private ArrayList<String> userpass = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mSign_in=(ImageButton)findViewById(R.id.nim_sign_in_button);
        mNim=(EditText)findViewById(R.id.nim);
        Typeface font = Typeface.createFromAsset(getAssets(), "FUTURA.ttf");
        mNim.setTypeface(font);
        mPassword=(EditText)findViewById(R.id.password);
        mPassword.setTypeface(font);

//        userid.add("userid");
//        userpass.add("password");
//
//        userid.add("studentid");
//        userpass.add("studentpass");

        setUser();



        mSign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean successLogin = false;
                for (int i =0; i < Global.listUsers.size(); i++) {
                    if(mNim.getText().toString().equals(Global.listUsers.get(i).getUserId()) && mPassword.getText().toString().equals(Global.listUsers.get(i).getPassword())) {
                        successLogin = true;
                        Global.user = Global.listUsers.get(i);

                        //save user logged in
                        ObjectRW.writeObject(LoginActivity.this, "user.ser", Global.user);

                        bundle.putString("userid", Global.user.getUserId());
                        Intent intentBundle = new Intent(LoginActivity.this, MainActivity.class);
                        intentBundle.putExtras(bundle);
                        startActivity(intentBundle);
                    }
                }

                if (!successLogin) {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }



//             for(int i=0; i<userid.size(); i++) {
//                if(mNim.getText().toString().equals(userid.get(i)) && mPassword.getText().toString().equals(userpass.get(i))) {
//
//                    bundle.putString("userid", userid.get(i));
//                    Intent intentBundle = new Intent(LoginActivity.this, MainActivity.class);
//                    intentBundle.putExtras(bundle);
//                    startActivity(intentBundle);
//                }
//            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUser() {
        for (int i = 0; i < 3; i++) {
            String userid = "userid" + i;
            String username = "user's name " + i;
            String pass = "pass" + i;
            User tempUser = new User(userid, username, pass);

            tempUser.addCourse(new Course(1, "Artificial Intelligence"));
            tempUser.addCourse(new Course(1, "Multimedia Signal Processing"));
            tempUser.addCourse(new Course(1, "Operating System"));
            tempUser.addCourse(new Course(1, "Project Hatchery"));
            tempUser.addCourse(new Course(1, "Software Engineering"));
            tempUser.addCourse(new Course(1, "Parsing and Translation"));
//        //add course to smt 2
            tempUser.addCourse(new Course(2, "Character Building"));
            tempUser.addCourse(new Course(2, "Computer Graphic"));
            tempUser.addCourse(new Course(2, "Enterprise Application"));
            tempUser.addCourse(new Course(2, "Ethical Hacking"));
            tempUser.addCourse(new Course(2, "Scripting Language"));
            tempUser.addCourse(new Course(2, "Web Programming"));
//        //add course to smt 3
            tempUser.addCourse(new Course(3, "Computer Network"));
            tempUser.addCourse(new Course(3, "Multimedia Sytem"));
            tempUser.addCourse(new Course(3, "Object Oriented Programmming"));
            tempUser.addCourse(new Course(3, "Programming Principle"));

            Global.listUsers.add(tempUser);
        }

        //save list of saved user  + its password
        ObjectRW.writeObject(LoginActivity.this, "listUser.ser", Global.listUsers);
    }
}