package com.example.arpit.assignment1.Dynamic_Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.widget.Button;
import android.view.View;

import com.example.arpit.assignment1.R;


public class Dynamic_fragment extends Activity {

    Button btn1,btn2;
    Fragment fr;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_dynamic_fragment);


        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fr=new Fragment1();
                fm=getFragmentManager();;

                ft=fm.beginTransaction();

                ft.replace(R.id.frag,fr);
                ft.addToBackStack(null);
                ft.commit();

            }


        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fr=new Fragment2();
                fm=getFragmentManager();
                ft=fm.beginTransaction();

                ft.replace(R.id.frag,fr);
                ft.addToBackStack(null);

                ft.commit();


            }
        });

    }



}
