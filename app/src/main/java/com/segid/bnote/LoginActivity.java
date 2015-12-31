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

public class LoginActivity extends Activity  {
    ImageButton mSign_in;
    EditText mNim;
    EditText mPassword;

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


        mSign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mNim.getText().toString().equals("admin") &&

                        mPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
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