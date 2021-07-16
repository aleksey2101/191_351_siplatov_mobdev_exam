package com.example.programm.myapplication_2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Fragment1 extends Fragment {

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    View rootView;
    EditText passEditText;
    EditText loginEditText;

    final static String TAG="Fragment1";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView is started");

        rootView = inflater.inflate(R.layout.fragment1, container, false);

        passEditText = rootView.findViewById(R.id.passEditText);
        loginEditText = rootView.findViewById(R.id.LoginEditText);

        Button LoginButton = rootView.findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginEditText.getText().toString().equals("Admin")&&passEditText.getText().toString().equals("pass")){
                    Toast toast = Toast.makeText(rootView.getContext(),
                            "Welcome!",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    ((MainActivity) Objects.requireNonNull(getActivity())).setCurrentItemChooseFragment2();
                }
                else {
                    Toast toast = Toast.makeText(rootView.getContext(),
                            "Error!",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
        });

        return rootView;
    }
}