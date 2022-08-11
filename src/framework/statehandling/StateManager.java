package framework.statehandling;

import framework.Engine;
import framework.eventhandling.Connector;
import framework.eventhandling.Event;
import game.states.DevState;
import game.states.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.EmptyStackException;
import java.util.Stack;

public class StateManager {
    private static final int MOUSE_BUTTON_L = 1;
    private static final int MOUSE_BUTTON_R = 3;

    private Stack<State> states;
    private Connector connector;

    public StateManager() {
        states = new Stack<State>();
        connector = new Connector(Engine.X,Engine.Y);
        states.add(new DevState(connector));
//		states.add(new MenuState(connector));
    }
    public int[] render(){
        int[] p = new int[Engine.X*Engine.Y];
        try {
            p =  this.states.peek().render();
        } catch(EmptyStackException e) {
            e.printStackTrace();
        }
        return p;
    }
    public void update() {
        this.states.peek().update();
    }
    public boolean hasSprite() {
        return this.states.peek().hasSprite();
    }

    public void mouseClicked(MouseEvent e) {
        Event event = new Event();

        if(e.getButton()== MOUSE_BUTTON_L) {
            event = this.connector.getEvent(e);
        }

        if(event!=null && event.getEventId()!=null) {
            if(event.getEventId().equals("game")) {
                this.states.add(new GameState(this.connector));
                return;
            }
            this.states.peek().mouseClicked(event);
            while(this.connector.firedEvent!=null) {
                Event firedEvent = this.connector.firedEvent;
                this.connector.firedEvent=null;
                this.states.peek().mouseClicked(firedEvent);
            }
        }
    }
    public void keyPressed(KeyEvent e) {
        this.states.peek().keyPressed(e);
    }

}
