package com.example.arpit.assignment1.UpdateAddress;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arpit.assignment1.R;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> implements RecyclerView.OnClickListener {

    private Context context;
    Customer cust;

    private List<Customer> CustomerList;


    @Override
    public void onClick(View v) {
        //Toast.makeText(context,"hello",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(context,Assignment2.class);
        intent.putExtra("customer_data", (Customer) v.getTag());
        context.startActivity(intent);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView fname, lname, add1,add2,mobile,state,pincode,city,country,addresstype;

        public MyViewHolder(View view) {
            super(view);
            fname = (TextView) view.findViewById(R.id.fname);
            lname = (TextView) view.findViewById(R.id.lname);
            add1= (TextView) view.findViewById(R.id.add1);
            add2=(TextView) view.findViewById(R.id.add2);
            mobile=(TextView) view.findViewById(R.id.mobile);
            state=(TextView) view.findViewById(R.id.state);
            pincode=(TextView) view.findViewById(R.id.pincode);
            city=(TextView) view.findViewById(R.id.city);
            country=(TextView) view.findViewById(R.id.country1);
            addresstype=(TextView) view.findViewById(R.id.addresstype);
        }
    }

    public CustomerAdapter(Context context , List<Customer> customerList) {
        this.CustomerList = customerList;
        this.context = context;
    }
    @Override
    public CustomerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View CustomerView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_list, parent, false);
       CustomerView.setOnClickListener(this);

        return new MyViewHolder(CustomerView);
    }

    @Override
    public void onBindViewHolder(CustomerAdapter.MyViewHolder holder, int position) {

        cust=CustomerList.get(position);
        holder.fname.setText(cust.getfname());
        holder.lname.setText(cust.getlname());
        holder.add1.setText(cust.getAdd1());
        holder.add2.setText(cust.getAdd2());
       holder.mobile.setText(cust.getmobile());
        holder.state.setText(cust.getstate());
       holder.pincode.setText(cust.getpin());
        holder.city.setText(cust.getcity());
        holder.country.setText(cust.getcountry());
        holder.addresstype.setText(cust.getaddtype());

        holder.itemView.setTag(cust);

    }

    @Override
    public int getItemCount() {
        return CustomerList.size();
    }
}
