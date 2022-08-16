package world;

public class Hero extends GameUnit {
    private String Name;
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

    public String getName() {
        return Name;
    }

    public Hero(String name, int money, int experience) {
        Name = name;
        this.money = money;
        this.experience = experience;
        /**/
        genHealth(Consts.HeroDefHealth);
        genAgility(Consts.HeroDefAgility);
        genStrength(Consts.HeroDefStrength);
        System.out.println("%s(%d health, %d agility, %d strenght) created".formatted(name, health, agility, strength));
    }
}
