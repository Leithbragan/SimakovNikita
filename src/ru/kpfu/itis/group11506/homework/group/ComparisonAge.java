package ru.kpfu.itis.group11506.homework.group;

import java.util.Comparator;

public class ComparisonAge implements Comparator<Group> {

    @Override
    public int compare(Group o1, Group o2) {
        int age1 = o1.getAge();
        int age2 = o2.getAge();
        if (age1 > age2) {
            return 1;
        } else if (age1 < age2) {
            return -1;
        }
        return 0;
    }
}
