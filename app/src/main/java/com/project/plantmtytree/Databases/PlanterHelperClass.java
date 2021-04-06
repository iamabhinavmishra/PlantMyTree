package com.project.plantmtytree.Databases;

import com.google.android.material.textfield.TextInputLayout;

public class PlanterHelperClass {
    String fullName, email, phoneNo, password;

    public PlanterHelperClass(TextInputLayout fullName, TextInputLayout email, TextInputLayout phoneNo, TextInputLayout password) {

    }

    public PlanterHelperClass(String fullName, String email, String phoneNo, String password) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
