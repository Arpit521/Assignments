package com.example.arpit.assignment1.View_Pager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 1/2/17.
 */

public class Fragment_page1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_page1,container,false);


        TextView text=(TextView) view.findViewById(R.id.Textview1);
        text.setText(getArguments().getString("msg"));
        return view;
    }

    public static Fragment_page1 newInstance(String text)
    {
        Fragment_page1 page1=new Fragment_page1();
        Bundle b=new Bundle();

        b.putString("msg",text);

        page1.setArguments(b);

        return page1;

    }
}
