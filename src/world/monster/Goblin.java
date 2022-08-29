package world.monster;

import world.Consts;
import world.GameUnit;

public class Goblin extends Monster {

    public Goblin(int indexGoblin, int level) {
        this.monsterName = "Goblin";
        this.index = indexGoblin;
        /**/
        final float healthKff = 1 + (level-1) * Consts.Monsters.KffByLevel_MonsterHealth;
        final float agilityKff = 1 + (level-1) * Consts.Monsters.KffByLevel_MonsterAgility;
        final float strengthKff = 1 + (level-1) * Consts.Monsters.KffByLevel_MonsterStrength;
        /**/
        genHealth((int)(Consts.Monsters.Goblin_DefHealth * healthKff));
        genAgility((int)(Consts.Monsters.Goblin_DefAgility*agilityKff));
        genStrength((int)(Consts.Monsters.Goblin_DefStrength*strengthKff));
    }

}
