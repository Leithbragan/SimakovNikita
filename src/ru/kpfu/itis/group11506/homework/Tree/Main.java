package ru.kpfu.itis.group11506.homework.Tree;

public class Main {

    public static void main(String[] args) {
        BinTree binTree = new BinTree();

        binTree.add(5);
        binTree.add(7);
        binTree.add(6);
        binTree.add(3);
        binTree.add(1);
        binTree.add(4);
        binTree.add(7);
        binTree.add(9);
        binTree.add(10);
        binTree.add(2);
        binTree.add(8);
        if (binTree.find(11) == null) {
            System.out.println("element 11 is null");
        }
        System.out.println("Проверка");
        for (int i = 1; i < 11; i++) {
            if (binTree.find(i) != null) {
                System.out.println("element " + i + " is loceted in the tree");
            } else {
                System.out.println("element " + i + " isn't loceted in the tree");
            }
        }
    }
}


