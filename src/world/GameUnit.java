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
