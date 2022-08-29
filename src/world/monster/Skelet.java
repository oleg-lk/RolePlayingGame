package world.monster;

import world.Consts;
import world.GameUnit;

public class Skelet extends Monster {
    public Skelet(int indexSkelet, int level) {
        this.monsterName = "Skelet";
        this.index = indexSkelet;
        /**/
        generateParameters(level, Consts.SkeletMonster);
    }
}
