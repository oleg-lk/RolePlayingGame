package world;

import java.util.Random;

public abstract class GameUnit {
    static private Random random = new Random(System.currentTimeMillis());
    protected int health;
    protected int strength;
    protected int agility;

    public int getHealth() {
        return health;
    }

    public void attack(GameUnit unit)
    {
        final int randI = random.nextInt(0, 100);
        if((agility*3)>randI) {
            System.out.println("%s attack %s on %d".formatted(this.toString(), unit.toString(), strength));
            unit.health -= strength;
        }
        else {
            System.out.println("%s missed".formatted(this.toString()));
        }
    }

    public boolean isAlive(){
        return health > 0;
    }

    private int genRand(int defValue, int dltValue) {
        int value = defValue + random.nextInt(-dltValue, dltValue);
        return Math.max(1, value);
    }
    protected void genHealth(int defHealth) {
        health = genRand(defHealth, 10);
    }
    protected void genStrength(int defStrength) {
        strength = genRand(defStrength, 2);
    }
    protected void genAgility(int defAgility) {
        agility = genRand(defAgility, 5);
    }
}
