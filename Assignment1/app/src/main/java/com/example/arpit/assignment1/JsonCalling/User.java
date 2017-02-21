package com.example.arpit.assignment1.JsonCalling;

import android.provider.ContactsContract;

/**
 * Created by arpit on 8/2/17.
 */

public class User {

    private String name;
    private String email;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }
}
