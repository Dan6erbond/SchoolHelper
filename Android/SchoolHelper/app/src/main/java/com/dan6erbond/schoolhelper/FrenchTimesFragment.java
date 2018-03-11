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

public class FrenchTimesFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner frenchTimesSpinner = null;
    private FrenchTimeFragment fragment = new FrenchTimeFragment();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_french_times, container, false);

        createFirstFragment();

        frenchTimesSpinner = view.findViewById(R.id.french_times_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.french_time_topics, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frenchTimesSpinner.setOnItemSelectedListener(this);
        frenchTimesSpinner.setAdapter(adapter);

        return view;
    }

    private void createFirstFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.french_times_fragment_container, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch((String) parent.getItemAtPosition(pos)){
            case "Plus-que-Parfait":
                fragment.updateUI("Plus-que-Parfait", R.string.french_time_pqp_usage, R.string.french_time_pqp_formation, R.string.french_time_pqp_example);
                break;
            case "Passé composé":
                fragment.updateUI("Passé composé", R.string.french_time_pc_usage, R.string.french_time_pc_formation, R.string.french_time_pc_example);
                break;
            case "Imparfait":
                fragment.updateUI("Imparfait", R.string.french_time_i_usage, R.string.french_time_i_formation, R.string.french_time_i_example);
                break;
            case "Présent":
                fragment.updateUI("Présent", R.string.french_time_p_usage, R.string.french_time_p_formation, R.string.french_time_p_example);
                break;
            case "Futur composé":
                fragment.updateUI("Futur composé", R.string.french_time_fc_usage, R.string.french_time_fc_formation, R.string.french_time_fc_example);
                break;
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {}

}
