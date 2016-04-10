package ru.kpfu.itis.group11506.homework.group;

import java.util.Arrays;

public class Group {

    private String name;
    private int age;
    private int point;

    //пустой конструктор для мейна
    public Group() {

    }


    //конструктор для заполнеия массива
    public Group(String name, int age, int point) {
        this.name = name;
        this.age = age;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPoint() {
        return point;
    }

    //заплонение массива и вывод разницы первого и последнего в отсортированном массиве
    public void print() {
        Group[] group = {new Group("Milana", 20, 87),
                new Group("Lola", 23, 78),
                new Group("Nik", 19, 95),
                new Group("Jim", 18, 60)};

        Arrays.sort(group, new ComparisonName());
        int comparisonName = group[group.length - 1].name.length() - group[0].name.length();
        System.out.println("the longest name is longer than the shortest on " + comparisonName + " characters");

        Arrays.sort(group, new ComparisonAge());
        int comparisonAge = group[group.length - 1].age - group[0].age;
        System.out.println("The oldest student is older than the youngest on " + comparisonAge + " age");

        Arrays.sort(group, new ComparisonPoint());
        int comparisonPoint = group[group.length - 1].point - group[0].point;
        System.out.println("The difference in performance between the most successful and not successful on " + comparisonPoint + " point");
    }
}
