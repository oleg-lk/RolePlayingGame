package world.monster;

import world.Consts;
import world.GameUnit;

public class Skelet extends GameUnit {
    private String monsterName;
    public Skelet(int level) {
        monsterName = "Skelet";
        /**/
        final float healthKff = 1 + (level-1) * Consts.Monsters.KffByLevel_MonsterHealth;
        /**/
        genHealth((int)(Consts.Monsters.Skelet_DefHealth * healthKff));
        genAgility(Consts.Monsters.Skelet_DefAgility);
        genStrength(Consts.Monsters.Skelet_DefStrength);
        //System.out.println("%s(%d health, %d agility, %d strenght) created".formatted(monsterName, health, agility, strength));
    }
}
