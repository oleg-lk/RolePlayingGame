package world;

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
        goods.add(new Good("зелье 10hp", 50));
        goods.add(new Good("зелье 20hp", 90));
        goods.add(new Good("зелье 50hp", 200));
        goods.add(new Good("зелье +10s", 50));
        goods.add(new Good("зелье +10a", 100));
    }

    void printGoods(){
        goods.stream().forEach(System.out::println);
    }

    void enter()
    {
        while (true){
            break;
        }
    }
}
