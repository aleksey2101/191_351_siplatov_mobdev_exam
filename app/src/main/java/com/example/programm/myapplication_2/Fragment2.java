package com.example.programm.myapplication_2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    final static String TAG="Fragment2";
    String searchTextMyNew;

    View rootView;
    ListView listView;
    private EditText queryEditText;
    CustomListAdapter adapter;

    //    private ArrayList<String> mynewsList = new ArrayList<>();
    List<MyNew> mynewsList = new ArrayList<>();

    public static Fragment2 newInstance() {
        return new Fragment2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment2, container, false);

        queryEditText = (EditText) rootView.findViewById(R.id.editTextSearhLab5);
        ImageButton searchMyNewButton = (ImageButton) rootView.findViewById(R.id.searchMyNewButton);
        searchMyNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTextMyNew = ""+queryEditText.getText();

                Log.i(TAG,"searchTextMyNew: "+ searchTextMyNew);
            }
        });

        addLovalNews();
        listView = (ListView) rootView.findViewById(R.id.ListViewLab5);

        adapter = new CustomListAdapter(getActivity(), mynewsList);
        listView.setAdapter(adapter);
        return rootView;
    }

    private  List<MyNew> addLovalNews() {
//        List<MyNew> mynewsList = new ArrayList<MyNew>();
        MyNew vietnam = new MyNew("New1", "img_link1", "01.01.2020");
        MyNew usa = new MyNew("New22", "img_link1", "16.07.2021");
        MyNew russia = new MyNew("New12", "img_link1", "05.06.1980");

        mynewsList.add(vietnam);
        mynewsList.add(usa);
        mynewsList.add(russia);

        return mynewsList;
    }

}