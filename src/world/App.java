package world;

import world.consts.Consts;
import world.hero.Hero;
import world.forest.Forest;
import world.shop.Shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    static String getName(BufferedReader reader) {
        System.out.println("Enter the name...");
        final String name;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            System.out.println("exception");
            /*default*/
            return "hero";
        }
        return name;
    }

    public static void main(String[] args) {
        System.out.println("Start game!");
        /**/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*create hero*/
        Hero hero = new Hero(getName(reader));
        /*create shop*/
        Shop shop = new Shop(reader);
        /*create forest*/
        Forest forest = new Forest(reader);
        /*greeting*/
        System.out.println(hero + " welcome!");
        /*start main loop*/
        while (hero.isAlive()) {
            System.out.println("Where?");
            System.out.println(">> 1.Shop, 2.Forest, 3.Exit");
            try {
                final String s = reader.readLine();
                if (s.equals("1")) {
                    shop.enter();
                } else if (s.equals("2")) {
                    System.out.println(">> Enter monsters level[%d,%d]?".formatted(Consts.Monsters.MinLevel,
                            Consts.Monsters.MaxLevel));
                    final String sLevel = reader.readLine();
                    /*default value on wrong input*/
                    int level = 1;
                    try {
                        level = Integer.parseInt(sLevel);
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input");
                    }
                    level = Math.max(Consts.Monsters.MinLevel, Math.min(Consts.Monsters.MaxLevel, level));
                    System.out.println("Monsters level - %d".formatted(level));
                    /*enter the forest*/
                    forest.enter(hero, level);
                    if (hero.isAlive()) {
                        /*actualize stats*/
                        hero.checkLevel();
                        hero.toStringFull();
                    }
                    System.out.println(hero.toStringFull());
                } else if (s.equals("3")) {
                    /*exit the game*/
                    break;
                }
            } catch (Exception e) {
                System.out.println("catched exception: " + e.getMessage());
                break;
            }
        }
        /*end main loop*/
        System.out.println("Game over");
    }
}
