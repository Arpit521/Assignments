package com.example.arpit.assignment1.DatabaseSQLite;

/**
 * Created by arpit on 21/2/17.
 */

public class Contact {

    int _id;
    String _name;
    String _phone_number;
    public Contact(){}

    public Contact(int id, String name, String number)
    {
        this._id=id;
        this._name=name;
        this._phone_number=number;
    }

    public Contact(String name, String number)
    {
        this._name=name;
        this._phone_number=number;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return this._name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_phone_number() {
        return this._phone_number;
    }

    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }





}
