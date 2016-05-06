package ru.kpfu.itis.group11506.homework.zebras;

public class Main {

    public static void main(String[] args) {

        Thread[] horse = new Thread[10];
        for (int i = 0; i < horse.length; i++) {
            horse[i] = new Lines("Horse" + (i + 1), 1000);
            horse[i].start();
        }
    }
}
