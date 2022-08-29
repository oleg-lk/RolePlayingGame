package world.battle;

import world.Consts;
import world.GameUnit;
import world.Hero;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Battle implements Runnable
{
    private LinkedList<GameUnit> battlePack;
    private Hero hero;
    private int currentAtackedMonster = 0;

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
            /**/
            final GameUnit gameUnit = battlePack.pop();
            if(gameUnit instanceof Hero){
                GameUnit monster = battlePack.peek();
                gameUnit.attack(monster);
                if(!monster.isAlive()){
                    System.out.println("%s died".formatted(monster));
                    battlePack.remove(monster);
                }
            }
            else{
                gameUnit.attack(hero);
                if(!hero.isAlive()){
                    System.out.println("hero died");
                }
            }
            battlePack.addLast(gameUnit);
        }
        System.out.println("Battle end");
    }
}
