package com.example.arpit.assignment1.Tab_view.Scroll_tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 2/2/17.
 */

public class Fragment_scroll1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_scroll1,container,false);

        TextView t1=(TextView) view.findViewById(R.id.TextScroll1);
        t1.setText(getArguments().getString("msg"));
        return view;
    }

    public static Fragment_scroll1 newInstance(String text) {

        Fragment_scroll1 fragment = new Fragment_scroll1();
        Bundle args = new Bundle();
        args.putString("msg",text);
        fragment.setArguments(args);
        return fragment;
    }
}
