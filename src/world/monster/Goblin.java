package world.monster;

import world.consts.Consts;

public class Goblin extends Monster {

    public Goblin(int indexGoblin, int level) {
        this.monsterName = "Goblin";
        this.index = indexGoblin;
        /**/
        generateParameters(level, Consts.GoblinMonster);
    }

}
