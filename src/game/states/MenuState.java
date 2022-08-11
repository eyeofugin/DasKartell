package game.states;

import framework.Engine;
import framework.eventhandling.Connector;
import framework.eventhandling.Event;
import framework.graphics.containers.VerticalOptionSelection;
import framework.graphics.text.MyColor;
import framework.statehandling.State;

import java.awt.event.KeyEvent;

public class MenuState extends State {

    private static int MENU_HEIGHT = 350;
    private static int MENU_WIDTH = 250;

    private static String WELCOME_STRING = "Welcome to Rogues";private static int W_SIZE = 240;
    private static String START_STRING = "Start";private static int S_SIZE = 100;
    private static String EXIT_STRING = "Exit";private static int E_SIZE = 100;

    private VerticalOptionSelection menu;
    private int menuX,menuY;

    public MenuState(Connector connector) {
        super(connector);
        calcstartpointofmenu();
        this.menu = setupmenu();
    }
    @Override
    protected void update() {
    }
    @Override
    protected int[] render() {
        int[] pixels = new int[Engine.X*Engine.Y];
        paintBlack(pixels);

        int[] menuPixels = menu.build();

        int menuindex = 0;
        for(int i = menuY; i < menuY + MENU_HEIGHT; i++) {
            for(int j = menuX; j < menuX + MENU_WIDTH; j++) {
                pixels[j+i*Engine.X] = menuPixels[menuindex];
                menuindex++;
            }
        }
        return pixels;
    }
    private void calcstartpointofmenu() {
        menuX = (Engine.X-MENU_WIDTH) / 2;
        menuY = (Engine.Y-MENU_HEIGHT) / 2;
    }
    private VerticalOptionSelection setupmenu() {
        VerticalOptionSelection menu = new VerticalOptionSelection(MENU_WIDTH, MENU_HEIGHT, menuX, menuY, this.connector);
        menu.addEntry(WELCOME_STRING, null);
        menu.addEntry(START_STRING, new Event("game"));
        menu.addEntry(EXIT_STRING, new Event("exit"));
        menu.setSizes(new int[] {W_SIZE,S_SIZE,E_SIZE});
        return menu;
    }
    private void paintBlack(int[] pixels) {
        for(int i = 0; i < 1080; i++) {
            for(int j = 420; j < 1500; j++) {
                pixels[j+i*1920] = MyColor.BLACK.VALUE;
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