package com.segid.bnote;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddNote extends AppCompatActivity {

    private TextView toolbarTitle;
    private Button btnBack;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbarTitle.setText("B-Notes");
        toolbarTitle.setTextColor(getResources().getColor(R.color.bnote_white));
        Typeface font = Typeface.createFromAsset(getAssets(), "Arial Rounded Bold.ttf");
        toolbarTitle.setTypeface(font);

        btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setBackground(getResources().getDrawable(R.drawable.bnotes37));
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

        editText = (EditText) findViewById(R.id.editText);
        editText.setTypeface(font);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("newNote", editText.getText());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }
}
