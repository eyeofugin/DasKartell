package framework.graphics.containers;

import framework.eventhandling.Connector;
import framework.graphics.base.BaseGraphical;
import framework.graphics.text.MyColor;
import framework.graphics.text.TextAlignment;
import framework.loading.SpriteManager;
import game.objects.units.Entity;

public class CharacterFieldView extends BaseGraphical {

    public static int NORMAL_WIDTH = 170;
    public static int NORMAL_HEIGHT = 170;

    private static int HEALTH_BAR_Y = 5;
    private static int MANA_BAR_Y =   15;
    private static int BARS_X_FROM =  5;
    private static int BARS_X_UNTIL = 165;
    private static int BAR_HEIGHT =   10;
    private static int PICTURE_X = 21;
    private static int PICTURE_Y = 42;
    private static int PICTURE_SIZE = 128;


    private Entity entity;

    public CharacterFieldView(Entity e, int xanchor, int yanchor, Connector connector) {
        super(NORMAL_WIDTH,NORMAL_HEIGHT,xanchor,yanchor,connector);
        this.entity = e;
    }
    public int[] build() {
        background(MyColor.VOID);
        bars();
        picture();
        border(MyColor.DARKGREY);
        return this.pixels;
    }
    private void bars() {
        healthBar();
        manaBar();
    }
    private void healthBar() {
        writeBar(BARS_X_FROM,BARS_X_UNTIL,HEALTH_BAR_Y,HEALTH_BAR_Y+BAR_HEIGHT,
                this.entity.getCurrentResourcePercentage("life"),MyColor.DARKGREEN);
        writeLineFromTo(this.entity.getCurrentResourceString("life"),
                BARS_X_FROM,BARS_X_UNTIL,HEALTH_BAR_Y,HEALTH_BAR_Y+BAR_HEIGHT-1,
                1, TextAlignment.CENTER, MyColor.VOID, MyColor.WHITE);
    }
    private void manaBar() {
        writeBar(BARS_X_FROM,BARS_X_UNTIL,MANA_BAR_Y,MANA_BAR_Y+BAR_HEIGHT,
                this.entity.getCurrentResourcePercentage("mana"),MyColor.BLUE);
        writeLineFromTo(this.entity.getCurrentResourceString("mana"),
                BARS_X_FROM,BARS_X_UNTIL,MANA_BAR_Y,MANA_BAR_Y+BAR_HEIGHT,
                1, TextAlignment.CENTER, MyColor.VOID, MyColor.WHITE);
    }
    private void picture() {
        int xu = PICTURE_X + PICTURE_SIZE -1;
        int yu = PICTURE_Y + PICTURE_SIZE -1;
        fillWithGraphics(PICTURE_X,xu,PICTURE_Y,yu, SpriteManager.charSprites.get(this.entity.getId()).forMult(4),
                false,MyColor.VOID);
    }
}