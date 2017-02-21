package com.example.arpit.assignment1.View_Pager;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 1/2/17.
 */

public class Fragment_page2 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_page2,container,false);


        TextView text=(TextView) view.findViewById(R.id.Textview1);
        text.setText(getArguments().getString("msg"));
        return view;
    }

    public static Fragment_page2 newInstance(String text)
    {
        Fragment_page2 page2=new Fragment_page2();
        Bundle b=new Bundle();

        b.putString("msg",text);

        page2.setArguments(b);

        return page2;

    }
}
