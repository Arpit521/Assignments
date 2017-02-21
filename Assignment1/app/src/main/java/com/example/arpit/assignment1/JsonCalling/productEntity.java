package com.example.arpit.assignment1.JsonCalling;

/**
 * Created by arpit on 15/2/17.
 */

public class productEntity {

    public String getSearchURL() {
        return searchURL;
    }

    public void setSearchURL(String searchURL) {
        this.searchURL = searchURL;
    }

    public String searchURL;

    public com.example.arpit.assignment1.JsonCalling.identifier getIdentifier() {
        return identifier;
    }

    public void setIdentifier(com.example.arpit.assignment1.JsonCalling.identifier identifier) {
        this.identifier = identifier;
    }

    public com.example.arpit.assignment1.JsonCalling.basicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(com.example.arpit.assignment1.JsonCalling.basicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public com.example.arpit.assignment1.JsonCalling.merchandiseInfo getMerchandiseInfo() {
        return merchandiseInfo;
    }

    public void setMerchandiseInfo(com.example.arpit.assignment1.JsonCalling.merchandiseInfo merchandiseInfo) {
        this.merchandiseInfo = merchandiseInfo;
    }

    public identifier identifier;
    public basicInfo basicInfo;
    public merchandiseInfo merchandiseInfo;
}
