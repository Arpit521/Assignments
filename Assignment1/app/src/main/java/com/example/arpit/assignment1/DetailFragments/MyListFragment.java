package com.example.arpit.assignment1.DetailFragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.arpit.assignment1.R;

/**
 * Created by arpit on 7/2/17.
 */

public class MyListFragment extends ListFragment implements AdapterView.OnItemClickListener{



    Fragment fr;
    FragmentManager fm;
    FragmentTransaction ft;
    ArrayAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.myfragmentlist,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter=ArrayAdapter.createFromResource(getActivity(),R.array.State,android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    //    if(position==0)

        String str = (String) adapter.getItem(position);

        fr = DetailFragment.newInstance(getString(getResources().getIdentifier(str, "string", getActivity().getPackageName())));

        fm=getFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.activity_list_fragment_example,fr);
        ft.addToBackStack(null);
        ft.commit();


    }


}
