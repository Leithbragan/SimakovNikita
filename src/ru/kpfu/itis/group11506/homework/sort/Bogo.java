package ru.kpfu.itis.group11506.homework.sort;

import java.util.Random;

public class Bogo {

    Students[] students = {new Students("Alex", 71),
            new Students("Masa", 59),
            new Students("Dony", 90),
            new Students("Zozo", 97),
            new Students("Lina", 96),
            new Students("Amin", 62),
            new Students("Elka", 88)};

    private Random rn = new Random();


    public Students[] sorting() {
        Students repositori;
        do {
            for (int index = 0; index < this.students.length; index++) {
                int j = rn.nextInt(this.students.length);
                repositori = this.students[index];
                this.students[index] = this.students[j];
                this.students[j] = repositori;
            }
        } while (isSorted());
        return students;
    }


    public boolean isSorted() {
        for (int index = 0; index < this.students.length - 1; index++) {
            if (this.students[index].compareTo(this.students[index + 1]) > 0) {
                return true;
            }
        }
        return false;
    }
}

