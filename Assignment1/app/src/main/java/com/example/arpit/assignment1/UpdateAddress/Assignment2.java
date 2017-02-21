package com.example.arpit.assignment1.UpdateAddress;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.arpit.assignment1.R;
import com.example.arpit.assignment1.First.Validation;

public class Assignment2 extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner_state;
    Spinner spinner_city;
    Spinner spinner_country;
    Spinner spinner_pincode;
    Spinner spinner_addresstype;

    EditText fname;
    EditText Lname;
    EditText Add1;
    EditText Add2;
    EditText mobile;
    Spinner state;
    Spinner city;
    Spinner country;
    Spinner pincode;
    Spinner addresstype;
    Button update;

    String Firstname;
    String Lastname;
    String Address1;
    String Address2;
    String Mobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment2);
        fields();
        spinnercall();

        Intent intent = getIntent();
        Customer customer = (Customer) intent.getSerializableExtra("customer_data");
        fname.setText(customer.getfname());
        Lname.setText(customer.getlname());
        Add1.setText(customer.getAdd1());
        Add2.setText(customer.getAdd2());
        mobile.setText(customer.getmobile());



    }

    public void fields()
    {
        fname=(EditText)findViewById(R.id.fname);
        Lname=(EditText)findViewById(R.id.lname);
        Add1=(EditText)findViewById(R.id.address1);
        Add2=(EditText)findViewById(R.id.address2);
        mobile=(EditText)findViewById(R.id.phone);
        state=(Spinner)findViewById(R.id.spinner_state);
        city=(Spinner)findViewById(R.id.spinner_city);
        country=(Spinner)findViewById(R.id.spinner_country);
        pincode=(Spinner)findViewById(R.id.spinner_pincode);
        addresstype=(Spinner)findViewById(R.id.spinner_addresstype);


    }
    public void spinnercall()
    {
        spinner_state=(Spinner)findViewById(R.id.spinner_state);
        ArrayAdapter<CharSequence> state_adapter= ArrayAdapter.createFromResource(this, R.array.Australiastate, android.R.layout.simple_spinner_item);
        state_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_state.setAdapter(state_adapter);

        spinner_city=(Spinner)findViewById(R.id.spinner_city);
        spinner_country=(Spinner)findViewById(R.id.spinner_country);
        spinner_pincode=(Spinner)findViewById(R.id.spinner_pincode);
        spinner_addresstype=(Spinner)findViewById(R.id.spinner_addresstype);


        ArrayAdapter<CharSequence> country_adapter=ArrayAdapter.createFromResource(this,R.array.Country,android.R.layout.simple_spinner_item);
        country_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_country.setAdapter(country_adapter);

        ArrayAdapter<CharSequence> pincode_adapter=ArrayAdapter.createFromResource(this,R.array.Pincode,android.R.layout.simple_spinner_item);
        pincode_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_pincode.setAdapter(pincode_adapter);

        ArrayAdapter<CharSequence> Address_adapter= ArrayAdapter.createFromResource(this,R.array.Address,android.R.layout.simple_spinner_item);
        Address_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_addresstype.setAdapter(Address_adapter);

        spinner_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String state=parent.getItemAtPosition(position).toString();
                ArrayAdapter<CharSequence> cities=null;
                switch (state)
                {
                    case "Queensland":
                        cities=ArrayAdapter.createFromResource(Assignment2.this,R.array.Queensland,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "SouthAustralia":
                        cities=ArrayAdapter.createFromResource(Assignment2.this,R.array.SouthAustralia,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Tasmania":
                        cities=ArrayAdapter.createFromResource(Assignment2.this,R.array.Tasmania,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Acre":
                        cities=ArrayAdapter.createFromResource(Assignment2.this,R.array.Acre,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Amazonas":
                        cities=ArrayAdapter.createFromResource(Assignment2.this,R.array.Amazonas,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Bahia":
                        cities=ArrayAdapter.createFromResource(Assignment2.this,R.array.Bahia,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Madhya Pradesh":
                        cities=ArrayAdapter.createFromResource(Assignment2.this,R.array.MadhyaPradesh,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Rajasthan":
                        cities=ArrayAdapter.createFromResource(Assignment2.this,R.array.Rajasthan,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Uttar Pradesh":
                        cities=ArrayAdapter.createFromResource(Assignment2.this,R.array.UttarPradesh,R.layout.support_simple_spinner_dropdown_item);
                        break;


                }
                cities.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                spinner_city.setAdapter(cities);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public boolean validate()
    {
        Firstname=fname.getText().toString();
        Lastname=Lname.getText().toString();
        Address1=Add1.getText().toString();
        Address2=Add2.getText().toString();
        Mobile=mobile.getText().toString();

        boolean fname_check= Validation.getInstance().Fname(Firstname);
        boolean lname_check=Validation.getInstance().Lname(Lastname);
        boolean Address1_check=Validation.getInstance().Address(Address1);
        boolean Address2_check=Validation.getInstance().Address(Address2);
        boolean mobile_check=Validation.getInstance().mobile(Mobile);

        if (!fname_check)
        {
            fname.setError("Enter Valid Name");
            return false;
        }
        else if (!lname_check)
        {
            Lname.setError("Enter Valid TIN Number");
            return false;
        }

        else if (!Address1_check)
        {
            Add1.setError("Enter Valid Address");
            return false;
        }
        else if (!Address2_check)
        {
            Add2.setError("Enter Valid Address");
            return false;
        }
        else if (!mobile_check) {
            mobile.setError("Enter Valid PIN code");
            return false;

        }
        else
            return true;


    }


    @Override
    public void onClick(View v) {

        boolean act=validate();

        if(act)
            update();

    }

    public void update()
    {
        
    }
}


