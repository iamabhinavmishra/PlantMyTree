package com.project.plantmtytree.LocationOwner;

public class orders {
    String OrderId,PlantName,Name;

    public orders() {

    }

    public orders(String orderId, String plantName, String name) {
        OrderId = orderId;
        PlantName = plantName;
        Name = name;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getPlantName() {
        return PlantName;
    }

    public void setPlantName(String plantName) {
        PlantName = plantName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
