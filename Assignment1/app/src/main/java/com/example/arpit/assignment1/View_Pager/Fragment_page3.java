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

public class Fragment_page3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_page3,container,false);


        TextView text=(TextView) view.findViewById(R.id.Textview1);
        text.setText(getArguments().getString("msg"));
        return view;
    }

    public static Fragment_page3 newInstance(String text)
    {
        Fragment_page3 page3=new Fragment_page3();
        Bundle b=new Bundle();

        b.putString("msg",text);

        page3.setArguments(b);

        return page3;

    }


}
