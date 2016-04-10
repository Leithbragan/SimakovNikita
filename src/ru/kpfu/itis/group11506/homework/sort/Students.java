package ru.kpfu.itis.group11506.homework.sort;

public class Students implements Comparable {

    int evaluation;
    String name;

    public Students(String name, int evaluation) {
        this.name = name;
        this.evaluation = evaluation;
    }

    @Override
    public int compareTo(Object o) {
        Students students = (Students) o;
        if (this.evaluation > students.evaluation) {
            return -1;
        } else if (this.evaluation < students.evaluation) {
            return 1;
        } else {
            return (this.name.compareTo(students.name));
        }
    }
}
