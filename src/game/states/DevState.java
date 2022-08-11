package game.states;

import framework.Engine;
import framework.eventhandling.Connector;
import framework.eventhandling.Event;
import framework.graphics.containers.Board;
import framework.graphics.containers.CharacterFieldView;
import framework.graphics.containers.VerticalOptionSelection;
import framework.statehandling.State;
import game.objects.units.Entity;
import game.objects.units.individuals.Dummy;

import java.awt.event.KeyEvent;

public class DevState extends State {

    public DevState(Connector connector) {
        super(connector);
    }

    @Override
    protected void update() {
    }

    @Override
    protected int[] render() {
        int[] pixels = new int[Engine.X*Engine.Y];

//        CharacterFieldView fw = new CharacterFieldView(new Dummy(0,"Dummy"),100,100, connector);
//        int[] fwPixels = fw.build();
//
//        int fwindex = 0;
//        for(int i = 40; i < 210; i++) {
//            for(int j = 40; j < 210; j++) {
//                pixels[j+i*1920] = fwPixels[fwindex];
//                fwindex++;
//            }
//        }
//
//        VerticalOptionSelection vos = new VerticalOptionSelection(400,300,1000,300,this.connector);
//        vos.addEntry("option 1" , new Event());
//        int[] vosPixels = vos.build();
//
//        int vosindex = 0;
//        for(int i = 300; i < 600; i++) {
//            for(int j = 1000; j < 1400; j++) {
//                pixels[j+i*1920] = vosPixels[vosindex];
//                vosindex++;
//            }
//        }
        Entity[][] es = new Entity[][]{
                {new Dummy(),new Dummy(),new Dummy(),new Dummy()},
                {new Dummy(),new Dummy(),new Dummy(),new Dummy()},
                {new Dummy(),new Dummy(),new Dummy(),new Dummy()},
                {new Dummy(),new Dummy(),new Dummy(),new Dummy()}
        };
        Board b = new Board(es,20,20,this.connector);

        int[] bp = b.build();
        int bindex =0;
        for(int i = 300; i < 600; i++) {
            for(int j = 1000; j < 1400; j++) {
                pixels[j+i*1920] = bp[bindex];
                bindex++;
            }
        }

        return pixels;
    }

    @Override
    protected boolean hasSprite() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void mouseClicked(Event e) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}