package com.example.arpit.assignment1.Fragment.Simple_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 27/1/17.
 */

public class Fragment2 extends Fragment{

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
         View view = inflater.inflate(R.layout.fragment2,container,false);
        return view;

    }
}
