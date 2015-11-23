package com.segid.bnote;

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


public class Semester1Fragment extends Fragment {

    public Semester1Fragment() {
        // Required empty public constructor
    }

    private static final int NUM_ROWS = 10;
    private static final int NUM_COLS = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        populateButtons();

        return inflater.inflate(R.layout.fragment_help, container, false);
    }
    private void populateButtons() {

        TableLayout table = (TableLayout) getView().findViewById(R.id.folderButtonTable);
        for (int row=0; row < NUM_ROWS; row++){
            TableRow tableRow = new TableRow(getContext());
            table.addView(tableRow);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT, 100
            ));
            for(int column=0; column < NUM_COLS; column++)
            {
                Button folderButton = new Button(getContext());
                folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icons30, 0, 0, 0);
                folderButton.setText("      FOLDER"+row);
                folderButton.setBackgroundColor(getResources().getColor(R.color.bnote_transparent_background));
                folderButton.setGravity(Gravity.LEFT);
                folderButton.setGravity(Gravity.CENTER_VERTICAL);
                tableRow.addView(folderButton);
            }
            Space rowSpace = new Space(getContext());
            rowSpace.setMinimumHeight(20);
            table.addView(rowSpace);
        }
    }
}
