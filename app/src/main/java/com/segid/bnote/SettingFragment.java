package com.segid.bnote;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SettingFragment extends Fragment {

    private Button btnAccountInfo;
    private Button btnCamera;
    private Button btnNotebooks;
    private Button btnNotes;
    private Button btnWorkChat;

    private LinearLayout settingLayout;

    private Display display;

    private int screenWidth;
    private int screenHeight;

    private Point size;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        size = new Point();
        display = getActivity().getWindowManager().getDefaultDisplay();
        display.getSize(size);
        screenHeight = size.y;
        screenWidth = size.x;


        settingLayout = (LinearLayout) view.findViewById(R.id.settingLayout);

        LinearLayout.LayoutParams titleParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (screenHeight / 10));

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "FUTURA.ttf");

        btnAccountInfo = new Button(getActivity());
        btnAccountInfo.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_account_info_setting, 0, 0, 0);
        btnAccountInfo.setText("       Account Info");
        btnAccountInfo.setTextSize(15);
        btnAccountInfo.setBackgroundColor(getResources().getColor(R.color.bnote_transparent_background));
        btnAccountInfo.setGravity(Gravity.LEFT);
        btnAccountInfo.setGravity(Gravity.CENTER_VERTICAL);
        btnAccountInfo.setTypeface(font);

        btnCamera = new Button(getActivity());
        btnCamera.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_camera_setting, 0, 0, 0);
        btnCamera.setText("       Camera");
        btnCamera.setTextSize(15);
        btnCamera.setBackgroundColor(getResources().getColor(R.color.bnote_transparent_background));
        btnCamera.setGravity(Gravity.LEFT);
        btnCamera.setGravity(Gravity.CENTER_VERTICAL);
        btnCamera.setTypeface(font);
//
        btnNotebooks = new Button(getActivity());
        btnNotebooks.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_note_setting, 0, 0, 0);
        btnNotebooks.setText("      Notebooks");
        btnNotebooks.setTextSize(15);
        btnNotebooks.setBackgroundColor(getResources().getColor(R.color.bnote_transparent_background));
        btnNotebooks.setGravity(Gravity.LEFT);
        btnNotebooks.setGravity(Gravity.CENTER_VERTICAL);
        btnNotebooks.setTypeface(font);

        btnNotes = new Button(getActivity());
        btnNotes.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_notebook_setting, 0, 0, 0);
        btnNotes.setText("        Notes");
        btnNotes.setTextSize(15);
        btnNotes.setBackgroundColor(getResources().getColor(R.color.bnote_transparent_background));
        btnNotes.setGravity(Gravity.LEFT);
        btnNotes.setGravity(Gravity.CENTER_VERTICAL);
        btnNotes.setTypeface(font);

        btnWorkChat = new Button(getActivity());
        btnWorkChat.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_work_chat_setting, 0, 0, 0);
        btnWorkChat.setText("     Work Chat");
        btnWorkChat.setTextSize(15);
        btnWorkChat.setBackgroundColor(getResources().getColor(R.color.bnote_transparent_background));
        btnWorkChat.setGravity(Gravity.LEFT);
        btnWorkChat.setGravity(Gravity.CENTER_VERTICAL);
        btnWorkChat.setTypeface(font);

        settingLayout.addView(btnAccountInfo);
        settingLayout.addView(getLine());
        settingLayout.addView(btnCamera);
        settingLayout.addView(getLine());
        settingLayout.addView(btnNotebooks);
        settingLayout.addView(getLine());
        settingLayout.addView(btnNotes);
        settingLayout.addView(getLine());
        settingLayout.addView(btnWorkChat);
        settingLayout.addView(getLine());

        return view;

    }

    public View getLine() {
        View line = new View(getActivity());
        LinearLayout.LayoutParams separatorLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 2);
        line.setBackgroundColor(Color.GRAY);
        line.setLayoutParams(separatorLayoutParams);

        return line;
    }
}