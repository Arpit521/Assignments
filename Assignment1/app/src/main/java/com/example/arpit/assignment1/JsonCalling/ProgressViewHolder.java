package com.example.arpit.assignment1.JsonCalling;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.arpit.assignment1.R;


/**
 * Created by arpit on 9/2/17.
 */

public class ProgressViewHolder extends RecyclerView.ViewHolder {

    public ProgressBar progressBar;

    public ProgressViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar)itemView.findViewById(R.id.progressBar1);
    }
}
