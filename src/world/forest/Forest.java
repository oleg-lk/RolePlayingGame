package world.forest;

import world.consts.Consts;
import world.GameUnit;
import world.hero.Hero;
import world.battle.Battle;
import world.monster.Goblin;
import world.monster.Monster;
import world.monster.Skelet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Forest {
    BufferedReader reader;

    public Forest(BufferedReader reader) {
        this.reader = reader;
    }

    private LinkedList<GameUnit> generateMonsterPack(int level) {
        final float healthKff = level * Consts.Monsters.KffByLevel_PackHealth;
        final float monstersPackHealth = Consts.Monsters.PackHealth * healthKff;

        final int cntMonsters = 2;
        LinkedList<GameUnit> monsterPack = new LinkedList<>();
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
            monsterPack.add(monster);
            if (allHealth > monstersPackHealth) {
                break;
            }
        }
        /*print monster pack*/
        System.out.println("Monsters:");
        monsterPack.stream().forEach(gameUnit -> System.out.println('\t' + ((Monster) gameUnit).toStringFull()));
        return monsterPack;
    }

    public void enter(Hero hero, int level) throws IOException, InterruptedException {
        var monsterPack = generateMonsterPack(level);
        /**/
        Battle battle = new Battle(monsterPack, hero);
        Thread thread = new Thread(battle);
        System.out.println("Battle start in 3 seconds");
        for (int i = 3; i > 0; i--) {
            System.out.println(i + "...");
                Thread.sleep(1000);
        }
        thread.start();
        thread.join();
    }
}
