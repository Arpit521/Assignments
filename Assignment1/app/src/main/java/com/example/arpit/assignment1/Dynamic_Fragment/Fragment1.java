package com.example.arpit.assignment1.Dynamic_Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 31/1/17.
 */

public class Fragment1 extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment1,container,false);
    }
}
