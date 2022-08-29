package hero;

import world.Consts;
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
        return "%s (%dhp %dag %dst %dgold %dexp)".formatted(name, (int)health, (int)agility, (int)strength,
                gold, exp);
    }

    public Hero(String name) {
        this.name = name;
        /**/
        this.setStats();
    }

    public void setStats(){
        /**/
        final var level = getLevel();
        if (currentLevel == level){
            return;
        }
        currentLevel = level;
        System.out.println("exp = %d, level = %d".formatted(exp, level));
        final float healthKff = 1 + (level-1) * Consts.Hero.KffByLevel_Health;
        final float agilityKff = 1 + (level-1) * Consts.Hero.KffByLevel_Agility;
        final float strengthKff = 1 + (level-1) * Consts.Hero.KffByLevel_Strength;
        /**/
        genHealth(Consts.Hero.HeroDefHealth);
        genAgility(Consts.Hero.HeroDefAgility);
        genStrength(Consts.Hero.HeroDefStrength);
    }
}
