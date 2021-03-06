package com.example.arpit.assignment1.Expandable_List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by arpit on 2/2/17.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> ListDataHeader;
    private HashMap<String,List<String>> ListDataChild;

    public ExpandableListAdapter(Context context,List<String> listDataHeader,HashMap<String,List<String>> listDataChild)
    {
        this.context=context;
        this.ListDataHeader=listDataHeader;
        this.ListDataChild=listDataChild;
    }




    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.ListDataChild.get(this.ListDataHeader.get(groupPosition)).get(childPosition);
    }



    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText=(String) getChild(groupPosition,childPosition);

        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView=inflater.inflate(R.layout.list_item,null);
        }

        TextView textListChild=(TextView) convertView.findViewById(R.id.lblListItem);
        textListChild.setText(childText);


        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.ListDataChild.get(this.ListDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.ListDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.ListDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String HeaderTitle=(String )getGroup(groupPosition);

        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView=inflater.inflate(R.layout.list_group,null);
        }

        TextView lblListHeader = (TextView) convertView.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(HeaderTitle);


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
