package com.example.appdulichao.model;

public class Typeaccess {
    public int typeaccess_id;
    public String typeaccess_name;
    public String typeaccess_img;

    public Typeaccess(int typeaccess_id, String typeaccess_name, String typeaccess_img) {
        this.typeaccess_id = typeaccess_id;
        this.typeaccess_name = typeaccess_name;
        this.typeaccess_img = typeaccess_img;
    }

    public int getTypeaccess_id() {
        return typeaccess_id;
    }

    public void setTypeaccess_id(int typeaccess_id) {
        this.typeaccess_id = typeaccess_id;
    }

    public String getTypeaccess_name() {
        return typeaccess_name;
    }

    public void setTypeaccess_name(String typeaccess_name) {
        this.typeaccess_name = typeaccess_name;
    }

    public String getTypeaccess_img() {
        return typeaccess_img;
    }

    public void setTypeaccess_img(String typeaccess_img) {
        this.typeaccess_img = typeaccess_img;
    }
}
