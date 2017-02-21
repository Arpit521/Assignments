package com.example.arpit.assignment1.Dynamic_Fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.arpit.assignment1.R;


public class FragmentCommunicate extends Activity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communicate);
    }

    @Override
    public void respond(String data) {

        FragmentManager fm=getFragmentManager();
        FragmentB f2=(FragmentB) fm.findFragmentById(R.id.fragmentB);

        f2.changeText(data);

    }
}
