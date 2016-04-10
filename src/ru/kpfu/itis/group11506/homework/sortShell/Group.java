package ru.kpfu.itis.group11506.homework.sortShell;

public class Group implements Comparable{

    private int day;
    private String name;

    public Group(String name, int day) {
        this.name = name;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Group group = (Group) o;
        if (this.day > group.day ){
            return -1;
        }else if (this.day < group.day){
            return 1;
        }else {
            return (this.name.compareTo(group.name));
        }
    }
}
