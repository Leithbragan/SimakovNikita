package ru.kpfu.itis.group11506.homework.FunctionalInterfaces;

public class Student {

    private String name;
    private int age;
    private int group;

    public Student(String name, int age, int group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", group=" + group +
                '}';
    }
}