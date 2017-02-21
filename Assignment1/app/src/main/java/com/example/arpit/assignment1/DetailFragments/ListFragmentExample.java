package com.example.arpit.assignment1.DetailFragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.arpit.assignment1.R;

public class ListFragmentExample extends AppCompatActivity {

    android.app.Fragment fr;
    FragmentManager fm;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment_example);


        fr=new MyListFragment();
        fm=getFragmentManager();;

        ft=fm.beginTransaction();

        ft.replace(R.id.activity_list_fragment_example,fr);
        ft.addToBackStack(null);
        ft.commit();

    }
}
