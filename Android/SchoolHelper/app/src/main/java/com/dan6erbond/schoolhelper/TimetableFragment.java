package com.dan6erbond.schoolhelper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TimetableFragment extends Fragment {

    private View view;
    private MainActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_timetable, container, false);
        mActivity = (MainActivity)getActivity();
        if (mActivity.isInternetWorking()) {
            while(!mActivity.loadedFiles);
            loadTimetable();
        } else {
            while(!mActivity.loadedFiles);
            loadTimetable();
            Toast.makeText(getActivity(), R.string.no_internet, Toast.LENGTH_LONG).show();
        }
        return view;
    }

    private void loadTimetable() {
        List<Time> startTimes = new ArrayList<>();
        List<Time> endTimes = new ArrayList<>();
        for(TimetableClass _class : mActivity.timetable){
            startTimes.add(_class.startTime);
            endTimes.add(_class.endTime);
        }
        HashSet<Time> _startTimes = new HashSet<>(startTimes);
        HashSet<Time> _endTimes = new HashSet<>(endTimes);
        startTimes = new ArrayList<>(_startTimes);
        endTimes = new ArrayList<>(_endTimes);
        Collections.sort(startTimes);
        Collections.sort(endTimes);

        TableLayout tl = view.findViewById(R.id.timetable_table);

        TableRow tableRow = new TableRow(getActivity());
        tableRow.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tableRow.addView(createTitleView(getString(R.string.timetableTimeDay)));
        if (dayExist(0))
            tableRow.addView(createTitleView(getString(R.string.monday)));
        if (dayExist(1))
            tableRow.addView(createTitleView(getString(R.string.tuesday)));
        if (dayExist(2))
            tableRow.addView(createTitleView(getString(R.string.wednesday)));
        if (dayExist(3))
            tableRow.addView(createTitleView(getString(R.string.thursday)));
        if (dayExist(4))
            tableRow.addView(createTitleView(getString(R.string.friday)));
        if (dayExist(5))
            tableRow.addView(createTitleView(getString(R.string.saturday)));
        if (dayExist(6))
            tableRow.addView(createTitleView(getString(R.string.sunday)));
        tl.addView(tableRow, tableRowParams);

        for (int i = 0; i < startTimes.size(); i++) {
            TableRow tr = new TableRow(getActivity());
            tr.addView(createTimeView(new SimpleDateFormat("HH:mm").format(startTimes.get(i)) + " - " + new SimpleDateFormat("HH:mm").format(endTimes.get(i))));
            TextView monday = createClassView(null);
            TextView tuesday = createClassView(null);
            TextView wednesday = createClassView(null);
            TextView thursday = createClassView(null);
            TextView friday = createClassView(null);
            TextView saturday = createClassView(null);
            TextView sunday = createClassView(null);
            for (TimetableClass _class : mActivity.timetable) {
                if (_class.startTime.equals(startTimes.get(i))){
                    if(_class.day == 0)
                        monday = createClassView(_class);
                    if(_class.day == 1)
                        tuesday = createClassView(_class);
                    if(_class.day == 2)
                        wednesday = createClassView(_class);
                    if(_class.day == 3)
                        thursday = createClassView(_class);
                    if(_class.day == 4)
                        friday = createClassView(_class);
                    if(_class.day == 5)
                        saturday = createClassView(_class);
                    if(_class.day == 6)
                        sunday = createClassView(_class);
                }
            }
            if(dayExist(0))
                tr.addView(monday);
            if(dayExist(1))
                tr.addView(tuesday);
            if(dayExist(2))
                tr.addView(wednesday);
            if(dayExist(3))
                tr.addView(thursday);
            if(dayExist(4))
                tr.addView(friday);
            if(dayExist(5))
                tr.addView(saturday);
            if(dayExist(6))
                tr.addView(sunday);
            tl.addView(tr, tableRowParams);
        }
    }

    private boolean dayExist(int day){
        for(TimetableClass _class : mActivity.timetable){
            if(_class.day == day)
                return true;
        }
        return false;
    }

    private TextView createTitleView(String s) {
        TextView textView = new TextView(getActivity());
        textView.setText(s);
        textView.setPadding(10,10,10,10);
        textView.setTextColor(getResources().getColor(R.color.white));
        textView.setBackgroundResource(R.drawable.timetable_cell);
        return textView;
    }

    private TextView createTimeView(String s) {
        TextView textView = new TextView(getActivity());
        textView.setText(s);
        textView.setPadding(10,10,10,10);
        textView.setBackgroundResource(R.drawable.timetable_cell);
        return textView;
    }

    private TextView createClassView(TimetableClass _c) {
        final TimetableClass c = _c;
        TextView textView = new TextView(getActivity());
        if(c != null){
            textView.setText(c.subject);
            textView.setClickable(true);
            List<String> homework = new ArrayList<>();
            for(Homework h : mActivity.homeworks){
                if(c.subject.contains(h.subject))
                    homework.add(h.job);
            }
            final String homeworks = TextUtils.join("\n",homework);
            textView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    //Build the AlertDialog, set the TextView's text and set the buttons actions.
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.DialogStyle);
                    View _view = getLayoutInflater().inflate(R.layout.dialog_timetable_class, null);
                    builder.setMessage(c.subject);
                    TextView tvTime = _view.findViewById(R.id.dialog_timetable_class_time);
                    TextView tvLocation = _view.findViewById(R.id.dialog_timetable_class_location);
                    TextView tvTeacher = _view.findViewById(R.id.dialog_timetable_class_teacher);
                    TextView tvHomework = _view.findViewById(R.id.dialog_timetable_class_homework);
                    tvTime.setText(new SimpleDateFormat("HH:mm").format(c.startTime) + " - " + new SimpleDateFormat("HH:mm").format(c.endTime));
                    tvLocation.setText(c.location);
                    tvTeacher.setText(c.teacher);
                    tvHomework.setText(homeworks);
                    if(homeworks == "")
                        tvHomework.setText(R.string.no_homework);
                    builder.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    builder.setView(_view);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }
        else
            textView.setText("");
        textView.setPadding(10,10,10,10);
        textView.setBackgroundResource(R.drawable.timetable_cell);
        return textView;
    }
}
