package com.segid.bnote;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


public class HelpFragment extends Fragment {

    public HelpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_help, container, false);

        ExpandableListView elv = (ExpandableListView) view.findViewById(R.id.list);
        elv.setAdapter(new SavedTabsListAdapter());

        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;

        elv.setIndicatorBoundsRelative(width - getDipsFromPixel(80), width - getDipsFromPixel(40));
        // Inflate the layout for this fragment
        return view;
    }

    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale );
    }


    public class SavedTabsListAdapter extends BaseExpandableListAdapter {

        private String[] groups = { "Change Semester", "Post a note", "Post comment", "More information" };

        private String[][] children = {
                { "Click on :: menu button in the toolbar -> Select the semester you want to view (scroll horizontally)" },
                { "Select course -> Click on '+' button" },
                { "Click on comment button in the note" },
                { "Contact 12345 or compose your mail in 'support' option" }
        };

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(HelpFragment.this.getActivity());
            textView.setText(getGroup(i).toString());
            textView.setTextSize(15);
            textView.setTypeface(null, Typeface.BOLD);
            textView.setPadding(25,10,0,25);
            textView.setBackgroundColor(getResources().getColor(R.color.bnote_purple));
            textView.setTextColor(getResources().getColor(R.color.bnote_white));
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(HelpFragment.this.getActivity());
            textView.setText(getChild(i, i1).toString());
            textView.setTextSize(12);
            textView.setPadding(25,20,0,15);
            return textView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

    }

}
