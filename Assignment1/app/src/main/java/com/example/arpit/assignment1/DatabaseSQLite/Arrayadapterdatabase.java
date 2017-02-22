package com.example.arpit.assignment1.DatabaseSQLite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arpit on 21/2/17.
 */

public class Arrayadapterdatabase extends BaseAdapter {

    List<Contact> contactArrayList;
    private LayoutInflater mInflater;
    private Context context;

    public Arrayadapterdatabase(Context context,List<Contact> contactlist)
    {
        this.context=context;
        contactArrayList=contactlist;
        mInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder;

        if(convertView==null)
        {
            convertView=mInflater.inflate(R.layout.custome_listview,null);
            holder=new ViewHolder();
            holder.id=(TextView) convertView.findViewById(R.id.userid);
            holder.name=(TextView) convertView.findViewById(R.id.username);
            holder.phone=(TextView) convertView.findViewById(R.id.usercontact);

            convertView.setTag(holder);

        }
        else
        {
            holder=(ViewHolder)convertView.getTag();
        }
        int idvalue=contactArrayList.get(position).get_id();
        holder.id.setText(String.valueOf(idvalue));
        holder.name.setText(contactArrayList.get(position).get_name());
        holder.phone.setText(contactArrayList.get(position).get_phone_number());


        return convertView;
    }

    static class ViewHolder
    {
        TextView id;
        TextView name;
        TextView phone;
    }
}
