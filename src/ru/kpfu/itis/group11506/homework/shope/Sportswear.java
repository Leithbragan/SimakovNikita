package ru.kpfu.itis.group11506.homework.shope;

import java.util.Arrays;

public class Sportswear {

    Thing[] things = {new Thing("sneakers", 5500, 1000),
            new Thing("sport suit", 6000, 778),
            new Thing("shorts", 2000, 777),
            new Thing("socks", 200, 10000),
            new Thing("T-shirt", 800, 2387),
            new Thing("leggings", 4000, 698)};

    public void print() {
        Arrays.sort(things);
        for (int index = 0; index < things.length; index++) {
            System.out.println(index + 1 + ")" + things[index].name + "\nprice  " + things[index].price + "\nraiting " + things[index].rating);
        }
    }
}
