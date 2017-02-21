package com.example.arpit.assignment1.JsonCalling;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 9/2/17.
 */

public class RecyclerViewHolders extends RecyclerView.ViewHolder {


    public TextView tvName;
    public TextView tvEmailid;
    public RecyclerViewHolders(View itemView) {
        super(itemView);
        //itemView.setOnClickListener(this);
        tvName = (TextView)itemView.findViewById(R.id.tvName);
        tvEmailid=(TextView)itemView.findViewById(R.id.tvEmailID);
    }

}
