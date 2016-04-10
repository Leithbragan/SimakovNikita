package ru.kpfu.itis.group11506.homework.sort;

public class Print {

    public void printFromEvaluation(Students[] students) {
        System.out.println("  | Name |        | Evaluation");
        for (int i = 0; i < students.length; i++) {
            System.out.println(i + 1 + " | " + students[i].name + " |        | " + students[i].evaluation);
        }
    }

    public void printFromData(Students[] students) {
        System.out.println("  | Name |        | Data of Birth|");
        for (int i = 0; i < students.length; i++) {
            System.out.println(i + 1 + " | " + students[i].name + " |        | " + students[i].evaluation);
        }
    }

}