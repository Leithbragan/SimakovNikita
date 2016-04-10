package ru.kpfu.itis.group11506.homework.shope;

public class Thing implements Comparable {

    String name;
    double price;
    int rating;

    public Thing(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public int compareTo(Object o) {
        Thing supp = (Thing) o;
        if (this.rating > supp.rating) {
            return -1;
        } else if (this.rating < supp.rating) {
            return 1;
        }
        return 0;
    }
}