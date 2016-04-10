package ru.kpfu.itis.group11506.homework.delivery;

public class User {

    private static String name;
    private static String number;
    private static String numberCard;
    private static String street;
    private static String home;
    private static String flat;

    public User(String name, String number, String numberCard, String street, String home, String flat) {
        this.name = name;
        this.number = number;
        this.numberCard = numberCard;
        this.street = street;
        this.home = home;
        this.flat = flat;
    }

    public static String getName() {
        return name;
    }

    public static String getNumber() {
        return number;
    }

    public static String getNumberCard() {
        return numberCard;
    }

    public static String getStreet() {
        return street;
    }

    public static String getHome() {
        return home;
    }

    public static String getFlat() {
        return flat;
    }
}
