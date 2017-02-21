package com.example.arpit.assignment1.UpdateAddress;

import java.io.Serializable;

/**
 * Created by arpit on 23/1/17.
 */

public class Customer implements Serializable {

    private String Fname,Lname,Add1,Add2,State,City,Country,addrestype;
    private String mobile,pincode;

    public Customer()
    {

    }

    public Customer(String Fname, String Lname, String Add1, String Add2, String mobile, String state,String city,String country,String pincode,String addresstype)
    {
        this.Fname=Fname;
        this.Lname=Lname;
        this.Add1=Add1;
        this.Add2=Add2;
        this.mobile=mobile;
        this.State=state;
       this.City=city;
        this.Country=country;
        this.pincode=pincode;
        this.addrestype=addresstype;


    }
    public String getfname() {
        return Fname;
    }

    public void setfname(String fname) {
        this.Fname = fname;
    }

    public String getlname() {
        return Lname;
    }

    public void setlname(String lname) {
        this.Lname = lname;
    }

    public String getAdd1() {
        return Add1;
    }

    public void setAdd1(String Add1) {
        this.Add1 = Add1;
    }

    public String getAdd2() {return Add2;}

    public void setAdd2(String Add2) {this.Add2=Add2;}

    public String getmobile(){return mobile;}

    public void setmobile(String mobile){this.mobile=mobile;}

    public String getstate(){return State;}

    public void setState(String state){this.State=state;}

    public String getcity(){return City;}

    public void setcity(String city){this.City=city;}

    public String getcountry(){return Country;}

    public void setCountry(String country){this.Country=country;}

    public String getaddtype(){return addrestype;}

    public void setaddtype(String addtype){this.addrestype=addtype;}


    public String getpin(){return pincode;}

    public void setpin(String pincode){this.pincode=pincode;}


}
