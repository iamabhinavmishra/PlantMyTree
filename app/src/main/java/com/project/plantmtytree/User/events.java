package com.project.plantmtytree.User;

public class events {
    String EventId,EventName,EventHandler;

    public events() {

    }

    public events(String eventId, String eventName, String eventHandler) {
        EventId = eventId;
        EventName = eventName;
        EventHandler = eventHandler;
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

    public String getEventHandler() {
        return EventHandler;
    }

    public void setEventHandler(String eventHandler) {
        EventHandler = eventHandler;
    }
}
