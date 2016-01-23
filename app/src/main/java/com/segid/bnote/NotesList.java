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
import android.util.Log;
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
import android.widget.Toast;

import com.kbeanie.imagechooser.api.ChooserType;
import com.kbeanie.imagechooser.api.ChosenImage;
import com.kbeanie.imagechooser.api.ImageChooserListener;
import com.kbeanie.imagechooser.api.ImageChooserManager;

import java.util.ArrayList;

public class NotesList extends AppCompatActivity implements ImageChooserListener {

    private TextView toolbarTitle;
    private ImageView imageTaken;
    private Button btnCamera;
    private Button btnBack;
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

    private ArrayList<Integer> listNotes = new ArrayList<>();
    private ArrayList<Integer> listUsersImage = new ArrayList<>();
    private ArrayList<String> listUsername = new ArrayList<>();
    private ArrayList<String> listDescription= new ArrayList<>();
    private String intentUserName;
    private int intentNoteImage;
    private int data_counter;
    private int noteImageInt;

    private ImageChooserManager imageChooserManager;
    private int chooserType;

    String filePath;

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

        imageTaken = (ImageView) findViewById(R.id.photoimage);
        imageTaken.setVisibility(View.INVISIBLE);

        btnNotes = (Button) findViewById(R.id.btn_notes);
        btnNotes.setVisibility(View.INVISIBLE);

        btnImage = (Button) findViewById(R.id.btn_image);
        btnImage.setVisibility(View.INVISIBLE);

        btnPlus = (Button) findViewById(R.id.btn_plus);
        btnPlus.setVisibility(View.VISIBLE);

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

        btnCamera.setOnClickListener(new btnTakePhotoClicker());

        btnNotes.setOnClickListener(new btnAddNote());

        btnImage.setOnClickListener(new btnGallery());


        for(int counter = 0; counter < listUsername.size(); counter++)
        {
            final int COUNTER = counter;
            linearLayouts.get(counter).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(NotesList.this, OpenNote.class);
                    Bundle b = new Bundle();
                    b.putString("username", listUsername.get(COUNTER));
                    b.putInt("userImage", listUsersImage.get(COUNTER));
                    b.putInt("noteImage", listNotes.get(COUNTER));
                    intent.putExtras(b); //Put your id to your next Intent
                    startActivity(intent);
                }
            });
        }

//        for (int i=0; i< linearLayouts.size(); i++) {
//            linearLayouts.get(i).setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    Intent mIntent = new Intent(this, OpenNote.class);
//                    Bundle mBundle = new Bundle();
//                    mBundle.putString("username", listUsername.get(i));
//                    mIntent.putExtras(mBundle);
//                }
//            });
//        }
    }

    class btnTakePhotoClicker implements Button.OnClickListener
    {
        @Override
        public void onClick (View v)
        {
            takePicture();
        }
    }

    class btnAddNote implements Button.OnClickListener
    {
        @Override
        public void onClick (View v)
        {
            Intent addNoteIntent = new Intent(NotesList.this, AddNote.class);
            startActivity(addNoteIntent);
        }
    }

    class btnGallery implements Button.OnClickListener
    {
        @Override
        public void onClick (View v)
        {
            chooseImage();
        }
    }

    public void populateLinearLayout() {
        TableLayout table = (TableLayout) findViewById(R.id.tableThumbnail);

        data_counter=0;

        Intent intentExtras = getIntent();
        Bundle bundleExtras = intentExtras.getExtras();
        int bundleCourse = bundleExtras.getInt("folderid");

        if(bundleCourse == 1)
        {
            listUsername.add("Teylor Suwift");
            listUsername.add("Hello Tester");

            listUsersImage.add(R.drawable.user);
            listUsersImage.add(R.drawable.user1);

            listNotes.add(R.drawable.note1);
            listNotes.add(R.drawable.note2);
        }
        else
        {
            listUsername.add("Teylor Suwift");
            listUsername.add("Hello Tester");
            listUsername.add("Santa Claus");

            listUsersImage.add(R.drawable.user);
            listUsersImage.add(R.drawable.user1);
            listUsersImage.add(R.drawable.user2);

            listNotes.add(R.drawable.note1);
            listNotes.add(R.drawable.note2);
            listNotes.add(R.drawable.note3);
        }
        Log.i("test: ", String.valueOf(listUsername.size()));
        //for (int i=0; i<(int)Math.ceil(listUsername.size()/2); i++)
        for (int i=0; i<2; i++) {
            TableRow tableRow = new TableRow(this);
            table.addView(tableRow);

            for (int j=0; j<2; j++) {
                if(data_counter<listUsername.size()) {
                    LinearLayout ll = getFolder(R.drawable.rounded_rectangle, listNotes.get(data_counter), listUsersImage.get(data_counter), 3, listUsername.get(data_counter), "23/11/2015", "Sequential Art -  Comic Making Philosophy..", "8:39 AM");
                    TableRow.LayoutParams tblRowParam = new TableRow.LayoutParams(screenWidth, screenHeight / 4, 1.0f);
                    if (j == 0) {
                        tblRowParam.setMarginEnd(40);
                    }
                    tblRowParam.setMargins(0, 40, 0, 0);
                    ll.setLayoutParams(tblRowParam);
                    linearLayouts.add(ll);

                    linearlayoutID++;
                    tableRow.addView(ll);
                    data_counter++;
                }
            }
        }
    }

//        TableLayout table = (TableLayout) findViewById(R.id.tableThumbnail);
//        int num_rows = 3;
//        final int num_columns = 2;
//        int row_counter = 0;
//        data_counter =0;
//
//        listNotes.add(R.drawable.note1);
//        listNotes.add(R.drawable.note2);
//        listNotes.add(R.drawable.note3);
//        TableRow tableRow = new TableRow(this);
//
//
//        for(data_counter = 0; data_counter<listNotes.size(); data_counter++) {
//            noteImageInt= listNotes.get(data_counter);
//
//            LinearLayout.LayoutParams llParam = new LinearLayout.LayoutParams((int)(screenWidth*0.437), screenHeight/4);
//            LinearLayout ll = getFolder(R.drawable.rounded_rectangle, noteImageInt, R.drawable.bnotes07, 3, "Teylor Suwift", "23/11/2015", "Sequential Art -  Comic Making Philosophy..", "8:39 AM");
//            ll.setLayoutParams(llParam);
//
//            TableRow.LayoutParams tblRowParam = new TableRow.LayoutParams(screenWidth, screenHeight / 4, 1.0f);
//            if (row_counter == 0) {
//                tblRowParam.setMarginEnd(40);
//            }
//            tblRowParam.setMargins(0, 40, 0, 0);
//            ll.setLayoutParams(tblRowParam);
//
//            linearLayouts.add(ll);
//            intentNoteImage = data_counter;
//            linearLayouts.get(intentNoteImage).setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    Intent intent = new Intent(getApplicationContext(), OpenNote.class);
//                    Bundle b = new Bundle();
//                    b.putInt("NoteImage", listNotes.get(intentNoteImage));
//                    b.putString("Username", "sjdjs");
//                    intent.putExtras(b);
//                    startActivity(intent);
//                }
//            });
//
//            linearlayoutID++;
//
//            if(row_counter==1) {
//                tableRow.addView(ll);
//                row_counter=0;
//            } else {
//                tableRow = new TableRow(this);
//                table.addView(tableRow);
//                tableRow.addView(ll);
//                row_counter++;
//            }
//        }




//        TableLayout table = (TableLayout) findViewById(R.id.tableThumbnail);
//        int num_rows = 3;
//        int num_columns = 2;
//
//        for (int i=0; i<3; i++) {
//            TableRow tableRow = new TableRow(this);
//            table.addView(tableRow);
//
//            for (int j=0; j<2; j++) {
//                LinearLayout ll = getFolder(R.drawable.rounded_rectangle, R.drawable.notes, R.drawable.bnotes07, 3, "Teylor Suwift", "23/11/2015", "Sequential Art -  Comic Making Philosophy..", "8:39 AM");
//                TableRow.LayoutParams tblRowParam = new TableRow.LayoutParams(screenWidth,screenHeight/4, 1.0f);
//                if (j==0) {
//                    tblRowParam.setMarginEnd(40);
//                }
//                tblRowParam.setMargins(0, 40, 0, 0);
//                ll.setLayoutParams(tblRowParam);
//                linearLayouts.add(ll);
//                linearlayoutID++;
//                tableRow.addView(ll);
//            }
//        }


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
        paint.setColor(getResources().getColor(R.color.bnote_transparent));
        canvas.drawRoundRect(new RectF(10, 10, 500, 500), 70, 70, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(sbmp, rect, rect, paint);


        return output;
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

    public LinearLayout getFolder(int backgroundDrawable, int notesImage, int userImage, int totalComment, String userName, String date, String desctiption, String time) {
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams((int)(screenWidth*0.437), screenHeight/4);
        LinearLayout toReturn = new LinearLayout(this);
        toReturn.setOrientation(LinearLayout.VERTICAL);
        toReturn.setClickable(true);
        toReturn.setLayoutParams(param);

        Bitmap noteImageBitmap = BitmapFactory.decodeResource(getResources(), notesImage);
        Bitmap rounded = getCroppedBitmap(noteImageBitmap, 500);
        Drawable drawable=new BitmapDrawable(rounded);
        LinearLayout layoutImage = new LinearLayout(this);
        layoutImage.setBackground(drawable);
        layoutImage.setLayoutParams(new LinearLayout.LayoutParams((int) (screenWidth * 0.437), screenHeight / 4));

        Bitmap btDarker = BitmapFactory.decodeResource(getResources(), R.drawable.darker);
        Bitmap roundedDarker = getCroppedBitmap(btDarker, 500);
        Drawable drawableDarker =new BitmapDrawable(roundedDarker);
        LinearLayout darker = new LinearLayout(this);
        darker.setOrientation(LinearLayout.VERTICAL);
        darker.setBackground(drawableDarker);

        //layout for user image and user name
        LinearLayout layoutUserData = new LinearLayout(this);

        //user image
        Bitmap userImageBitmap = BitmapFactory.decodeResource(getResources(), userImage);
        Bitmap userImageRounded = getCircleBitmap(userImageBitmap, 70);
        Drawable userImageDrawable=new BitmapDrawable(userImageRounded);
        LinearLayout.LayoutParams userImageParam = new LinearLayout.LayoutParams((int)(screenWidth*0.10474),(int)(screenHeight*0.0579));
        userImageParam.setMarginStart((int) (screenWidth * 0.0295));
        userImageParam.setMargins(0, (int) (screenHeight * 0.02278), 0, (int) (screenHeight * 0.00589));
//        LinearLayout.LayoutParams userImageParams = new LinearLayout.LayoutParams((int)(screenWidth*0.107), (int)(screenHeight*0.06));
        Button btnUserImage = new Button(this);
        btnUserImage.setLayoutParams(userImageParam);
        btnUserImage.setBackground(userImageDrawable);

        // text username
        TextView txtUserName = new TextView(this);
        LinearLayout.LayoutParams userNameParam = new LinearLayout.LayoutParams((int)(screenWidth*0.31065), (int)(screenHeight*0.0579));
        userNameParam.setMarginStart((int) (screenWidth * 0.02059));
        userNameParam.setMargins(0, (int) (screenHeight * 0.0246), 0, 0);
        txtUserName.setLayoutParams(userNameParam);
        txtUserName.setTextSize(15);
        txtUserName.setText(userName);
        txtUserName.setTextColor(Color.WHITE);
        txtUserName.setTypeface(txtUserName.getTypeface(), Typeface.BOLD);

//        layoutUserData.addView(userImageView);
        layoutUserData.addView(btnUserImage);
        layoutUserData.addView(txtUserName);

        //Text Descrpiption
        TextView txtDescription = new TextView(this);
        LinearLayout.LayoutParams txtDescriptionParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, (int)(screenHeight*0.117));
        txtDescriptionParams.setMarginStart((int) (screenWidth * 0.03312));
        txtDescription.setLayoutParams(txtDescriptionParams);
        txtDescription.setTextSize(12);
        txtDescription.setText(desctiption);
        txtDescription.setTextColor(Color.WHITE);


        // Dashed line
        Button dashedLine = new Button(this);
        LinearLayout.LayoutParams dashedLineParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 6);
        dashedLineParams.setMarginStart(10);
        dashedLine.setLayoutParams(dashedLineParams);
        dashedLine.setBackgroundResource(R.drawable.dashed);

        LinearLayout layoutBottom = new LinearLayout(this);
        layoutBottom.setOrientation(LinearLayout.HORIZONTAL);

        // text DATE and TIME
        TextView txtDate = new TextView(this);
        LinearLayout.LayoutParams dateParam = new LinearLayout.LayoutParams(screenWidth/4, LinearLayout.LayoutParams.WRAP_CONTENT);
        dateParam.setMarginStart((int)(screenWidth*0.0398));
        dateParam.setMargins(0, 15, 0, 15);
        txtDate.setLayoutParams(dateParam);
        txtDate.setTextSize(9);
        txtDate.setText(date + ", " + time);
        txtDate.setTextColor(Color.WHITE);

        //comment image
        ImageView commentView = new ImageView(this);
        commentView.setImageResource(R.drawable.comment);
        LinearLayout.LayoutParams commentParam = new LinearLayout.LayoutParams(60,60);
        commentParam.setMarginStart(40);
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

    /***********************  Attachment Module  *********************/

    private void chooseImage() {
        chooserType = ChooserType.REQUEST_PICK_PICTURE;
        imageChooserManager = new ImageChooserManager(this,
                ChooserType.REQUEST_PICK_PICTURE, true);
        imageChooserManager.setImageChooserListener(this);
        imageChooserManager.clearOldFiles();
        try {
            filePath = imageChooserManager.choose();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void takePicture() {
        chooserType = ChooserType.REQUEST_CAPTURE_PICTURE;
        imageChooserManager = new ImageChooserManager(this,
                ChooserType.REQUEST_CAPTURE_PICTURE, true);
        imageChooserManager.setImageChooserListener(this);
        try {
            filePath = imageChooserManager.choose();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onImageChosen(final ChosenImage image) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                if (image != null) {
                    Log.i("NotesList", "Chosen Image: O - " + image.getFilePathOriginal());
                    Intent i = new Intent(NotesList.this, ImagePickerActivity.class);
                    i.putExtra("imagePath", image.getFilePathOriginal());
                    startActivityForResult(i, 8221);
                } else {
                    Log.i("NotesList", "Chosen Image: Is null");
                }
            }
        });
    }

    @Override
    public void onError(final String reason) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Log.i("NotesList", "OnError: " + reason);
                Toast.makeText(NotesList.this, reason,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void reinitializeImageChooser() {
        imageChooserManager = new ImageChooserManager(this, chooserType, true);
        imageChooserManager.setImageChooserListener(this);
        imageChooserManager.reinitialize(filePath);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK
                && (requestCode == ChooserType.REQUEST_PICK_PICTURE || requestCode == ChooserType.REQUEST_CAPTURE_PICTURE)) {
            if (imageChooserManager == null) {
                reinitializeImageChooser();
            }
            imageChooserManager.submit(requestCode, data);
            Log.i("NotesList", "OnActivityResult");
            Log.i("NotesList", "File Path : " + filePath);
            Log.i("NotesList", "Chooser Type: " + chooserType);
        }else if(resultCode == RESULT_OK && (requestCode == 8221)){
            filePath = data.getStringExtra("imagePath");
            Log.d("elsa returned", filePath);
        }
    }
}