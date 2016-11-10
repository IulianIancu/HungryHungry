package com.example.iancu.hungryhungry.model;

import io.realm.RealmObject;

/**
 * Created by Iancu on 10/11/2016.
 */

public class LoginUser extends RealmObject {
    private String fName;
    private String lName;
    private String email;
    private String dob;
    private String password;
    private boolean peanuts;
    private boolean chocolate;
    private boolean dairy;
    private boolean wheat;
    private boolean tuna;

    public LoginUser(){}

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPeanuts() {
        return peanuts;
    }

    public void setPeanuts(boolean peanuts) {
        this.peanuts = peanuts;
    }

    public boolean isChocolate() {
        return chocolate;
    }

    public void setChocolate(boolean chocolate) {
        this.chocolate = chocolate;
    }

    public boolean isDairy() {
        return dairy;
    }

    public void setDairy(boolean dairy) {
        this.dairy = dairy;
    }

    public boolean isWheat() {
        return wheat;
    }

    public void setWheat(boolean wheat) {
        this.wheat = wheat;
    }

    public boolean isTuna() {
        return tuna;
    }

    public void setTuna(boolean tuna) {
        this.tuna = tuna;
    }
}
