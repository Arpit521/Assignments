package com.example.arpit.assignment1.Fragment.Simple_Fragment;

/**
 * Created by arpit on 27/1/17.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arpit.assignment1.R;

public class Fragment1 extends Fragment{

@Nullable
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment1,container,false);
        return view;
    }

}
