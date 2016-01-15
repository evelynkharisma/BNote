package com.segid.bnote;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.segid.bnote.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

        userid.add("userid");
        userpass.add("password");

        userid.add("studentid");
        userpass.add("studentpass");


        mSign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            for(int i=0; i<userid.size(); i++)
            {
                if(mNim.getText().toString().equals(userid.get(i)) && mPassword.getText().toString().equals(userpass.get(i))) {
                    bundle.putString("userid", userid.get(i));
                    Intent intentBundle = new Intent(LoginActivity.this, MainActivity.class);
                    intentBundle.putExtras(bundle);
                    startActivity(intentBundle);
                }
                else{
                }
            }

            }
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
}