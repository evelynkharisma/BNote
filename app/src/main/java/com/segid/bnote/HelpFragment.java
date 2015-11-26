package com.segid.bnote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

        // Inflate the layout for this fragment
        return view;
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
            textView.setTextSize(20);
            textView.setBackgroundColor(getResources().getColor(R.color.bnote_yellow));
            textView.setTextColor(getResources().getColor(R.color.bnote_purple));
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(HelpFragment.this.getActivity());
            textView.setText(getChild(i, i1).toString());
            textView.setTextSize(15);
            textView.setPadding(20,5,0,0);
            return textView;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

    }

}
