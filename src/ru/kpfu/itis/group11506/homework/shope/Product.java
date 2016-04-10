package ru.kpfu.itis.group11506.homework.shope;

public class Product {

    Sport sport = new Sport();
    Electronic electronic = new Electronic();

    public void sortingPrint(int value) {
        switch (value) {
            case 1:
                sport.print();
                break;
            case 2:
                electronic.print();
                break;
        }
    }

}
