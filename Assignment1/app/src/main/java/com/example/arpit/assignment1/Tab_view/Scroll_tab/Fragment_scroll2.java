package com.example.arpit.assignment1.Tab_view.Scroll_tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 2/2/17.
 */

public class Fragment_scroll2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_scroll2,container,false);
        return view;
    }

     public static Fragment_scroll2 newInstance(String text) {

        Bundle args = new Bundle();

        Fragment_scroll2 fragment = new Fragment_scroll2();
        args.putString("msg",text);
        fragment.setArguments(args);
        return fragment;
    }
}
