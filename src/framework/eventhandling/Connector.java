package framework.eventhandling;

import java.awt.event.MouseEvent;

public class Connector {
    private int x,y;
    public Event firedEvent;
    protected Event[][] eventMatrix;

    public Connector(int x, int y) {
        this.x=x;this.y=y;
        this.eventMatrix = new Event[x][y];
    }
    public void fire(Event e) {
        firedEvent=e;
    }


    public void addEventFromTo(Event event, int xFrom, int xUntil, int yFrom, int yUntil) {
        for(int y = yFrom; y <= yUntil; y++) {
            for(int x = xFrom; x <= xUntil; x++) {
                this.eventMatrix[x][y] = event;
            }
        }
    }
    public void addEventSize(Event event, int xfrom, int yfrom, int width, int height) {
        for(int y = yfrom; y <= yfrom+height-1; y++) {
            for(int x = xfrom; x <= xfrom+width-1; x++) {
                this.eventMatrix[x][y] = event;
            }
        }
    }
    public void removeEvent(String eventId) {
        for(int x = 0; x < this.eventMatrix.length; x++) {
            for(int y = 0; y < this.eventMatrix[0].length; y++) {
                if(this.eventMatrix[x][y].getEventId().equals(eventId)) {
                    this.eventMatrix[x][y] = null;
                }
            }
        }
    }
    public void removeAll() {
        for(int x = 0; x < this.eventMatrix.length; x++) {
            for(int y = 0; y < this.eventMatrix[0].length; y++) {
                this.eventMatrix[x][y] = null;
            }
        }
    }
    public void removeEvents(int xFrom, int xUntil, int yFrom, int yUntil) {
        for(int y = yFrom; y <= yUntil; y++) {
            for(int x = xFrom; x <= xUntil; x++) {
                this.eventMatrix[x][y] = null;
            }
        }
    }

    public Event[][] getEvents() {
        return this.eventMatrix;
    }
    public Event getEvent(MouseEvent e) {
        if(e.getX() < 0 || e.getX() > this.x || e.getY()<0 || e.getY() > this.y ) {
            return null;
        }
        return this.eventMatrix[e.getX()][e.getY()];
    }
}
