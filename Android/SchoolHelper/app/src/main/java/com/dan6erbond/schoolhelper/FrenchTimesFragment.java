package com.dan6erbond.schoolhelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class FrenchTimesFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner frenchTimesSpinner = null;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_french_times, container, false);

        setTime("Plus-que-Parfait");

        frenchTimesSpinner = view.findViewById(R.id.french_times_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.french_time_topics, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frenchTimesSpinner.setOnItemSelectedListener(this);
        frenchTimesSpinner.setAdapter(adapter);

        return view;
    }

    private void setTime(String t){
        switch(t){
            case "Plus-que-Parfait":
                updateUI("Plus-que-Parfait", R.string.french_time_pqp_usage, R.string.french_time_pqp_formation, R.string.french_time_pqp_example);
                break;
            case "Passé composé":
                updateUI("Passé composé", R.string.french_time_pc_usage, R.string.french_time_pc_formation, R.string.french_time_pc_example);
                break;
            case "Imparfait":
                updateUI("Imparfait", R.string.french_time_i_usage, R.string.french_time_i_formation, R.string.french_time_i_example);
                break;
            case "Présent":
                updateUI("Présent", R.string.french_time_p_usage, R.string.french_time_p_formation, R.string.french_time_p_example);
                break;
            case "Futur composé":
                updateUI("Futur composé", R.string.french_time_fc_usage, R.string.french_time_fc_formation, R.string.french_time_fc_example);
                break;
        }
    }

    private void updateUI(String _header, int _usage, int _formation, int _example){
        TextView header = view.findViewById(R.id.french_time_header);
        header.setText(_header);

        TextView usage = view.findViewById(R.id.french_time_usage);
        usage.setText(_usage);

        TextView formation = view.findViewById(R.id.french_time_formation);
        formation.setText(_formation);

        TextView example = view.findViewById(R.id.french_time_example);
        example.setText(_example);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        setTime((String) parent.getItemAtPosition(pos));
    }

    public void onNothingSelected(AdapterView<?> parent) {}

}
