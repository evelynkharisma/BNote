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
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.nio.BufferUnderflowException;

public class OpenNote extends AppCompatActivity {

    private TextView toolbarTitle;
    private Button btnBack;
    private Button btnNoteImage;
    private Button btnUserImage;
    private Button btnPurple;
    private Button btnTosca;
    private Button btnPink;
    private Button btnDarkBlue;
    private Button btnYellow;
    private Button btnThreePurple;

    private Display display;

    private int screenWidth;
    private int screenHeight;

    private LinearLayout.LayoutParams btnCircleParams;
    private LinearLayout basicLayout;
    private LinearLayout topLayout;

    private Point size;

    private ScrollView scrollLayout;

    private TextView txtDescription;
    private TextView txtUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Bundle b = getIntent().getExtras();
        String userName= b.getString("username");
        int note = b.getInt("noteImage");
        int userImage = b.getInt("userImage");
        initialize();
        createUI(userImage, note, userName);
    }

    public void createUI(int userimage, int noteimage, String username) {
        setCroppedImageButton(btnUserImage, userimage);
        setImageButton(btnNoteImage, noteimage);
        setText(16, txtUserName, username);
        setText(16, txtDescription, "Sequential Art - Comic Making Philosophy");
        topLayout.addView(btnUserImage);
        topLayout.addView(txtUserName);
        topLayout.addView(btnPurple);
        topLayout.addView(btnTosca);
        topLayout.addView(btnPink);
        topLayout.addView(btnDarkBlue);
        topLayout.addView(btnYellow);
        topLayout.addView(btnThreePurple);
        basicLayout.addView(topLayout);
        basicLayout.addView(txtDescription);
        scrollLayout.addView(basicLayout);



        LinearLayout basicLayout = (LinearLayout) findViewById(R.id.basicLinearLayout);
        basicLayout.addView(btnNoteImage);
        basicLayout.addView(scrollLayout);
    }

    public void initialize() {
        size = new Point();

        display = getWindowManager().getDefaultDisplay();
        display.getSize(size);

        screenHeight = size.y;
        screenWidth = size.x;

        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbarTitle.setText("NOTE");
        toolbarTitle.setTextColor(getResources().getColor(R.color.bnote_white));

        btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

        LinearLayout.LayoutParams btnNoteImageParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int)(screenHeight*0.73));
        btnNoteImage = new Button(this);
        btnNoteImage.setLayoutParams(btnNoteImageParams);

        LinearLayout.LayoutParams scrollParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int)(screenHeight*0.182));
        scrollParam.setMarginEnd((int) (screenWidth * 0.034));
        scrollParam.setMargins(0, (int) (screenHeight * 0.0135), 0, (int) (screenHeight * 0.0135));
        scrollParam.setMarginStart((int) (screenWidth * 0.034));
        scrollLayout = new ScrollView(this);
        scrollLayout.setLayoutParams(scrollParam);


        LinearLayout.LayoutParams basicLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        basicLayout = new LinearLayout(this);
        basicLayout.setLayoutParams(basicLayoutParams);
        basicLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams topLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int)(screenHeight*0.063));
        topLayout = new LinearLayout(this);
        topLayout.setLayoutParams(topLayoutParams);
        topLayout.setOrientation(LinearLayout.HORIZONTAL);


        LinearLayout.LayoutParams userImageParams = new LinearLayout.LayoutParams((int)(screenWidth*0.107), (int)(screenHeight*0.06));
        btnUserImage = new Button(this);
        btnUserImage.setLayoutParams(userImageParams);

        LinearLayout.LayoutParams txtUserNameParams = new LinearLayout.LayoutParams((int)(screenWidth*0.369), (int)(screenHeight*0.0368));
        txtUserNameParams.setMarginStart(15);
        txtUserName = new TextView(this);
        txtUserName.setLayoutParams(txtUserNameParams);

        btnCircleParams = new LinearLayout.LayoutParams((int)(screenWidth*0.0639), (int)(screenHeight*0.0353));
        btnCircleParams.setMargins(0, (int) (screenHeight * 0.0147), 0, (int) (screenHeight * 0.0147));
        btnCircleParams.setMarginStart((int) (screenWidth * 0.005));
        btnCircleParams.setMarginEnd((int) (screenWidth * 0.005));

        btnPurple = new Button(this);
        setParamsCircle(btnPurple, btnCircleParams, R.drawable.circle_purple);

        btnTosca = new Button(this);
        setParamsCircle(btnTosca, btnCircleParams, R.drawable.circle_tosca);

        btnPink = new Button(this);
        setParamsCircle(btnPink, btnCircleParams, R.drawable.circle_pink);

        btnDarkBlue = new Button(this);
        setParamsCircle(btnDarkBlue, btnCircleParams, R.drawable.circle_dark_blue);

        btnYellow = new Button(this);
        setParamsCircle(btnYellow, btnCircleParams, R.drawable.circle_yellow);

        LinearLayout.LayoutParams btnCirclesParams = new LinearLayout.LayoutParams((int)(screenWidth*0.0671), (int)(screenHeight*0.0239));
        btnCirclesParams.setMargins(0, (int) (screenHeight * 0.023), 0, (int) (screenHeight * 0.023));
        btnCirclesParams.setMarginStart((int) (screenWidth * 0.005));
        btnCirclesParams.setMarginEnd((int) (screenWidth * 0.005));
        btnThreePurple = new Button(this);
        setParamsCircle(btnThreePurple, btnCirclesParams, R.drawable.circle_purples);

        LinearLayout.LayoutParams txtDescriptionParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        txtDescriptionParams.setMargins(0,0,0,(int)(screenHeight*0.02));
        txtDescriptionParams.setMarginStart(15);
        txtDescription = new TextView(this);
        txtDescription.setLayoutParams(txtDescriptionParams);
        txtDescription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(OpenNote.this, Comment.class);
                startActivity(intent);
            }
        });
    }


    public Bitmap getCroppedBitmap(Bitmap bmp, int radius) {
        Bitmap sbmp;
        if(bmp.getWidth() != radius || bmp.getHeight() != radius) {
            sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
        } else {
            sbmp = bmp;
        }
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
        canvas.drawCircle(sbmp.getWidth() / 2+0.7f, sbmp.getHeight() / 2+0.7f,sbmp.getWidth()/2+0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);

        return output;
    }

    public void setCroppedImageButton(Button object, int notePict) {
        Bitmap noteImageBitmap = BitmapFactory.decodeResource(getResources(), notePict);
        Bitmap rounded = getCroppedBitmap(noteImageBitmap, 70);
        Drawable drawable=new BitmapDrawable(rounded);
        object.setBackground(drawable);
    }

    public void setImageButton(Button object, int notePict) {
        object.setBackgroundResource(notePict);
    }

    public void setParamsCircle(Button button, LinearLayout.LayoutParams layoutParams, int image) {
        button.setLayoutParams(layoutParams);
        button.setBackgroundResource(image);
    }

    public void setText(int size, TextView txt, String words) {
        txt.setText(words);
        txt.setTextSize(size);
        txt.setTypeface(Typeface.DEFAULT_BOLD);
    }
}

