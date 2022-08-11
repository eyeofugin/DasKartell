package game.combat;

public enum DamageType {
    NORMAL("Normal"),
    BURNING("Burning"),
    FREEZING("Freezing"),
    DARK("Dark"),
    LIGHT("Light"),
    MAGICAL("Magical"),
    SHOCK("Shock"),
    HEAL("Heal");
    private String value;
    private DamageType(String s) {
        this.value=s;
    }
    public String value() {
        return this.value;
    }

}
