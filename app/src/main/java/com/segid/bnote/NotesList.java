package com.segid.bnote;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesList extends AppCompatActivity {

    private Button btnCamera;
    private Button btnDots;
    private Button btnNotes;
    private Button btnImage;
    private Button btnPlus;
    private Boolean visible;
    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<LinearLayout> linearLayouts = new ArrayList<>();

    private Display display;

    private int btnID;
    private int linearlayoutID;
    private int screenWidth;
    private int screenHeight;

    private Point size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initialize();
        populateLinearLayout();
        btnActionListener();

    }

    private void initialize() {
        btnCamera = (Button) findViewById(R.id.btn_camera);
        btnCamera.setVisibility(View.INVISIBLE);

        btnNotes = (Button) findViewById(R.id.btn_notes);
        btnNotes.setVisibility(View.INVISIBLE);

        btnImage = (Button) findViewById(R.id.btn_image);
        btnImage.setVisibility(View.INVISIBLE);

        btnPlus = (Button) findViewById(R.id.btn_plus);
        btnPlus.setVisibility(View.VISIBLE);

        btnDots = (Button) findViewById(R.id.btn_dots);
        btnDots = (Button)findViewById(R.id.btn_dots);

        btnID = 0;

        size = new Point();
        display = getWindowManager().getDefaultDisplay();
        display.getSize(size);
        screenHeight = size.y;
        screenWidth = size.x;

        visible = false;
    }

    private void btnActionListener() {
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!visible) {
                    btnCamera.setVisibility(View.VISIBLE);
                    btnNotes.setVisibility(View.VISIBLE);
                    btnImage.setVisibility(View.VISIBLE);
                    visible = true;
                } else {
                    btnCamera.setVisibility(View.INVISIBLE);
                    btnNotes.setVisibility(View.INVISIBLE);
                    btnImage.setVisibility(View.INVISIBLE);
                    visible = false;
                }
            }
        });

        for (int i=0; i< linearLayouts.size(); i++) {
            linearLayouts.get(i).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(NotesList.this, OpenNote.class);
                    startActivity(intent);
                }
            });
        }
    }

    public void populateLinearLayout() {
        TableLayout table = (TableLayout) findViewById(R.id.tableThumbnail);
        int num_rows = 3;
        int num_columns = 2;

        for (int i=0; i<3; i++) {
            TableRow tableRow = new TableRow(this);
            table.addView(tableRow);

            for (int j=0; j<2; j++) {
                LinearLayout ll = getFolder(R.drawable.rounded_rectangle, R.drawable.notes, R.drawable.bnotes07, 3, "Teylor Suwift", "23/11/2015", "Sequential Art -  Comic Making Philosophy..", "8:39 AM");

                TableRow.LayoutParams tblRowParam = new TableRow.LayoutParams(screenWidth, screenHeight/4, 1.0f);
                if (j==0) {
                    tblRowParam.setMarginEnd(40);
                }
                tblRowParam.setMargins(0, 40, 0, 0);
                ll.setLayoutParams(tblRowParam);
                linearLayouts.add(ll);
                linearlayoutID++;
                tableRow.addView(ll);
            }
        }
    }

    public Bitmap getCroppedBitmap(Bitmap bmp, int radius) {
        Bitmap sbmp;
        if(bmp.getWidth() != radius || bmp.getHeight() != radius)
            sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
        else
            sbmp = bmp;
        Bitmap output = Bitmap.createBitmap(sbmp.getWidth(),
                sbmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xffa19774;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, sbmp.getWidth(), sbmp.getHeight());


        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(getResources().getColor(R.color.bnote_transparent));
        canvas.drawRoundRect(new RectF(10, 10, 500, 500), 70, 70, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);


        return output;
    }

    public LinearLayout getFolder(int backgroundDrawable, int notesImage, int userImage, int totalComment, String userName, String date, String desctiption, String time) {
        LinearLayout toReturn = new LinearLayout(this);
        toReturn.setOrientation(LinearLayout.VERTICAL);
        toReturn.setClickable(true);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), notesImage);
        Bitmap rounded = getCroppedBitmap(largeIcon, 500);
        Drawable drawable=new BitmapDrawable(rounded);
        LinearLayout layoutImage = new LinearLayout(this);
        layoutImage.setBackground(drawable);

        Bitmap btDarker = BitmapFactory.decodeResource(getResources(), R.drawable.darker);
        Bitmap roundedDarker = getCroppedBitmap(btDarker, 500);
        Drawable drawableDarker =new BitmapDrawable(roundedDarker);
        LinearLayout darker = new LinearLayout(this);
        darker.setOrientation(LinearLayout.VERTICAL);
        darker.setBackground(drawableDarker);

        //layout for user image and user name
        LinearLayout layoutUserData = new LinearLayout(this);

        //user image
        ImageView userImageView = new ImageView(this);
        userImageView.setImageResource(userImage);
        LinearLayout.LayoutParams userImageParam = new LinearLayout.LayoutParams(150,150);
        userImageParam.setMarginStart(50);
        userImageParam.setMargins(0, 50, 0, 0);
        userImageView.setLayoutParams(userImageParam);

        // text username
        TextView txtUserName = new TextView(this);
        LinearLayout.LayoutParams userNameParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        userNameParam.setMarginStart(35);
        userNameParam.setMargins(0, 80, 0, 0);
        txtUserName.setLayoutParams(userNameParam);
        txtUserName.setTextSize(17);
        txtUserName.setText(userName);
        txtUserName.setTextColor(Color.WHITE);
        txtUserName.setTypeface(txtUserName.getTypeface(), Typeface.BOLD);

        layoutUserData.addView(userImageView);
        layoutUserData.addView(txtUserName);

        //Text Descrpiption
        TextView txtDescription = new TextView(this);
        LinearLayout.LayoutParams txtDescriptionParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, screenHeight/9);
        txtDescriptionParams.setMarginStart(50);
        txtDescriptionParams.setMargins(0, 20, 0, 0);
        txtDescription.setLayoutParams(txtDescriptionParams);
        txtDescription.setTextSize(16);
        txtDescription.setText(desctiption);
        txtDescription.setTextColor(Color.WHITE);


        //        Dashed line
        ImageView dashedLine = new ImageView(this);
        LinearLayout.LayoutParams dashedLineParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 6);
        dashedLineParams.setMarginStart(10);
        dashedLine.setLayoutParams(dashedLineParams);
        dashedLine.setBackground(getResources().getDrawable(R.drawable.dash));
        dashedLine.setBackgroundColor(Color.BLACK);

        LinearLayout layoutBottom = new LinearLayout(this);
        layoutBottom.setOrientation(LinearLayout.HORIZONTAL);

        // text DATE and TIME
        TextView txtDate = new TextView(this);
        LinearLayout.LayoutParams dateParam = new LinearLayout.LayoutParams(screenWidth/4, LinearLayout.LayoutParams.WRAP_CONTENT);
        dateParam.setMarginStart(40);
        dateParam.setMargins(15, 15, 0, 15);
        txtDate.setLayoutParams(dateParam);
        txtDate.setTextSize(12);
        txtDate.setText(date + ", " + time);
        txtDate.setTextColor(Color.WHITE);

        //comment image
        ImageView commentView = new ImageView(this);
        commentView.setImageResource(R.drawable.comment);
        LinearLayout.LayoutParams commentParam = new LinearLayout.LayoutParams(60,60);
        commentParam.setMarginStart(80);
        commentParam.setMargins(0, 15, 0, 20);
        commentView.setLayoutParams(commentParam);

        // text total Comment
        TextView txtCommentNum = new TextView(this);
        LinearLayout.LayoutParams commentNumParam = new LinearLayout.LayoutParams(40, LinearLayout.LayoutParams.WRAP_CONTENT);
        commentNumParam.setMarginEnd(30);
        commentNumParam.setMargins(0, 15, 0, 15);
        txtCommentNum.setLayoutParams(commentNumParam);
        txtCommentNum.setTextSize(11);
        txtCommentNum.setText("[" + totalComment + "]");
        txtCommentNum.setTextColor(Color.WHITE);

        layoutBottom.addView(txtDate);
        layoutBottom.addView(commentView);
        layoutBottom.addView(txtCommentNum);

        darker.addView(layoutUserData);
        darker.addView(txtDescription);
        darker.addView(dashedLine);
        darker.addView(layoutBottom);

        layoutImage.addView(darker);
        toReturn.addView(layoutImage);
        return toReturn;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //            getMenuInflater().inflate(R.menu.menu_main, menu);
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
}