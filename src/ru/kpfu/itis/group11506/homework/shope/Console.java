package ru.kpfu.itis.group11506.homework.shope;

import java.util.Arrays;

public class Console {

    Thing[] things = {new Thing("PS", 34500, 4845),
            new Thing("XBOX", 22000, 5980),
            new Thing("Dendy", 1000, 1063),
            new Thing("Sega", 2000, 1367),
            new Thing("Nentendo", 500, 715)};

    public void print() {
        Arrays.sort(things);
        for (int index = 0; index < things.length; index++) {
            System.out.println(index + 1 + ")" + things[index].name + "\nprice = " + things[index].price + "\nraiting " + things[index].rating);
        }
    }
}
