package com.example.arpit.assignment1.DatabaseSQLite;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.arpit.assignment1.R;

import java.util.ArrayList;
import java.util.List;

public class AndroidSQLiteTutorialActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_sqlite_tutorial);
        ListView lv=(ListView)findViewById(R.id.listviewdatabase);
        List<Contact> logdata =new ArrayList<Contact>();

        DatabaseHandler db=new DatabaseHandler(this);

        //SQLiteDatabase sqLiteDatabase=db.getWritableDatabase();
        Log.d("Insert: ","Inserting.. ");
        db.addContact(new Contact("Arpit","8144525455"));
        db.addContact(new Contact("Kartik","9854541236"));
        db.addContact(new Contact("Sangeet","1234567890"));
        db.addContact(new Contact("Ashar","8105454545"));

        Log.d("Reading: ","Reading all Contacts:");
        List<Contact> contacts=db.getAllContact();
        //String log = null;

        for(Contact cn:contacts)
        {
          /* log ="id: " + cn.get_id()  +"Name: "+cn.get_name()+"  Phone Number: "+cn.get_phone_number();
            Log.d("Name: ",log);*/

            Contact contact=new Contact(cn.get_id(),cn.get_name(),cn.get_phone_number());
            logdata.add(contact);
        }

        Arrayadapterdatabase  arrayadapterdatabase=new Arrayadapterdatabase(this,logdata);
        lv.setAdapter(arrayadapterdatabase);
        
/*
        ArrayAdapter<Contact > arrayAdapter=new ArrayAdapter<Contact>(this,android.R.layout.simple_list_item_1,contacts);
        lv.setAdapter(new Arrayadapterdatabase(this,);*/

    }

}
