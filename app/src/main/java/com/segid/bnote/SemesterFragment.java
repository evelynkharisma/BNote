package com.segid.bnote;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


public class SemesterFragment extends Fragment {

    public SemesterFragment(){}

    private ArrayList<String> courses = new ArrayList<String>();
    private static final int NUM_COLS = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_semester, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.folderButtonTable);

        Bundle bundle = this.getArguments();
        int semester = bundle.getInt("semester");

        if(semester == 1){
            courses.add("Artificial Intelligent");
            courses.add("Multimedia Signal Processing");
            courses.add("Operating System");
            courses.add("Project Hatchery");
            courses.add("Software Engineering");
            courses.add("Parsing and Translation");
        }
        else if(semester == 2)
        {
            courses.add("Digital Animation");
            courses.add("Graphic Design");
            courses.add("History of Graphic Design");
            courses.add("Pre-press and Printing");
            courses.add("Screen Design Development");
            courses.add("Typography");
        }
        else if(semester == 3)
        {
            courses.add("Audio Visual");
            courses.add("Computer Network");
            courses.add("Graphic Interactive Design");
            courses.add("Multimedia");
            courses.add("Object Oriented Programming");
            courses.add("Programming Principle");
        }
        else
        {

        }

        TextView textView = (TextView) view.findViewById(R.id.semester_layout);
        textView.setText("Semester "+semester);
        if(courses.size() != 0)
        {
            for (int row=0; row < courses.size(); row++) {
                TableRow tableRow = new TableRow(getActivity());
                tableRow.setLayoutParams(new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT, 100
                ));
                table.addView(tableRow);
                for(int column=0; column < NUM_COLS; column++) {
                    Button folderButton = new Button(getActivity());
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icons30, 0, 0, 0);
                    folderButton.setText("      " + courses.get(row));
                    folderButton.setBackgroundColor(getResources().getColor(R.color.bnote_transparent_background));
                    folderButton.setGravity(Gravity.LEFT);
                    folderButton.setGravity(Gravity.CENTER_VERTICAL);

                    folderButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), NotesList.class);
                            startActivity(intent);
                        }
                    });

                    tableRow.addView(folderButton);
                }
                View line = new View(getActivity());
                TableRow.LayoutParams separatorLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2);
                separatorLayoutParams.setMargins(100, 0, 0, 0);
                line.setBackgroundColor(Color.GRAY);
                table.addView(line, separatorLayoutParams);

                Space rowSpace = new Space(getActivity());
                rowSpace.setMinimumHeight(20);
                table.addView(rowSpace);
            }
        }
        else
        {

        }


        return view;
    }
}
