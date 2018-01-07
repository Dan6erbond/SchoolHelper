package com.dan6erbond.schoolhelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FCFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_french_time, container, false);

        TextView header = view.findViewById(R.id.french_time_header);
        header.setText("Futur composé");

        TextView usage = view.findViewById(R.id.french_time_usage);
        usage.setText(R.string.french_time_fc_usage);

        TextView formation = view.findViewById(R.id.french_time_formation);
        formation.setText(R.string.french_time_fc_formation);

        TextView example = view.findViewById(R.id.french_time_example);
        example.setText(R.string.french_time_fc_example);

        return view;
    }
}
