package com.example.arpit.assignment1.Dynamic_Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 1/2/17.
 */

public class FragmentA extends Fragment {
    Button btn1;
    Button btn2;
    int counter=0;
    Communicator comm;
    String data1="You cannot protect yourself from sadness without protecting yourself from happiness";
    String data2="Believe in yourself! Have faith in your abilities! Without a humble but reasonable confidence in your own powers you cannot be successful or happy";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null)
        {
            counter=0;
        }
        else
        {
            counter=savedInstanceState.getInt("counter",0);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View view=inflater.inflate(R.layout.fragmenta,container,false);
            return view;
        }

        public void onActivityCreated(Bundle savedInstanceState)
        {
            super.onActivityCreated(savedInstanceState);
            comm=(Communicator) getActivity();
            btn1=(Button)getActivity().findViewById(R.id.fragbtn1);
            btn2=(Button)getActivity().findViewById(R.id.fragbtn2);



            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comm.respond(data1);


                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comm.respond(data2);


                }
            });
        }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",counter);
    }

}
