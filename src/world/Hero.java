package world;

public class Hero extends GameUnit {
    private String name;
    private int money;
    private int experience = 0;

    /*уровень по опыту 100, 200, 400, 800, 1600 ...*/
    public int getLevel() {
        int levelExp = 100;
        int level = 1;
        while(experience>=levelExp){
            levelExp *= 2;
            level += 1;
        }
        return level;
    }

    @Override
    public String toString() {
        return "%s (%dh %da %ds)".formatted(name, health, agility, strength);
    }

    public Hero(String name, int money, int experience) {
        this.name = name;
        this.money = money;
        this.experience = experience;
        /**/
        genHealth(Consts.Hero.HeroDefHealth);
        genAgility(Consts.Hero.HeroDefAgility);
        genStrength(Consts.Hero.HeroDefStrength);
    }
}
