package framework.eventhandling;

public class Event {
    private String eventId;

    public Event() {

    }
    public Event(String eventid) {
        this.eventId = eventid;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

}
