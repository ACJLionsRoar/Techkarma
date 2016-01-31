package com.example.aswin_000.techkarma;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ACJLionsRoar on 1/31/16.
 */
public class Queen extends Fragment {

    public static class Fragment1 extends Queen
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_playnow_options, parentViewGroup, false);
            return rootView;
        }
    }

    public static class Fragment2 extends Queen
    {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_playnow_questions, parentViewGroup, false);
            return rootView;
        }
    }
}
