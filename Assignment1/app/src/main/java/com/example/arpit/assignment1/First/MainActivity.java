package com.example.arpit.assignment1.First;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.content.Intent;

import com.example.arpit.assignment1.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Spinner spinner_c;
    Spinner spinYear,spinner_s;
    Button Esave;
    RadioGroup Rbtn;


    EditText Cname;
    EditText Tin;
    EditText Cpan;
    EditText Stnum;
    EditText Pname;
    EditText Add1;
    EditText Add2;
    EditText Cpin;
    EditText Crep;
    EditText rbtn1;
    EditText rbtn2;
    RadioGroup rg;

    String CompanyName;
    String TINno;
    String CompanyPan;
    String sertnum;
    String ProName;
    String Address1;
    String Address2;
    String Pincode;
    String RepreName;


    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       spinnercall();
        fields();


    }
    public void fields()
    {

        Cname=(EditText)findViewById(R.id.edittext1);
        Tin=(EditText)findViewById(R.id.edittext2);
        Cpan=(EditText)findViewById(R.id.edittext3);
        Stnum=(EditText)findViewById(R.id.edittext4);
        Pname=(EditText)findViewById(R.id.edittext5);
        Add1=(EditText)findViewById(R.id.edittext6);
        Add2=(EditText)findViewById(R.id.edittext7);
        Cpin=(EditText)findViewById(R.id.edittext8);
        Crep=(EditText)findViewById(R.id.edittext9);

        Rbtn=(RadioGroup)findViewById(R.id.RadioGroup1);


        Rbtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                int id=Rbtn.getCheckedRadioButtonId();
                View radioButton = Rbtn.findViewById(id);
                if(radioButton.getId()==R.id.rb2)
                {
                    Crep.setEnabled(false);
                    Crep.getText().clear();
                }
                else
                {
                    Crep.setEnabled(true);
                }
            }

        });
        Esave=(Button)findViewById(R.id.Save);
        Esave.setOnClickListener((View.OnClickListener) this);
    }
    public void spinnercall()
    {
        spinner_s = (Spinner) findViewById(R.id.spinner_state);
        ArrayAdapter<CharSequence> state_adapter = ArrayAdapter.createFromResource(this, R.array.State, android.R.layout.simple_spinner_item);
        state_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner_s.setAdapter(state_adapter);


        spinner_c = (Spinner) findViewById(R.id.spinner_city);
        spinner_s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String state = parent.getItemAtPosition(position).toString();
                ArrayAdapter<CharSequence> cities =null;
                switch (state)
                {
                    case "MadhyaPradesh" :
                        cities = ArrayAdapter.createFromResource(MainActivity.this,R.array.MadhyaPradesh,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Rajasthan" :
                        cities = ArrayAdapter.createFromResource(MainActivity.this,R.array.Rajasthan,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "UttarPradesh" :
                        cities = ArrayAdapter.createFromResource(MainActivity.this,R.array.UttarPradesh,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "TamilNadu" :
                        cities = ArrayAdapter.createFromResource(MainActivity.this,R.array.TamilNadu,R.layout.support_simple_spinner_dropdown_item);
                        break;
                    case "Karnataka" :
                        cities = ArrayAdapter.createFromResource(MainActivity.this,R.array.Karnataka,R.layout.support_simple_spinner_dropdown_item);
                        break;


                }

               // cities.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                spinner_c.setAdapter(cities);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        String Eyears[] = new String[16];
        int thisyear= Calendar.getInstance().get(Calendar.YEAR);
        Log.i(TAG,String.valueOf(thisyear));
        for(int i=0;i<=15;i++)
        {
            Eyears[i] = String.valueOf(thisyear-i);
        }

        ArrayAdapter<String> Yearadaptar = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item,Eyears);

        spinYear=(Spinner)findViewById(R.id.spinner_year);
        Yearadaptar.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinYear.setAdapter(Yearadaptar);

    }


    public boolean validate() {
        CompanyName = Cname.getText().toString();
        TINno = Tin.getText().toString();
        CompanyPan = Cpan.getText().toString();
        sertnum = Stnum.getText().toString();
        ProName = Pname.getText().toString();
        Address1 = Add1.getText().toString();
        Address2 = Add2.getText().toString();
        Pincode = Cpin.getText().toString();
        RepreName = Crep.getText().toString();

        boolean company_check = Validation.getInstance().companyname(CompanyName);
        Log.i(TAG,"company name " + company_check);
        boolean TIN_check = Validation.getInstance().TINnumber(TINno);
        boolean PAN_check = Validation.getInstance().CompanyPan(CompanyPan);
        boolean SerTaxNum_check = Validation.getInstance().servicetax(sertnum);
        boolean Proprieter_check = Validation.getInstance().Proprieter(ProName);
        boolean Address1_check = Validation.getInstance().Address(Address1);
        boolean Address2_check = Validation.getInstance().Address(Address2);
        boolean PIN_check = Validation.getInstance().pincode(Pincode);
        boolean Representive_check = Validation.getInstance().Representive(RepreName);


        if (!company_check)
        {
            Cname.setError("Enter Valid Name");
            return false;
        }
        else if (!TIN_check)
        {
            Tin.setError("Enter Valid TIN Number");
            return false;
        }
        else if (!PAN_check)
        {
            Cpan.setError("Enter Valid PAN Number");
            return false;
        }
        else if (!SerTaxNum_check)
        {
            Stnum.setError("Enter Valid Service Tax Number");
            return false;
        }
        else if (!Proprieter_check)
        {
            Pname.setError("Enter Valid Number");
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
        else if (!PIN_check) {
            Cpin.setError("Enter Valid PIN code");
            return false;
        }
        else if (Rbtn.getCheckedRadioButtonId() == R.id.rb1 && !Representive_check)
        {
            Crep.setError("Enter Valid Name");
            return false;
        }
        else
            return true;

    }







    @Override
    public void onClick(View v) {

             boolean act=validate();

            if(act)
                transfer();
        /*    else
                Cname.setError("Please enter a valid name");*/


    }

    public void transfer()
    {
        Intent intent=new Intent(this,Display.class);


        intent.putExtra("CompanyName",Cname.getText().toString());
        intent.putExtra("TIN",Tin.getText().toString());
        intent.putExtra("CompanyPan",Cpan.getText().toString());
        intent.putExtra("ServiceTax",Stnum.getText().toString());
        intent.putExtra("ProprietorName",Pname.getText().toString());
        intent.putExtra("EstablishedYear",spinYear.getSelectedItem().toString());
        intent.putExtra("Address1",Add1.getText().toString());
        intent.putExtra("Address2",Add2.getText().toString());
        intent.putExtra("State",spinner_s.getSelectedItem().toString());
        intent.putExtra("City",spinner_c.getSelectedItem().toString());
        intent.putExtra("Pincode",Cpin.getText().toString());
        //intent.putExtra("Contact",);
        intent.putExtra("RepresentativeName",Crep.getText().toString());

        startActivity(intent);
    }



}




