package game.objects.units.individuals;

import framework.loading.SpriteManager;
import game.objects.units.Entity;

public class Dummy extends Entity {

    public Dummy() {
        super(SpriteManager.DUMMY,"Dummy");
        this.maxLife = 20;
        this.currentLife=20;
        this.maxMana = 20;
        this.currentMana = 20;
    }
}