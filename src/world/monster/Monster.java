package world.monster;

import world.Consts;
import world.GameUnit;

public abstract class Monster extends GameUnit {
    protected String monsterName;
    protected int index;
    protected int goldPrize;
    protected int hpPrize;

    @Override
    public String toString() {
        return "%s(%d) %dh".formatted(monsterName, index, super.health);
    }

    public String toStringFull() {
        return "%s(%d) (%dh %da %ds)".formatted(monsterName, index, super.health, super.agility, super.strength);
    }

    protected void generateParameters(int level, Consts.Monsters monsterConst)
    {
        final float healthKff = 1 + (level-1) * monsterConst.KffByLevel_Health;
        /**/
        genHealth((int)(monsterConst.DefHealth * healthKff));
        genAgility(monsterConst.DefAgility);
        genStrength(monsterConst.DefStrength);
    }
}
