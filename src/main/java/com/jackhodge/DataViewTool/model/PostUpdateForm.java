package com.jackhodge.DataViewTool.model;

public class PostUpdateForm {
    public String selectupdatemethod;
    public String deleteby;

    public String firstName;

    public String lastName;


    public String getSelectupdatemethod() {
        return selectupdatemethod;
    }

    public String getDeleteby() {
        return deleteby;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSelectupdatemethod(String selectupdatemethod) {
        this.selectupdatemethod = selectupdatemethod;
    }

    public void setDeleteby(String deleteby) {
        this.deleteby = deleteby;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PostUpdateForm{" +
                "selectupdatemethod='" + selectupdatemethod + '\'' +
                ", deleteby='" + deleteby + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
