package com.example.arpit.assignment1.Tab_view.Swipe_tab;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 2/2/17.
 */

public class Fragment_ios extends android.support.v4.app.Fragment {

    public Fragment_ios()
    {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ios=inflater.inflate(R.layout.fragment_ios,container,false);



        return ios;
    }
}
