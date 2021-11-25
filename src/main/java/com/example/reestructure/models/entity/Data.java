package com.example.reestructure.models.entity;

import java.util.LinkedList;

public class Data {

    /**
     * VARIABLES
     **/
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private LinkedList<User> user;
    private Object support;

    /**
     * METODOS
     * */
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public LinkedList<User> getData() {
        return user;
    }

    public void setData(LinkedList<User> user) {
        this.user = user;
    }

    public Object getSupport() {
        return support;
    }

    public void setSupport(Object support) {
        this.support = support;
    }
}




