package framework;

import framework.graphics.WindowManager;
import framework.statehandling.StateManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Engine {
    private static WindowManager windowManager;
    private static StateManager stateManager;
    public static final int X = 1920;
    public static final int Y = 1080;
    public static int turn=0;


    public static void init() {
        stateManager = new StateManager();
        windowManager = new WindowManager();
        windowManager.addMouse(new Mouse());
        windowManager.addKey(new KeyBoard());
        windowManager.start();
        loop();
    }
    private static void loop() {
        update();
        render();
    }
    private static void update() {
        stateManager.update();
    }
    private static void render() {
        windowManager.render(stateManager.render());
    }
    private static class Mouse implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {
            turn++;
            stateManager.mouseClicked(e);
            loop();
        }
        @Override
        public void mousePressed(MouseEvent e) { }
        @Override
        public void mouseReleased(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) { }
    }

    private static class KeyBoard implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                windowManager.dispose();
            }else {
                stateManager.keyPressed(e);
            }
            loop();

        }
        @Override
        public void keyReleased(KeyEvent e) {}

    }
}
