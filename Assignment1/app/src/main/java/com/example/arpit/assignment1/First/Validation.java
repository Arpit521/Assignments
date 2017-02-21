package com.example.arpit.assignment1.First;


import java.util.regex.Pattern;

/**
 * Created by arpit on 20/1/17.
 */

public class Validation {

    private static Validation validate=new Validation();
    private static String TAG = Validation.class.getSimpleName();
    Pattern name= Pattern.compile("[a-zA-Z]{3,15}");
    Pattern PAN= Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]");
    Pattern servicetax=Pattern.compile("[A-Z]{5}+[0-9]{4}+[A-Z]+[S]+[D|T]+[0-9]{3}");
    Pattern Address=Pattern.compile("[a-zA-Z0-9 ]+");


    private Validation()
    {

    }

    public  static Validation getInstance()
    {
        return validate;
    }


    /* Validate Company Name */
    public boolean companyname(String CompanyName)
    {
       if(CompanyName.matches(String.valueOf(name)))
           return true;
        else
           return false;
    }

    public boolean TINnumber(String tin)
    {
        if (tin.length() < 11)
            return false;
        else
            return true;

    }

    public boolean CompanyPan(String pan)
    {

        if (!pan.matches(String.valueOf(PAN)))
            return false;
        else
            return true;
    }

    public boolean servicetax(String stn)
    {
        if (!stn.matches(String.valueOf(servicetax)))
            return false;
        else
            return true;
    }

    public boolean Proprieter(String Proname)
    {
         if (!Proname.matches(String.valueOf(name)))
             return false;
         else
             return true;

    }

    public boolean Address(String address)
    {
         if (!address.matches(String.valueOf(Address)))
             return false;
        else
             return true;
    }

    public boolean pincode(String pin)
    {
        if (pin.length()<6)
            return false;
        else
            return true;

    }
    public boolean Representive(String Rname)
    {
        if(!Rname.matches(String.valueOf(name)))
            return false;
        else
            return true;

    }

    public boolean Fname(String fname)
    {
        if(fname.matches(String.valueOf(name)))
            return true;
        else
            return false;
    }

    public boolean Lname(String lname)
    {
        if(lname.matches(String.valueOf(name)))
            return true;
        else
            return false;
    }
    public boolean mobile(String number)
    {
        if (number.length()<10)
            return false;
        else
            return true;

    }

}
