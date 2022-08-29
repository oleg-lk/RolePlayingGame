package world.monster;

import world.consts.Consts;
import world.GameUnit;

public abstract class Monster extends GameUnit {
    protected String monsterName;
    protected int index;
    protected int gold;
    protected int exp;

    public int getGold() {
        return gold;
    }

    public int getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return "%s%d (%dhp)".formatted(monsterName, index, (int)health);
    }

    public String toStringFull() {
        return "%s%d (%dhp %da %ds)".formatted(monsterName, index, (int)health, (int)agility, (int)strength);
    }

    protected void generateParameters(int level, Consts.Monsters monsterConst)
    {
        final float healthKff = level * monsterConst.KffByLevel_Health;
        final float agilityKff = level * monsterConst.KffByLevel_Agility;
        final float strengthKff = level * monsterConst.KffByLevel_Strength;
        final float goldKff = level * monsterConst.KffByLevel_Gold;
        final float expKff = level * monsterConst.KffByLevel_Exp;
        /**/
        genHealth(monsterConst.DefHealth * healthKff);
        genAgility(monsterConst.DefAgility * agilityKff);
        genStrength(monsterConst.DefStrength*strengthKff);
        gold = (int)(monsterConst.DefGold*goldKff);
        exp = (int)(monsterConst.DefExp*expKff);
    }
}
