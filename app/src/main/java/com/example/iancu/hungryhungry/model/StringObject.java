package com.example.iancu.hungryhungry.model;

import io.realm.RealmObject;

public class StringObject extends RealmObject {
    private String string;
    public StringObject(){}
    public StringObject(String s){
        string=s;
    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
