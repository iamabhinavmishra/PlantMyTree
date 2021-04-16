package com.project.plantmtytree.User;

public class locations {
    String OrderId,PlantId,Address1,Address2,Address3,PinCode,UpdatedBy;

    public locations() {

    }

    public locations(String orderId, String plantId, String address1, String address2, String address3, String pinCode, String updatedBy) {
        OrderId = orderId;
        PlantId = plantId;
        Address1 = address1;
        Address2 = address2;
        Address3 = address3;
        PinCode = pinCode;
        UpdatedBy = updatedBy;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getPlantId() {
        return PlantId;
    }

    public void setPlantId(String plantId) {
        PlantId = plantId;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getAddress3() {
        return Address3;
    }

    public void setAddress3(String address3) {
        Address3 = address3;
    }

    public String getPinCode() {
        return PinCode;
    }

    public void setPinCode(String pinCode) {
        PinCode = pinCode;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        UpdatedBy = updatedBy;
    }
}
