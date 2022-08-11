package framework.statehandling;

import framework.eventhandling.Connector;
import framework.eventhandling.Event;

import java.awt.event.KeyEvent;

public abstract class State {
    protected Connector connector;

    protected abstract void update();
    protected abstract int[] render();
    protected abstract boolean hasSprite();
    protected abstract void mouseClicked(Event e);
    protected abstract void keyPressed(KeyEvent e);

    public State(Connector connector) {
        this.connector = connector;
    }

}
