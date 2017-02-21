package com.example.arpit.assignment1.Dynamic_Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 1/2/17.
 */

public class FragmentB extends Fragment {

    TextView t1;
    String data;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragmentb,container,false);
        if(savedInstanceState==null)
        {

        }
        else
        {
            savedInstanceState.getString("text");
            TextView txt=(TextView) view.findViewById(R.id.text1);
            txt.setText(data);
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        t1=(TextView) getActivity().findViewById(R.id.text1);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",data);
    }

    public void changeText(String data)
    {
        t1.setText(data);
    }

}
