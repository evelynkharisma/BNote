package com.segid.bnote;

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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Comment extends AppCompatActivity {
    private TextView toolbarTitle;
    private Button btnBack;

    private Display display;

    private int screenWidth;
    private int screenHeight;

    private LinearLayout linearLayout;

    private Point size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initialize();
        populateComment();
        createUI();
    }

    public void initialize() {
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        size = new Point();
        display = getWindowManager().getDefaultDisplay();
        display.getSize(size);
        screenHeight = size.y;
        screenWidth = size.x;

        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbarTitle.setText("COMMENTS");

        btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void createCommentingLayout(int numComment) {
        LinearLayout layoutCommenting = (LinearLayout) findViewById(R.id.layoutCommenting);

        LinearLayout.LayoutParams txtCommentParams = new LinearLayout.LayoutParams((int)(screenWidth*0.770), ViewGroup.LayoutParams.MATCH_PARENT);
        EditText txtComment = new EditText(this);
        txtComment.setLayoutParams(txtCommentParams);

        LinearLayout.LayoutParams btnCommentParams = new LinearLayout.LayoutParams((int)(screenWidth*0.0678), (int)(screenHeight*0.0389));
        btnCommentParams.setMargins(0, 30, 0, 0);
        Button btnComment = new Button(this);
        btnComment.setBackgroundResource(R.drawable.comment);
        btnComment.setLayoutParams(btnCommentParams);

        LinearLayout.LayoutParams txtNumCommentParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        txtNumCommentParams.setMargins(10, 60, 0, 0);
        TextView txtNumComment = new TextView(this);
        txtNumComment.setText("[" + numComment + "]");
        txtNumComment.setLayoutParams(txtNumCommentParams);
        txtNumComment.setTextSize(16);

        View line = new View(this);
        LinearLayout.LayoutParams separatorLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2);
        line.setBackgroundColor(Color.GRAY);
        line.setLayoutParams(separatorLayoutParams);

        LinearLayout.LayoutParams bottomLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout bottomLayout = new LinearLayout(this);
        bottomLayout.setOrientation(LinearLayout.HORIZONTAL);
        bottomLayout.setLayoutParams(bottomLayoutParams);
        bottomLayout.addView(txtComment);
        bottomLayout.addView(btnComment);
        bottomLayout.addView(txtNumComment);

        layoutCommenting.addView(line);
        layoutCommenting.addView(bottomLayout);
    }

    public void createUI() {
        ScrollView scrollComment = (ScrollView) findViewById(R.id.scrollComment);
        scrollComment.addView(linearLayout);

//        createCommentingLayout(2);
    }

    public void populateComment(){
        int numComment = 2;
        linearLayout.addView(getComment(R.drawable.user, "Teylor Suwift", "26/11/2015", "Sequential Art - Comic Making Philosophy", "1:55 PM", R.drawable.circle_purples));


//        for (int i=0; i< numComment; i++) {
        linearLayout.addView(getComment(R.drawable.user1, "Melly", "27/11/2015", "Visual Art delivers design and conceptual work according to the client requirements revealed in our strategy and analysis work. Nothing is left to chance and no one thing considered in isolation", "1:55 PM"));
        linearLayout.addView(getComment(R.drawable.user2, "Helo Tester", "27/11/2015", "We will employ through investigation and problem definition; exploring relevant solutions and shaping responses according to our pre studies", "5:21 PM"));

    }

    public LinearLayout getComment(int userImage, String username, String date, String description, String time) {
        LinearLayout toReturn = new LinearLayout(this);
        toReturn.setOrientation(LinearLayout.VERTICAL);

        Bitmap userImageBitmap = BitmapFactory.decodeResource(getResources(), userImage);
        Bitmap userImageRounded = getCircleBitmap(userImageBitmap, 70);
        Drawable userImageDrawable=new BitmapDrawable(userImageRounded);
        LinearLayout.LayoutParams userImageParam = new LinearLayout.LayoutParams((int)(screenWidth*0.1055),(int)(screenHeight*0.05846));
        userImageParam.setMarginStart((int) (screenWidth * 0.01065));
        userImageParam.setMargins(0, (int) (screenHeight * 0.02256), 0, (int) (screenHeight * 0.0153));
        Button btnUserImage = new Button(this);
        btnUserImage.setLayoutParams(userImageParam);
        btnUserImage.setBackground(userImageDrawable);

        TextView txtUserName = new TextView(this);
        setText(17, txtUserName, Typeface.DEFAULT_BOLD, username, Color.BLACK);

        TextView txtDate = new TextView(this);
        setText(12, txtDate, Typeface.DEFAULT, date + " " + time, Color.GRAY);

        LinearLayout.LayoutParams verticalLayoutParams = new LinearLayout.LayoutParams((int)(screenWidth*0.846), ViewGroup.LayoutParams.WRAP_CONTENT);
        verticalLayoutParams.setMargins(0, (int) (screenHeight * 0.0302), 0, 0);
        verticalLayoutParams.setMarginStart((int) (screenWidth * 0.02));
        LinearLayout verticalLayout = new LinearLayout(this);
        verticalLayout.setLayoutParams(verticalLayoutParams);
        verticalLayout.setOrientation(LinearLayout.VERTICAL);
        verticalLayout.addView(txtUserName);
        verticalLayout.addView(txtDate);


        LinearLayout.LayoutParams topLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout topLayout = new LinearLayout(this);
        topLayout.setLayoutParams(topLayoutParams);
        topLayout.setOrientation(LinearLayout.HORIZONTAL);
        topLayout.addView(btnUserImage);
        topLayout.addView(verticalLayout);


        LinearLayout.LayoutParams txtDescriptionParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView txtDescription = new TextView(this);
        txtDescription.setLayoutParams(txtDescriptionParam);
        setText(15, txtDescription, Typeface.DEFAULT, description, Color.BLACK);


        View line = new View(this);
        LinearLayout.LayoutParams separatorLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2);
        separatorLayoutParams.setMargins(0, 25, 0, 0);
        line.setBackgroundColor(Color.GRAY);
        line.setLayoutParams(separatorLayoutParams);

        toReturn.addView(topLayout);
        toReturn.addView(txtDescription);
        toReturn.addView(line);
        return toReturn;
    }

    public LinearLayout getComment(int userImage, String username, String date, String description, String time, int circleColor) {
        LinearLayout toReturn = new LinearLayout(this);
        toReturn.setOrientation(LinearLayout.VERTICAL);

        Bitmap userImageBitmap = BitmapFactory.decodeResource(getResources(), userImage);
        Bitmap userImageRounded = getCircleBitmap(userImageBitmap, 70);
        Drawable userImageDrawable=new BitmapDrawable(userImageRounded);
        LinearLayout.LayoutParams userImageParam = new LinearLayout.LayoutParams((int)(screenWidth*0.1055),(int)(screenHeight*0.05846));
        userImageParam.setMarginStart((int) (screenWidth * 0.01065));
        userImageParam.setMargins(0, (int) (screenHeight * 0.02256), 0, (int) (screenHeight * 0.0153));
        Button btnUserImage = new Button(this);
        btnUserImage.setLayoutParams(userImageParam);
        btnUserImage.setBackground(userImageDrawable);

        TextView txtUserName = new TextView(this);
        setText(17, txtUserName, Typeface.DEFAULT_BOLD, username, Color.BLACK);

        TextView txtDate = new TextView(this);
        setText(12, txtDate, Typeface.DEFAULT, date + " " + time, Color.GRAY);

        LinearLayout.LayoutParams verticalLayoutParams = new LinearLayout.LayoutParams((int)(screenWidth*0.846), ViewGroup.LayoutParams.WRAP_CONTENT);
        verticalLayoutParams.setMargins(0, (int) (screenHeight * 0.0302), 0, 0);
        verticalLayoutParams.setMarginStart((int) (screenWidth * 0.02));
        LinearLayout verticalLayout = new LinearLayout(this);
        verticalLayout.setLayoutParams(verticalLayoutParams);
        verticalLayout.setOrientation(LinearLayout.VERTICAL);
        verticalLayout.addView(txtUserName);
        verticalLayout.addView(txtDate);


        LinearLayout.LayoutParams btnCirclesParams = new LinearLayout.LayoutParams((int)(screenWidth*0.075), (int)(screenHeight*0.02259));
        btnCirclesParams.setMargins(0, (int) (screenHeight * 0.023), 0, (int) (screenHeight * 0.023));
        Button btnCircles = new Button(this);
        btnCircles.setLayoutParams(btnCirclesParams);
        btnCircles.setBackgroundResource(circleColor);

        LinearLayout.LayoutParams topLayoutParams = new LinearLayout.LayoutParams((int)(screenWidth*0.71547), ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout topLayout = new LinearLayout(this);
        topLayout.setLayoutParams(topLayoutParams);
        topLayout.setOrientation(LinearLayout.HORIZONTAL);
        topLayout.addView(btnUserImage);
//        topLayout.addView(btnCircles);
        topLayout.addView(verticalLayout);
        topLayout.addView(btnCircles);


        LinearLayout.LayoutParams txtDescriptionParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView txtDescription = new TextView(this);
        txtDescription.setLayoutParams(txtDescriptionParam);
        setText(15, txtDescription, Typeface.DEFAULT_BOLD, description, Color.BLACK);


        View line = new View(this);
        LinearLayout.LayoutParams separatorLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2);
        separatorLayoutParams.setMargins(0, 25, 0, 0);
        line.setBackgroundColor(Color.GRAY);
        line.setLayoutParams(separatorLayoutParams);


        toReturn.addView(topLayout);
        toReturn.addView(txtDescription);
        toReturn.addView(line);
        return toReturn;
    }

    public Bitmap getCircleBitmap(Bitmap bmp, int radius) {
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
        canvas.drawCircle(sbmp.getWidth() / 2 + 0.7f, sbmp.getHeight() / 2 + 0.7f, sbmp.getWidth() / 2 + 0f, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);

        return output;
    }

    public void setText(int size, TextView txt, Typeface style, String words, int color) {
        txt.setText(words);
        txt.setTextSize(size);
        txt.setTypeface(style);
        txt.setTextColor(color);
    }

}
