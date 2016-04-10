package ru.kpfu.itis.group11506.homework.group;

import java.util.Comparator;

public class ComparisonPoint implements Comparator<Group> {

    @Override
    public int compare(Group o1, Group o2) {
        int point1 = o1.getPoint();
        int point2 = o2.getPoint();
        if (point1 > point2) {
            return 1;
        } else if (point1 < point2) {
            return -1;
        }
        return 0;
    }
}
