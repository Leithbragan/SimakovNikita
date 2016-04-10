package ru.kpfu.itis.group11506.homework.delivery;

public class Menu {

    private String name;
    private double shekel;
    private int weight;


    public Menu(String name, double shekel, int weight) {
        this.name = name;
        this.shekel = shekel;
        this.weight = weight;

    }

    public String getName() {
        return name;
    }

    public double getShekel() {
        return shekel;
    }

    public int getWeight() {
        return weight;
    }
}
