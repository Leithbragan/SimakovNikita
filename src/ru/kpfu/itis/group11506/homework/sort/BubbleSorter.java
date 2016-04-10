package ru.kpfu.itis.group11506.homework.sort;

public class BubbleSorter {

    Students[] students = {new Students("Ales", 56),
            new Students("Anna", 69),
            new Students("Alin", 90),
            new Students("Gogi", 85),
            new Students("Lilu", 66),
            new Students("Amin", 95),
            new Students("Erik", 78)};

    public Students[] sorting() {

        for (int index = students.length - 1; index > 0; index--) {
            for (int j = 0; j < index; j++) {
                if (students[j].compareTo(students[j + 1]) > 0) {
                    Students ss = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = ss;
                }
            }
        }
        return students;
    }
}