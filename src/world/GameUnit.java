package world;

import java.util.Random;

public abstract class GameUnit {
    static private Random random = new Random(System.currentTimeMillis());
    protected float health;
    protected float strength;
    protected float agility;

    public int getHealth() {
        return (int)health;
    }

    public void attack(GameUnit unit) {
        final int randI = random.nextInt(0, 100);
        if ((int)(agility * 3) > randI) {
            System.out.println("%s attack %s on %d".formatted(this.toString(), unit.toString(), (int)strength));
            unit.health -= strength;
        } else {
            System.out.println("%s missed".formatted(this.toString()));
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    private float genRand(float defValue, int dltValue) {
        float value = defValue + random.nextInt(-dltValue, dltValue);
        return Math.max(1.f, value);
    }

    protected void genHealth(float defHealth) {
        health = genRand(defHealth, 10);
    }

    protected void genStrength(float defStrength) {

        strength = genRand(defStrength, 2);
    }
    protected void genAgility(float defAgility) {

        agility = genRand(defAgility, 3);
    }
}
