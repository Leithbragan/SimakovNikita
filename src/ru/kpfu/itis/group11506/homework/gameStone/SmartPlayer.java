package ru.kpfu.itis.group11506.homework.gameStone;

public class SmartPlayer extends Player {


    public Subject showSubject() {
        int random = (int) (1 + Math.random() * 3);

        return getValue(random);
    }

    public static Subject getValue(int number) {
        Subject randSubject = Subject.STONE;

        switch (number) {
            case 1:
                randSubject = Subject.PAPER;
                break;
            case 2:
                randSubject = Subject.STONE;
                break;
            case 3:
                randSubject = Subject.SCISSORS;
                break;
        }

        return randSubject;
    }
}


