package ru.kpfu.itis.group11506.homework.shope;

import java.util.Arrays;

public class Computers {

    Thing[] things = {new Thing("PC", 150668, 98045),
            new Thing("Laptop", 690909, 50225),
            new Thing("Monoblock", 67990, 10051),
            new Thing("Tablet PC", 35000, 70011)};

    public void print() {
        Arrays.sort(things);
        for (int index = 0; index < things.length; index++) {
            System.out.println(index + 1 + ")" + things[index].name + "\nprice = " + things[index].price + "\nraiting " + things[index].rating);
        }
    }
}