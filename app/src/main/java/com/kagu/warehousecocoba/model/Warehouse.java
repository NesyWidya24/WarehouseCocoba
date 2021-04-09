package com.kagu.warehousecocoba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Warehouse {
    @Expose
    @SerializedName("id") private int id;
    @Expose
    @SerializedName("codeWarehouse") private String codeWarehouse;
    @Expose
    @SerializedName("codeItem") private String codeItem;
    @Expose
    @SerializedName("nameItem") private String nameItem;
    @Expose
    @SerializedName("typeOfItem") private String typeOfItem;
    @Expose
    @SerializedName("totalItems") private String totalItems;
    @Expose
    @SerializedName("unit") private String unit;
    @Expose
    @SerializedName("success") private Boolean success;
    @Expose
    @SerializedName("message") private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeWarehouse() {
        return codeWarehouse;
    }

    public void setCodeWarehouse(String codeWarehouse) {
        this.codeWarehouse = codeWarehouse;
    }

    public String getCodeItem() {
        return codeItem;
    }

    public void setCodeItem(String codeItem) {
        this.codeItem = codeItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(String typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
