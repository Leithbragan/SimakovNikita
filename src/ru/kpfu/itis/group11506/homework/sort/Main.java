package ru.kpfu.itis.group11506.homework.sort;

public class Main {


    public static void main(String[] args) {

        Print print = new Print();
        BubbleSorter bubbleSorter = new BubbleSorter();
        Bogo bogo = new Bogo();
        System.out.println("StupedSort");
        bogo.isSorted();
        print.printFromEvaluation(bogo.sorting());
        System.out.println("BubbleSorter");
        print.printFromEvaluation(bubbleSorter.sorting());

    }
}
