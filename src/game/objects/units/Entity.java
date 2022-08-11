package game.objects.units;

import game.objects.skills.Effect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entity {
    private static int counter=0;
    protected int unique;
    protected int id;
    protected String name="";
    protected int team;
    protected boolean isPlayable;

    //Skills
    //Equipments
    //Colors

    protected int level=1;

    //STATS
    protected int maxLife,currentLife,lifeRegain;
    protected int maxMana,currentMana,manaRegain;
    protected int maxActions,currentActions;
    protected int range;
    protected double critChance;
    protected int initiaive;
    protected int threat;

    protected List<Effect> currentEffects = new ArrayList<>();
    protected Map<Proficiency,Integer> proficiencies = new HashMap<>();

    public static enum Proficiency{
        PRECISION("Precision"),
        STRENGTH("Strength"),
        KNOWLEDGE("Knowledge"),
        FAITH("Faith"),
        LETHALITY("Lethality");
        private final String value;
        private Proficiency(String s) {
            this.value = s;
        }
        public String value() {
            return this.value;
        }
    }
    public Entity(int id, String name) {
        this.unique=counter++;
        this.id = id;
        this.name=name;
    }

    public Entity(int id, String name, int team, int level, int maxLife, int currentLife, int lifeRegain, int maxMana,
                  int currentMana, int manaRegain, int maxActions, int currentActions, int range, double critChance,
                  int initiaive, int threat, List<Effect> currentEffects, Map<Proficiency, Integer> proficiencies) {
        super();
        this.id = id;
        this.name = name;
        this.team = team;
        this.level = level;
        this.maxLife = maxLife;
        this.currentLife = currentLife;
        this.lifeRegain = lifeRegain;
        this.maxMana = maxMana;
        this.currentMana = currentMana;
        this.manaRegain = manaRegain;
        this.maxActions = maxActions;
        this.currentActions = currentActions;
        this.range = range;
        this.critChance = critChance;
        this.initiaive = initiaive;
        this.threat = threat;
        this.currentEffects = currentEffects;
        this.proficiencies = proficiencies;
    }


    //Special getters and setters

    public double getCurrentResourcePercentage(String resource) {
        switch(resource) {
            case "life":
                return (double)this.currentLife / this.maxLife;
            case "mana":
                return (double)this.currentMana / this.maxMana;
            case "action":
                return (double)this.currentActions / this.maxActions;
            default:
                return 0.0;
        }
    }
    public String getCurrentResourceString(String resource) {
        switch(resource) {
            case "life":
                return this.currentLife + " / " + this.maxLife;
            case "mana":
                return this.currentMana + " / " + this.maxMana;
            default:
                return "";
        }
    }


    //generic getters and setters



    public int getUnique() {
        return unique;
    }
    public void setUnique(int unique) {
        this.unique = unique;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getTeam() {
        return team;
    }
    public void setTeam(int team) {
        this.team = team;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getMaxLife() {
        return maxLife;
    }
    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }
    public int getCurrentLife() {
        return currentLife;
    }
    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }
    public int getLifeRegain() {
        return lifeRegain;
    }
    public void setLifeRegain(int lifeRegain) {
        this.lifeRegain = lifeRegain;
    }
    public int getMaxMana() {
        return maxMana;
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    public int getCurrentMana() {
        return currentMana;
    }
    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }
    public int getManaRegain() {
        return manaRegain;
    }
    public void setManaRegain(int manaRegain) {
        this.manaRegain = manaRegain;
    }
    public int getMaxActions() {
        return maxActions;
    }
    public void setMaxActions(int maxActions) {
        this.maxActions = maxActions;
    }
    public int getCurrentActions() {
        return currentActions;
    }
    public void setCurrentActions(int currentActions) {
        this.currentActions = currentActions;
    }
    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
    }
    public double getCritChance() {
        return critChance;
    }
    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }
    public int getInitiaive() {
        return initiaive;
    }
    public void setInitiaive(int initiaive) {
        this.initiaive = initiaive;
    }
    public int getThreat() {
        return threat;
    }
    public void setThreat(int threat) {
        this.threat = threat;
    }
    public List<Effect> getCurrentEffects() {
        return currentEffects;
    }
    public void setCurrentEffects(List<Effect> currentEffects) {
        this.currentEffects = currentEffects;
    }
    public Map<Proficiency, Integer> getProficiencies() {
        return proficiencies;
    }
    public void setProficiencies(Map<Proficiency, Integer> proficiencies) {
        this.proficiencies = proficiencies;
    }
    public boolean isPlayable() {
        return isPlayable;
    }
    public void setPlayable(boolean isPlayable) {
        this.isPlayable = isPlayable;
    }

}
