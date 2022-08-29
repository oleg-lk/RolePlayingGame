package world.monster;

import world.Consts;
import world.GameUnit;

public class Skelet extends Monster {
    public Skelet(int indexSkelet, int level) {
        this.monsterName = "Skelet";
        this.index = indexSkelet;
        /**/
        final float healthKff = 1 + (level-1) * Consts.Monsters.KffByLevel_MonsterHealth;
        /**/
        genHealth((int)(Consts.Monsters.Skelet_DefHealth * healthKff));
        genAgility(Consts.Monsters.Skelet_DefAgility);
        genStrength(Consts.Monsters.Skelet_DefStrength);
    }
}
