package com.example.arpit.assignment1.DatabaseSQLite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arpit on 21/2/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME="contactsManager";

    private static final String TABLE_CONTACTS="contact";


    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_PH_NO="phone_number";
    String CREATE_CONTACTS_TABLE ="CREATE TABLE "+ TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY , " + KEY_NAME + " VARCHAR(255), " + KEY_PH_NO + " VARCHAR(255) " + ")";

   // private Context context;
    public DatabaseHandler(Context context) {

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
       // this.context=context;
        Log.d("arpit","DATABASEhandler");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("arpit","oncreate");
       // Toast.makeText(context,"Oncreate called",Toast.LENGTH_SHORT).show();
       // String CREATE_CONTACTS_TABLE ="CREATE TABLE "+TABLE_CONTACTS + "(" + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME + "TEXT, " + KEY_PH_NO + "TEXT" + ")";
        try {
            db.execSQL(CREATE_CONTACTS_TABLE);
        }
        catch (SQLException e)
        {

            e.printStackTrace();
          //  Toast.makeText(context,"Oncreate",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

      //  Toast.makeText(context,"onUpgrade called",Toast.LENGTH_SHORT).show();
        try {
            db.execSQL("DROP TABLE " +TABLE_CONTACTS+ " IF EXISTS");
            onCreate(db);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
          //  Toast.makeText(context,"onUpgrade",Toast.LENGTH_SHORT).show();
        }

    }

    public void addContact(Contact contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(KEY_NAME,contact.get_name());
        values.put(KEY_PH_NO,contact.get_phone_number());

        long result=db.insert(TABLE_CONTACTS,null,values);
        Log.d("add contact",""+result);
        //Toast.makeText(,""+result,Toast.LENGTH_LONG).show();
        db.close();
    }
    public Contact getContact(int id)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.query(TABLE_CONTACTS,new String[] {KEY_ID,KEY_NAME,KEY_PH_NO},KEY_ID+ "=?",new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();

        Contact contact=new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));


        return contact;
    }
    public List<Contact> getAllContact()
    {
        List<Contact> contactList=new ArrayList<Contact>();

        String selectQuery=" SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst())
        {
            do
            {
                Contact contact=new Contact();
                 contact.set_id (Integer.parseInt(cursor.getString(0)));
                contact.set_name(cursor.getString(1));
                contact.set_phone_number(cursor.getString(2));

                contactList.add(contact);

            }while (cursor.moveToNext());
        }
        return contactList;

    }

    public int getContactCount()
    {
        String countQuery=" SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(countQuery,null);

        cursor.close();
        return cursor.getCount();
    }

    public int UpdateContact(Contact contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_NAME,contact.get_name());
        values.put(KEY_PH_NO,contact.get_phone_number());


        return db.update(TABLE_CONTACTS,values,KEY_ID + "=?", new String[] { String.valueOf(contact.get_id())});
    }
    public void deleteContact(Contact contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        db.delete(TABLE_CONTACTS,KEY_ID+"=?",new String[] {String.valueOf(contact.get_id())});
        db.close();
    }

}
