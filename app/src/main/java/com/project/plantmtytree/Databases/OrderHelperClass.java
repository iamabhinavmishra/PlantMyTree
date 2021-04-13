package com.project.plantmtytree.Databases;

public class OrderHelperClass {
    String OrderId,EventId,EventName,PlantName,PlantPrice,Name,Phone;

    public OrderHelperClass() {

    }

    public OrderHelperClass(String orderId, String eventId, String eventName, String plantName, String plantPrice, String name, String phone) {
        OrderId = orderId;
        EventId = eventId;
        EventName = eventName;
        PlantName = plantName;
        PlantPrice = plantPrice;
        Name = name;
        Phone = phone;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getEventId() {
        return EventId;
    }

    public void setEventId(String eventId) {
        EventId = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getPlantName() {
        return PlantName;
    }

    public void setPlantName(String plantName) {
        PlantName = plantName;
    }

    public String getPlantPrice() {
        return PlantPrice;
    }

    public void setPlantPrice(String plantPrice) {
        PlantPrice = plantPrice;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
