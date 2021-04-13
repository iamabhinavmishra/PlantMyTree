package com.project.plantmtytree.Databases;

public class EventHandlerClass {
    String EventId,EventName,EventDesc,EventLocation,EventHandler,EventPhone;

    public EventHandlerClass() {

    }

    public EventHandlerClass(String eventId, String eventName, String eventDesc, String eventLocation, String eventHandler, String eventPhone) {
        EventId = eventId;
        EventName = eventName;
        EventDesc = eventDesc;
        EventLocation = eventLocation;
        EventHandler = eventHandler;
        EventPhone = eventPhone;
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

    public String getEventDesc() {
        return EventDesc;
    }

    public void setEventDesc(String eventDesc) {
        EventDesc = eventDesc;
    }

    public String getEventLocation() {
        return EventLocation;
    }

    public void setEventLocation(String eventLocation) {
        EventLocation = eventLocation;
    }

    public String getEventHandler() {
        return EventHandler;
    }

    public void setEventHandler(String eventHandler) {
        EventHandler = eventHandler;
    }

    public String getEventPhone() {
        return EventPhone;
    }

    public void setEventPhone(String eventPhone) {
        EventPhone = eventPhone;
    }
}
