package ru.kpfu.itis.group11506.homework.sortShell;

public class Main {

    public static void main(String[] args) {

        Out out = new Out();
        ShellSorter shell = new ShellSorter();

        out.printFromData(shell.sorting());
    }
}
