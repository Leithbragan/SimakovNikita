package ru.kpfu.itis.group11506.homework.zebras;

public class Lines extends Thread {

    private int sleep;
    private String name;

    public Lines(String name, int sleep) {
        this.name = name;
        this.sleep = sleep;
    }


    @Override
    public void run() {
            System.out.println("Лошадь " + name + " пришла к финишу");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
