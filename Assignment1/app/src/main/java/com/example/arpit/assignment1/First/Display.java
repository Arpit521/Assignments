package com.example.arpit.assignment1.First;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

import org.w3c.dom.Text;

public class Display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        TextView t5;
        TextView t6;
        TextView t7;
        TextView t8;
        TextView t9;
        TextView t10;
        TextView t11;
        TextView t12;

        Intent intent=getIntent();
       t1=(TextView)findViewById(R.id.textview1);
        String cn=intent.getStringExtra("CompanyName");
        t1.setText(cn);

        t2=(TextView)findViewById(R.id.textview2);

        String tin=intent.getStringExtra("TIN");
        t2.setText(tin);

        t3=(TextView)findViewById(R.id.textview3);
        String cp=intent.getStringExtra("CompanyPan");
        t3.setText(cp);

        t4=(TextView)findViewById(R.id.textview4);
        String st=intent.getStringExtra("ServiceTax");
        t4.setText(st);

        t5=(TextView)findViewById(R.id.textview5);
        String pn=intent.getStringExtra("ProprietorName");
        t5.setText(pn);

        t6=(TextView)findViewById(R.id.textview6);
        String ad1=intent.getStringExtra("Address1");
        t6.setText(ad1);

        t7=(TextView)findViewById(R.id.textview7);
        String ad2=intent.getStringExtra("Address2");
        t7.setText(ad2);

        t8=(TextView)findViewById(R.id.textview8);
        String sta=intent.getStringExtra("State");
        t8.setText(sta);

        t9=(TextView)findViewById(R.id.textview9);
        String cit=intent.getStringExtra("City");
        t9.setText(cit);

        t10=(TextView)findViewById(R.id.textview10);
        String pc=intent.getStringExtra("Pincode");
        t10.setText(pc);

        t11=(TextView)findViewById(R.id.textview11);
        String year=intent.getStringExtra("EstablishedYear");
        t11.setText(year);

        t12=(TextView)findViewById(R.id.textview12);
        String Rn=intent.getStringExtra("RepresentativeName");
        t12.setText(Rn);


    }
}
