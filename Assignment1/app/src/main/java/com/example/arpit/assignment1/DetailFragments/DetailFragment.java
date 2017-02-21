package com.example.arpit.assignment1.DetailFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 7/2/17.
 */

public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.newlayout,container,false);
        TextView text=(TextView) view.findViewById(R.id.detailtext);
        text.setText(getArguments().getString("msg"));
        return view;
    }

    public static DetailFragment newInstance(String text)
    {
        DetailFragment page=new DetailFragment();
        Bundle b=new Bundle();

        b.putString("msg",text);

        page.setArguments(b);

        return page;

    }
}
