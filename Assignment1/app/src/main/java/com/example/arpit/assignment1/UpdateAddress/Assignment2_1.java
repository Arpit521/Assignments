package com.example.arpit.assignment1.UpdateAddress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.example.arpit.assignment1.R;

import java.util.ArrayList;
import java.util.*;

public class    Assignment2_1 extends AppCompatActivity {

    /*ListView Listname;
    String[] Listname_array={ "Arpit Gupta",
            "Sangeet Kumar",
            "Ashar Sultana",
            "Abhilash Dhankar",
            "Mamta Singh",
            "Lovely Kumari",
            "Deepa Patle",
            "Anshul Dabas",
            "Ayushi Garg"};*/

    private List<Customer> CustList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CustomerAdapter CustAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    //    Listname= (ListView)findViewById(R.id.listview1);


        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        CustAdapter = new CustomerAdapter(getApplicationContext(),CustList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(CustAdapter);


        prepareCustdata();


       /* ArrayAdapter<String> Listname_adapter= new ArrayAdapter(this,R.layout.textview,Listname_array);

        Listname.setAdapter(Listname_adapter);
        Listname.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent=new Intent(Assignment2_1.this,Assignment2.class);
                startActivity(intent);*/
            }


    private void prepareCustdata()
    {
        Customer cust=new Customer("Arpit","Gupta","hsr layout","sector2","14214","karnataka","Banglore","india","12541","Shipping Address");
        CustList.add(cust);

        cust= new Customer("Ashar","Sultana","hsr layout","sector2","1221","karnataka","Banglore","india","12541","Billing Address");
        CustList.add(cust);

        cust=new Customer("Sangeet","Kumar","hinjewadi","sector3","147852","karnataka","Banglore","india","12541","Shipping Address");
        CustList.add(cust);
        cust=new Customer("Sangeet","Kumar","hinjewadi","sector3","147852","karnataka","Banglore","india","12541","Shipping Address");
        CustList.add(cust);

        cust=new Customer("Sangeet","Kumar","hinjewadi","sector3","147852","karnataka","Banglore","india","12541","Shipping Address");
        CustList.add(cust);

        cust=new Customer("Sangeet","Kumar","hinjewadi","sector3","147852","karnataka","Banglore","india","12541","Shipping Address");
        CustList.add(cust);


        cust=new Customer("Sangeet","Kumar","hinjewadi","sector3","147852","karnataka","Banglore","india","12541","Shipping Address");
        CustList.add(cust);

        CustAdapter.notifyDataSetChanged();

    }


}
