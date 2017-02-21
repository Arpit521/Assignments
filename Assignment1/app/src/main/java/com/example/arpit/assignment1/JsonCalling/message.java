package com.example.arpit.assignment1.JsonCalling;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by arpit on 15/2/17.
 */

public class message {

    public String getImagePrefixURL() {
        return imagePrefixURL;
    }

    public void setImagePrefixURL(String imagePrefixURL) {
        this.imagePrefixURL = imagePrefixURL;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }



    public com.example.arpit.assignment1.JsonCalling.filters[] getFilters() {
        return filters;
    }

    public void setFilters(com.example.arpit.assignment1.JsonCalling.filters[] filters) {
        this.filters = filters;
    }



    public List<com.example.arpit.assignment1.JsonCalling.products> getProducts() {
        return products;
    }

    public void setProducts(List<com.example.arpit.assignment1.JsonCalling.products> products) {
        this.products = products;
    }

    public List<products> products;
    public filters[] filters;

    int totalCount;
    int totalPages;
    String imagePrefixURL;

   /* public void setproducts(products[] product)
    {
        this.product=product;
    }
    public products[] getproducts()
    {
        return product;
    }

    public void setFilter(filters[] filter)
    {
        this.filter=filter;
    }
    public filters[] getFilter()
    {
        return filter;
    }*/


}
