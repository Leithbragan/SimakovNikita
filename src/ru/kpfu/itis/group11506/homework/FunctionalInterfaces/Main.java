package ru.kpfu.itis.group11506.homework.FunctionalInterfaces;

// TODO: 27.04.2016 дз с помощью стримов найти студента с макс возрастом вывести судентов с именем 5 символов
// TODO: 27.04.2016  сформировать мапу интеджер на основе кей группа валуе студент

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        final int minAge = 18;
        final int diff = 5;


        for (int index = 0; index < 100; index++) {
            int age = minAge + (int) (Math.random() * diff);
            studentList.add(new Student("Stud" + index, age, index));
        }

        System.out.println(studentList.stream().max(Comparator.comparing(Student::getAge)));

        System.out.println(studentList.stream().filter(student -> student.getName().length() > 5).collect(Collectors.toList()));

        Map<Integer, Student> studentMap = studentList.stream().distinct().collect(Collectors.toMap(Student::getGroup, o -> o));
        System.out.println("Map - " + studentMap);
    }
}