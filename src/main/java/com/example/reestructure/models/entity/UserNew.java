package com.example.reestructure.models.entity;

public class UserNew {

    /*private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }*/

    /** VARIABLES **/
    private int id;
    private String last_name;
    private String email;

    /** METODOS **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
