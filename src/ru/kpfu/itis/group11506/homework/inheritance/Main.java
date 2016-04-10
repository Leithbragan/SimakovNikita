package ru.kpfu.itis.group11506.homework.inheritance;

public class Main {

    public static void main(String[] args) {

        Cars mc = new MuscleCar();
        Cars amg = new AMGCar();
        Cars tl = new Tesla();
        Cars tr = new Truck();

        mc.motorSound();
        amg.motorSound();
        tl.motorSound();
        tr.motorSound();
    }
}
