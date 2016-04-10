package ru.kpfu.itis.group11506.homework.list;

public class Main {

    public static void main(String[] args) {
        LinkedNodes<Boolean> list = new LinkedNodes<>();
        list.init();

        list.addLastNode(false);


        CycleDetermination cycleDetermination = new CycleDetermination();
        System.out.println(cycleDetermination.hasCicle(list));

        list.addLastNode(list.getStartNode());
        System.out.println(cycleDetermination.hasCicle(list));

    }
}
