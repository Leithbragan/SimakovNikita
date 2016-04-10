package ru.kpfu.itis.group11506.homework.sortShell;

public class Out {

    public void printFromData(Group[] group){
        System.out.println("  | Name |        | Data of Birth|");
        for (int i = 0; i < group.length; i++) {
            System.out.println(i + 1 + " | " + group[i].getName() + " |        | " + group[i].getDay());
        }
    }
}
