package framework.loading;

import framework.graphics.sprites.Sprite;

public class Loader {
    public static void load() {
        SpriteManager.charSprites.put(SpriteManager.DUMMY,new Sprite("res/characters/batman.png",SpriteManager.SIZE,SpriteManager.SIZE));
    }
}
