package ru.kpfu.itis.group11506.homework.shope;

import java.util.Scanner;

public class Electronic {

    Computers computers = new Computers();
    Console console = new Console();

    public void print() {
        System.out.println("Enter 1 - If you need computer or 2 - If you need console");
        Scanner sc = new Scanner(System.in);

        switch (sc.nextInt()) {
            case 1:
                computers.print();
                break;
            case 2:
                console.print();
                break;
        }
    }
}