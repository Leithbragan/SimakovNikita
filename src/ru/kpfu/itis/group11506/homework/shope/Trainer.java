package ru.kpfu.itis.group11506.homework.shope;

import java.util.Arrays;

public class Trainer {

    Thing[] things = {new Thing("dumbbells", 1500, 1245),
            new Thing("barbell", 2000, 1225),
            new Thing("Treadmill", 12000, 751),
            new Thing("Hummer", 22000, 611),
            new Thing("crossover", 2800, 566)};

    public void print() {
        Arrays.sort(things);
        for (int index = 0; index < things.length; index++) {
            System.out.println(index + 1 + ")" + things[index].name + "\nprice = " + things[index].price + "\nraiting " + things[index].rating);
        }
    }
}

