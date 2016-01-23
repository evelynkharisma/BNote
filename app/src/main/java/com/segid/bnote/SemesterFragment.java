package com.segid.bnote;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.segid.bnote.Object.Course;

import java.util.ArrayList;


public class SemesterFragment extends Fragment {

    public SemesterFragment(){}

    private ArrayList<String> courses = new ArrayList<String>();
    private static final int NUM_COLS = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_semester, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.folderButtonTable);

        final Bundle bundle = this.getArguments();
        int semester = bundle.getInt("semester");
        String userid = bundle.getString("userid");

//        for (User usr : Global.listUsers) {
//            if (usr.getUsername().equals(userid)) {
//
//            }
//        }

        for (Course course : Global.user.getCourses()) {
            if (course.getSemester() == semester) {
                courses.add(course.getCourseName());
            }
        }



//        if(userid.equals("userid"))
//        {
//            if(semester == 1){
//                courses.add("Artificial Intelligence");
//                courses.add("Multimedia Signal Processing");
//                courses.add("Operating System");
//                courses.add("Project Hatchery");
//                courses.add("Software Engineering");
//                courses.add("Parsing and Translation");
//            }
//            else if(semester == 2)
//            {
//                courses.add("Character Building");
//                courses.add("Computer Graphic");
//                courses.add("Enterprise Application");
//                courses.add("Ethical Hacking");
//                courses.add("Scripting Language");
//                courses.add("WebProgramming");
//            }
//            else if(semester == 3)
//            {
//                courses.add("Computer Network");
//                courses.add("Distributed System");
//                courses.add("Multimedia System");
//                courses.add("Object Oriented Programming");
//                courses.add("Programming Principle");
//            }
//            else
//            {
//
//            }
//        }
//        else {
//            if (semester == 1) {
//                courses.add("Advertising");
//                courses.add("Digital Animation");
//                courses.add("Experimental Design");
//                courses.add("History of Arts");
//                courses.add("Sculpture Modeling");
//            } else if (semester == 2) {
//                courses.add("Character Building");
//                courses.add("Graphic Design");
//                courses.add("History of Graphic Design");
//                courses.add("Pre-press and Printing");
//                courses.add("Screen Design Development");
//                courses.add("Typography");
//            } else {
//
//            }
//        }

        if(courses.size() != 0)
        {
            for (int row=0; row < courses.size(); row++) {
                TableRow tableRow = new TableRow(getActivity());
                tableRow.setLayoutParams(new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.MATCH_PARENT, 100
                ));
                table.addView(tableRow);
                for(int column=0; column < NUM_COLS; column++) {
                    final Button folderButton = new Button(getActivity());
                    if(courses.get(row).equalsIgnoreCase("Character Building"))
                    {
                        folderButton.setId(1);
                    }
                    else
                    {
                        folderButton.setId(2);
                    }
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bnotes33, 0, 0, 0);
                    folderButton.setText("      " + courses.get(row));
                    folderButton.setTextSize(12);
                    Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Arial Rounded Bold.ttf");
                    folderButton.setTypeface(font);
                    folderButton.setBackgroundColor(getResources().getColor(R.color.bnote_transparent_background));
                    folderButton.setGravity(Gravity.LEFT);
                    folderButton.setGravity(Gravity.CENTER_VERTICAL);

                    folderButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);
                            progressBar.setVisibility(view.VISIBLE);
                            new Handler().postDelayed(new Runnable() {

                                @Override
                                public void run() {
                                    bundle.putInt("folderid", folderButton.getId());
                                    Intent intent = new Intent(getActivity(), NotesList.class);
                                    intent.putExtras(bundle);
                                    startActivity(intent);

                                    this.finish();
                                }

                                private void finish() {
                                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);
                                    progressBar.setVisibility(view.INVISIBLE);
                                }
                            }, 2000);

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

