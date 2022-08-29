package world.forest;

import world.Consts;
import world.GameUnit;
import world.Hero;
import world.battle.Battle;
import world.monster.Goblin;
import world.monster.Skelet;

import java.awt.*;
import java.io.BufferedReader;
import java.util.*;
import java.util.List;

public class Forest {
    BufferedReader reader;

    public Forest(BufferedReader reader) {
        this.reader = reader;
    }

    private LinkedList<GameUnit> generateMonsterPack(int level) {
        final float healthKff = 1 + (level - 1) * Consts.Monsters.KffByLevel_PackHealth;
        final float monstersPackHealth = Consts.Monsters.PackHealth * healthKff;

        final int cntMonsters = 2;
        LinkedList<GameUnit> mosterPack = new LinkedList<>();
        Random random = new Random(System.currentTimeMillis());
        var allHealth = 0;
        var cnt = 0;
        while (true) {
            /*generate new monster*/
            final int indMonster = random.nextInt(0, cntMonsters);
            GameUnit monster = switch (indMonster) {
                case 1 -> new Goblin(cnt++, level);
                default -> new Skelet(cnt++, level);
            };
            allHealth += monster.getHealth();
            mosterPack.add(monster);
            if (allHealth > monstersPackHealth) {
                break;
            }
        }
        /**/
        System.out.println("Монстры:");
        mosterPack.stream().forEach(gameUnit -> System.out.println('\t'+gameUnit.toString()));
        return mosterPack;
    }

    public void enter(Hero hero, int level) {
        var mosterPack = generateMonsterPack(level);
        /**/
        Battle battle = new Battle(mosterPack, hero);
        Thread thread = new Thread(battle);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
