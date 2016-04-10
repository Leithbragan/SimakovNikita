package ru.kpfu.itis.group11506.homework.gameStone;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the number of games that players must play");
        int number = sc.nextInt();

        Game gm = new Game(number);

        gm.counter();
        System.out.println("Games won by clever player : " + gm.getScoreSmartPlayer());
        System.out.println("Not so bad a silly, too, can win : " + gm.getScoreStoneman());
    }
}