package com.dan6erbond.schoolhelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FrenchTimeFragment extends Fragment {

    View view = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_french_time, container, false);
        updateUI("Plus-que-Parfait", R.string.french_time_pqp_usage, R.string.french_time_pqp_formation, R.string.french_time_pqp_example);
        return view;
    }

    public void updateUI(String _header, int _usage, int _formation, int _example){
        TextView header = view.findViewById(R.id.french_time_header);
        header.setText(_header);

        TextView usage = view.findViewById(R.id.french_time_usage);
        usage.setText(_usage);

        TextView formation = view.findViewById(R.id.french_time_formation);
        formation.setText(_formation);

        TextView example = view.findViewById(R.id.french_time_example);
        example.setText(_example);
    }
}
