package world.monster;

import world.consts.Consts;

public class Skelet extends Monster {
    public Skelet(int indexSkelet, int level) {
        this.monsterName = "Skelet";
        this.index = indexSkelet;
        /**/
        generateParameters(level, Consts.SkeletMonster);
    }
}
