package com.jackhodge.DataViewTool.model;

public class PostTruckloadUpdateForm {
    public String selectupdatemethod;
    public String deleteby;

    public String source;

    public String destination;

    public Long carrierid;


    public String getSelectupdatemethod() {
        return selectupdatemethod;
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

    public void setSelectupdatemethod(String selectupdatemethod) {
        this.selectupdatemethod = selectupdatemethod;
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

    @Override
    public String toString() {
        return "PostTruckloadUpdateForm{" +
                "selectupdatemethod='" + selectupdatemethod + '\'' +
                ", deleteby='" + deleteby + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
