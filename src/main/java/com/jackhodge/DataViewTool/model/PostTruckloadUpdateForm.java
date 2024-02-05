package com.jackhodge.DataViewTool.model;


import java.util.Objects;

public class PostTruckloadUpdateForm {

    public String selectUpdateMethod;
    public String deleteby;
    public String source;
    public String destination;
    public Long carrierid;

    private boolean valid;

    public PostTruckloadUpdateForm() {
    }

    public String getSelectUpdateMethod() {
        return selectUpdateMethod;
    }

    public String getDeleteby() {
        return deleteby;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }


    public Long getCarrierid() {
        return carrierid;
    }

    public void setSelectUpdateMethod(String selectUpdateMethod) {
        this.selectUpdateMethod = selectUpdateMethod;
    }

    public void setDeleteby(String deleteby) {
        this.deleteby = deleteby;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public void setCarrierid(Long carrierid) {
        this.carrierid = carrierid;
    }


    public boolean isValid(){
        // TODO: Make not dumb
        if(Objects.equals(selectUpdateMethod, "insert")) {
            return (selectUpdateMethod != null) && (deleteby != null) && (source != null) && (destination != null) && (carrierid != null);
        } else {
            return (selectUpdateMethod != null) && ((deleteby != null) || (source != null) || (destination != null) || (carrierid != null));
        }
    }

    @Override
    public String toString() {
        return "PostTruckloadUpdateForm{" +
                "selectupdatemethod='" + selectUpdateMethod + '\'' +
                ", deleteby='" + deleteby + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
