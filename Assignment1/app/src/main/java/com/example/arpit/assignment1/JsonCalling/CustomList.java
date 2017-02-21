package com.example.arpit.assignment1.JsonCalling;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 15/2/17.
 */

public class CustomList extends ArrayAdapter<String> {

    private String[] ids;
    private String[] names;
    private String[] emails;
    private Activity context;

    public CustomList(Activity context, String[] ids, String[] names, String[] emails) {
        super(context, R.layout.json_list_view, ids);
        this.context = context;
        this.ids = ids;
        this.names = names;
        this.emails = emails;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.json_list_view, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.textViewId);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewEmail = (TextView) listViewItem.findViewById(R.id.textViewEmail);

        textViewId.setText(ids[position]);
        textViewName.setText(names[position]);
        textViewEmail.setText(emails[position]);

        return listViewItem;
    }
}
