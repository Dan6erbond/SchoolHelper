package com.dan6erbond.schoolhelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FrenchFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_french, container, false);

        final Button zusammenfassungenButton = view.findViewById(R.id.french_times);
        zusammenfassungenButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        ((MainActivity)getActivity()).changeFragment(new FrenchTimesFragment());
                    }
                }
        );

        return view;
    }
}
