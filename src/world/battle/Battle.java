package world.battle;

import world.consts.Consts;
import world.GameUnit;
import world.hero.Hero;
import world.monster.Monster;

import java.util.Collections;
import java.util.LinkedList;

public class Battle implements Runnable
{
    private final Object lock = new Object();
    Boolean isPause = false;
    public void pause(boolean pause){
        synchronized (isPause)  {
            //other thread safe code
            isPause = pause;
        }
    }
    private LinkedList<GameUnit> battlePack;
    private Hero hero;
    private int goldFromBattle = 0;
    private int expFromBattle = 0;

    public Battle(LinkedList<GameUnit> monsterPack, Hero hero) {
        this.battlePack = monsterPack;
        this.battlePack.add(hero);
        this.hero = hero;
        /*random*/
        Collections.shuffle(this.battlePack);
    }

    @Override
    public void run() {
        System.out.println("Battle begin");
        while (battlePack.size()>1){
            try {
                Thread.sleep(Consts.Tick_millis);
            } catch (InterruptedException e) {
                System.out.println("Interrupted...");
            }
            synchronized (isPause)  {
                //other thread safe code
                if (isPause){
                    continue;
                }
            }
            /**/
            final GameUnit gameUnit = battlePack.pop();
            if(gameUnit instanceof Hero){
                GameUnit monster = battlePack.peek();
                gameUnit.attack(monster);
                if(!monster.isAlive()){
                    System.out.println("%s died".formatted(monster));
                    goldFromBattle += ((Monster)monster).getGold();
                    expFromBattle += ((Monster)monster).getExp();
                    hero.setExp(((Monster)monster).getExp());
                    hero.setGold(((Monster)monster).getGold());
                    battlePack.remove(monster);
                }
            }
            else{
                gameUnit.attack(hero);
                if(!hero.isAlive()){
                    System.out.println("hero died");
                    return;
                }
            }
            battlePack.addLast(gameUnit);
        }
        System.out.println("Battle end");
        System.out.println("Got %d golds".formatted(goldFromBattle));
        System.out.println("Got %d exp".formatted(expFromBattle));
    }
}
