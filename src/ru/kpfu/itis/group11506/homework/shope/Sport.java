package ru.kpfu.itis.group11506.homework.shope;

import java.util.Scanner;

public class Sport {

    Trainer trainer = new Trainer();
    Sportswear sportswear = new Sportswear();

    public void print() {
        System.out.println("Enter 1 - If you need equipment or 2 - If you need simulators");
        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()) {
            case 1:
                sportswear.print();
                break;
            case 2:
                trainer.print();
                break;
        }
    }

}
