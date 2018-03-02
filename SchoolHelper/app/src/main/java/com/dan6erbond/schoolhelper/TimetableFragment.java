package com.dan6erbond.schoolhelper;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TimetableFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);

        ImageView imgView = view.findViewById(R.id.timetable_image);
        imgView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                File file = new File(getActivity().getExternalFilesDir(null), "/Stundenplan.png");
                if (file.exists()) {
                    Log.i("TAG", file.getPath());
                    Intent intent = new Intent();
                    intent.setAction(android.content.Intent.ACTION_VIEW);
                    Uri uri = Uri.parse(file.getPath());
                    intent.setDataAndType(uri,"image/*");
                    startActivity(intent);
                } else {
                    Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.stundenplan);
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(file);

                        CompressFormat format = CompressFormat.PNG;
                        bm.compress(format, 100, fos);

                        fos.close();

                        Intent intent = new Intent();
                        intent.setAction(android.content.Intent.ACTION_VIEW);
                        Uri uri = Uri.parse(file.getPath());
                        intent.setDataAndType(uri,"image/*");
                        startActivity(intent);
                    } catch (IOException e) {
                        Log.e("app", e.getMessage());
                        if (fos != null) {
                            try {
                                fos.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        return view;
    }
}
