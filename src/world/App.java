package world;

import world.forest.Forest;

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
        final int initMoney = 0;
        final int initExp = 0;
        Hero hero = new Hero(getName(reader), initMoney, initExp);
        Shop shop = new Shop(reader);
        Forest forest = new Forest(reader);
        /**/
        System.out.println(hero + " welcome!");
        /*start main loop*/
        while (true) {
            System.out.println("Куда вы хотите пойти?");
            System.out.println(">> 1.К торговцу, 2.В тёмный лес, 3.На выход");
            try {
                final String s = reader.readLine();
                if (s.equals("1")) {
                    shop.enter();
                } else if (s.equals("2")) {
                    System.out.println(">> Какой уровень монстров(от %d до %d)?".formatted(Consts.Monsters.MinLevel,
                            Consts.Monsters.MaxLevel));
                    final String sLevel = reader.readLine();
                    int level = 1;
                    try {
                        Integer.parseInt(sLevel);
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный формат, задан уровень %d".formatted(level));
                    }
                    level = Math.max(Consts.Monsters.MinLevel, Math.min(Consts.Monsters.MaxLevel, level));
                    System.out.println("Уровень %d".formatted(level));
                    forest.enter(hero, level);
                } else if (s.equals("3")) {
                    /*exit the game*/
                    break;
                }
            } catch (IOException e) {
                System.out.println("catched exception: " + e.getMessage());
                continue;
            }
        }
    }
}
