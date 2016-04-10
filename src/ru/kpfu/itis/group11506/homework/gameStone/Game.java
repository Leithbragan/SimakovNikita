package ru.kpfu.itis.group11506.homework.gameStone;

public class Game {

    SmartPlayer smp = new SmartPlayer();
    Stoneman st = new Stoneman();

    public Game(int quantity) {
        setGame(quantity);
    }

    private int scoreSmartPlayer = 0;
    private int scoreStoneman = 0;
    private int game;
    private Subject valueSmartPlayer;


    public int getScoreSmartPlayer() {
        return scoreSmartPlayer;
    }

    public int getScoreStoneman() {
        return scoreStoneman;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public void counter() {
        int point = 1;
        while (game != 0) {
            valueSmartPlayer = smp.showSubject();
            if (valueSmartPlayer.equals(st.showSubject())) {
                game++;
            } else if (valueSmartPlayer.equals(Subject.PAPER)) {
                scoreSmartPlayer += point;
            } else if (valueSmartPlayer.equals(Subject.SCISSORS)) {
                scoreStoneman += point;
            }
            game--;
        }
    }
}