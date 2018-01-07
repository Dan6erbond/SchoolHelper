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

    Spinner frenchTimesSpinner = null;

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
        PQPFragment fragment = new PQPFragment();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.french_times_fragment_container, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        switch((String) parent.getItemAtPosition(pos)){
            case "Plus-que-Parfait":
                changeFragment(new PQPFragment());
                break;
            case "Passé composé":
                changeFragment(new PCFragment());
                break;
            case "Imparfait":
                changeFragment(new IFragment());
                break;
            case "Présent":
                changeFragment(new PFragment());
                break;
            case "Futur composé":
                changeFragment(new FCFragment());
                break;
        }
    }



    public void changeFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.french_times_fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        transaction.commit();
    }

    public void onNothingSelected(AdapterView<?> parent) {}

}
