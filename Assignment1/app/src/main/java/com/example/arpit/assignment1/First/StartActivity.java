package com.example.arpit.assignment1.First;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.arpit.assignment1.DetailFragments.ListFragmentExample;
import com.example.arpit.assignment1.Dynamic_Fragment.Dynamic_fragment;
import com.example.arpit.assignment1.Dynamic_Fragment.FragmentCommunicate;
import com.example.arpit.assignment1.Expandable_List.Expandable_List;
import com.example.arpit.assignment1.Fragment.Simple_Fragment.Fragment_Simple;
import com.example.arpit.assignment1.JsonCalling.JsonCall;
import com.example.arpit.assignment1.JsonCalling.LoadMoreRecyclerViewMain;
import com.example.arpit.assignment1.R;
import com.example.arpit.assignment1.Tab_view.Scroll_tab.Scroll_tab;
import com.example.arpit.assignment1.Tab_view.Swipe_tab.Swipe_tab;
import com.example.arpit.assignment1.UpdateAddress.Assignment2_1;
import com.example.arpit.assignment1.View_Pager.View_Pager;


public class StartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);

        Button assign1=(Button)findViewById(R.id.assignment1);
        Button assign2=(Button)findViewById(R.id.assignment2);
        Button assign3=(Button)findViewById(R.id.assignment3);
        Button assign4=(Button)findViewById(R.id.assignment4);
        Button assign5=(Button)findViewById(R.id.assignment5);
        Button assign6=(Button)findViewById(R.id.assignment6);
        Button assign7=(Button)findViewById(R.id.assignment7);
        Button assign8=(Button)findViewById(R.id.assignment8);
        Button assign9=(Button)findViewById(R.id.assignment9);
        Button assign10=(Button)findViewById(R.id.assignment10);
        Button assign11=(Button)findViewById(R.id.assignment11);
        Button assign12=(Button)findViewById(R.id.assignment12);

        assign1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        assign2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(),Assignment2_1.class);
                startActivity(intent);
            }
        });
        assign3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(),Fragment_Simple.class);
                startActivity(intent);
            }
        });
        assign4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(),Dynamic_fragment.class);
                startActivity(intent);
            }
        });
        assign5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(),FragmentCommunicate.class);
                startActivity(intent);
            }
        });
        assign6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(),View_Pager.class);
                startActivity(intent);
            }
        });
        assign7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(),Scroll_tab.class);
                startActivity(intent);
            }
        });
        assign8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(),Swipe_tab.class);
                startActivity(intent);
            }
        });
        assign9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(),Expandable_List.class);
                startActivity(intent);
            }
        });
       assign10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(), ListFragmentExample.class);
                startActivity(intent);
            }
        });
        assign11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(), LoadMoreRecyclerViewMain.class);
                startActivity(intent);
            }
        });
        assign12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new  Intent(getApplicationContext(), JsonCall.class);
                startActivity(intent);
            }
        });





    }


}
