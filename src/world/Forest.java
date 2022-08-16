package world;

import world.monster.ConstsMonsters;
import world.monster.Goblin;
import world.monster.Skelet;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Forest {
    BufferedReader reader;
    List<GameUnit> monsterPack = new ArrayList<>();

    public Forest(BufferedReader reader) {
        this.reader = reader;
    }

    private void generateMonsterPack(Hero hero)
    {
        final int level = hero.getLevel();
        final float healthKff = 1 + (level-1) * ConstsMonsters.KffByLevel_PackHealth;
        final float monstersHealth = ConstsMonsters.PackHealth * healthKff;

        final int cntMonsters = 2;
        Random random = new Random(System.currentTimeMillis());
        while(true) {
            final int indMonster = random.nextInt(0, cntMonsters);
            GameUnit monster = switch (indMonster){
                case 0 -> new Skelet(level);
                case 1 -> new Goblin(level);
                default -> new Skelet(level);
            };
            monsterPack.add(monster);
        }
    }
    void enter(Hero hero){
        if (monsterPack.size()==0){
            generateMonsterPack(hero);
        }

    }
}
