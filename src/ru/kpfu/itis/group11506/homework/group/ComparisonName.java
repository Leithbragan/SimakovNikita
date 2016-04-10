package ru.kpfu.itis.group11506.homework.group;

import java.util.Comparator;

public class ComparisonName implements Comparator<Group> {

    @Override
    public int compare(Group o1, Group o2) {
        int name1 = o1.getName().length();
        int name2 = o2.getName().length();
        if (name1 > name2) {
            return 1;
        } else if (name1 < name2) {
            return -1;
        }
        return 0;
    }

}
