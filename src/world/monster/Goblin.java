package world.monster;

import world.Consts;
import world.GameUnit;

public class Goblin extends GameUnit {
    private String monsterName;
    public Goblin(int level) {
        monsterName = "Goblin";
        /**/
        final float healthKff = 1 + (level-1) * Consts.Monsters.KffByLevel_MonsterHealth;
        /**/
        genHealth((int)(Consts.Monsters.Goblin_DefHealth * healthKff));
        genAgility(Consts.Monsters.Goblin_DefAgility);
        genStrength(Consts.Monsters.Goblin_DefStrength);
        //System.out.println("%s(%d health, %d agility, %d strenght) created".formatted(monsterName, health, agility, strength));
    }
}
