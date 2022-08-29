package world.shop;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    BufferedReader reader;
    public Shop(BufferedReader reader) {
        this.reader = reader;
    }
    class Good
    {
        String name;
        int price;

        public Good(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return '\'' + name + '\'' + ", price=" + price;
        }
    }
    List<Good> goods = new ArrayList<>();
    {
        goods.add(new Good("potion 10hp", 50));
        goods.add(new Good("potion 20hp", 90));
        goods.add(new Good("potion 50hp", 200));
        goods.add(new Good("potion +10s", 50));
        goods.add(new Good("potion +10a", 100));
    }

    public void printGoods(){
        goods.stream().forEach(System.out::println);
    }

    public void enter()
    {
        printGoods();
        System.out.println("Trader not here");
        //while (true){
        //    break;
        //}
    }
}
