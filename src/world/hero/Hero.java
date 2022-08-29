package world.hero;

import world.consts.Consts;
import world.GameUnit;

public class Hero extends GameUnit {
    private String name;
    private int currentLevel = 0;
    private int exp = 0;
    private int gold = 0;

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    /*уровень по опыту 100, 200, 400, 800, 1600 ...*/
    private int getLevel() {
        int levelExp = 100;
        int level = 1;
        while(exp>=levelExp){
            levelExp *= 2;
            level += 1;
        }
        return level;
    }

    @Override
    public String toString() {
        return "%s (%dhp)".formatted(name, (int)health);
    }

    public String toStringFull() {
        if (!isAlive()) {
            return name + " is dead";
        }
        return "%s (%dhp %dag %dst %dgold %dlevel %dexp)".formatted(name, (int)health, (int)agility, (int)strength,
                gold, currentLevel, exp);
    }

    public Hero(String name) {
        this.name = name;
        /**/
        genHealth(Consts.Hero.HeroDefHealth);
        genAgility(Consts.Hero.HeroDefAgility);
        genStrength(Consts.Hero.HeroDefStrength);
    }

    public void checkLevel(){
        /**/
        final var level = getLevel();
        if (currentLevel == level){
            return;
        }
        currentLevel = level;
        final float healthKff = level * Consts.Hero.KffByLevel_Health;
        final float agilityKff = level * Consts.Hero.KffByLevel_Agility;
        final float strengthKff = level * Consts.Hero.KffByLevel_Strength;
        health += health * healthKff;
        agility += agility * agilityKff;
        strength += strength * strengthKff;
    }
}
