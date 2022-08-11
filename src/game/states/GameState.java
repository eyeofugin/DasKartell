package game.states;

import framework.Engine;
import framework.eventhandling.Connector;
import framework.eventhandling.Event;
import framework.graphics.text.MyColor;
import framework.statehandling.State;

import java.awt.event.KeyEvent;

public class GameState extends State {



    public GameState(Connector connector) {
        super(connector);
    }
    @Override
    protected void update() {
    }
    @Override
    protected int[] render() {
        int[] pixels = new int[Engine.X*Engine.Y];
        blue(pixels);
        return pixels;
    }

    private void blue(int[] p) {
        for(int i = 0; i < 1080; i++) {
            for(int j = 0; j < 1920; j++) {
                p[j+i*1920] = MyColor.BLUE.VALUE;
            }
        }
    }


    @Override
    protected boolean hasSprite() {
        return false;
    }
    @Override
    protected void mouseClicked(Event e) {
    }
    @Override
    protected void keyPressed(KeyEvent e) {
    }
}
