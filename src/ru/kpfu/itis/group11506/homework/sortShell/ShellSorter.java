package ru.kpfu.itis.group11506.homework.sortShell;

public class ShellSorter {

    Group[] group = {new Group("Zoli", 19961109),
            new Group("Mony", 19960421),
            new Group("Oleg", 19970901),
            new Group("Roma", 19960113),
            new Group("Katy", 19971211)};

    public Group[] sorting() {
        Group repositori;
        int second_index;
        int length = group.length;
        int half_length = group.length / 2;
        while (half_length > 0)

        {
            for (int index = 0; index < length - half_length; index++) {
                second_index = index;
                while (second_index >= 0 && group[second_index].compareTo(group[second_index + half_length]) >= 0) {
                    repositori = group[second_index];
                    group[second_index] = group[second_index + half_length];
                    group[second_index + half_length] = repositori;
                    second_index--;
                }
            }
            half_length = half_length / 2;
        }
        return group;
    }
}