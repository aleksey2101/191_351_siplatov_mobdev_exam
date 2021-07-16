package com.example.programm.myapplication_2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fragment2 extends Fragment {

    final static String TAG="Fragment2";

    View rootView;
    ListView listView;
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

        addLocalNews();
        listView = (ListView) rootView.findViewById(R.id.ListViewLab5);

        ImageButton btn = (ImageButton) rootView.findViewById(R.id.closeBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) Objects.requireNonNull(getActivity())).setCurrentItemChooseFragment1();
            }
        });

        adapter = new CustomListAdapter(getActivity(), mynewsList);
        listView.setAdapter(adapter);
        return rootView;
    }

    private  List<MyNew> addLocalNews() {
//        List<MyNew> mynewsList = new ArrayList<MyNew>();
        String img_link = "https://new.mospolytech.ru/upload/resize_cache/iblock/4dc/880_660_0/IMG_4079.PNG";
        MyNew vietnam = new MyNew("New1", "img_link1", "01.01.2020");
        MyNew usa = new MyNew("New22", img_link, "16.07.2021");
        MyNew russia = new MyNew("New12", "img_link1", "05.06.1980");

        mynewsList.add(vietnam);
        mynewsList.add(usa);
        mynewsList.add(russia);

        return mynewsList;
    }

}