package com.dan6erbond.schoolhelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button zusammenfassungenButton = view.findViewById(R.id.home_zusammenfassungen);
        zusammenfassungenButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        ((MainActivity)getActivity()).changeFragment(new ZusammenfassungenFragment());
                    }
                }
        );

        Button frenchButton = view.findViewById(R.id.home_french);
        frenchButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        ((MainActivity)getActivity()).changeFragment(new FrenchFragment());
                    }
                }
        );

        Button timetableButton = view.findViewById(R.id.home_timetable);
        timetableButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        ((MainActivity)getActivity()).changeFragment(new TimetableFragment());
                    }
                }
        );

        Button homeworkButton = view.findViewById(R.id.home_homework);
        homeworkButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        ((MainActivity)getActivity()).changeFragment(new HomeworkFragment());
                    }
                }
        );

        return view;
    }
}
