package ru.kpfu.itis.group11506.homework.semestr;

import java.util.*;

public class Magic {

    public static void run(List<Integer> numberGuys, Map<Integer, List<Integer>> guysPrefer, Map<Integer, List<Integer>> girlPrefer) {
        Map<Integer, Integer> matches = match(numberGuys, guysPrefer, girlPrefer);
        for (Map.Entry<Integer, Integer> couple : matches.entrySet()) {
            System.out.println(
                    DataHandling.namesWomen[couple.getKey()] + " замужем за  " + DataHandling.namesMen[couple.getValue()]);
        }
    }

    private static Map<Integer, Integer> match(List<Integer> guys, Map<Integer, List<Integer>> preferGuys, Map<Integer, List<Integer>> preferGirls) {
        Map<Integer, Integer> engagedTo = new TreeMap<>();
        List<Integer> freeGuys = new LinkedList<>();
        freeGuys.addAll(guys);
        while (!freeGuys.isEmpty()) {
            Integer thisGuy = freeGuys.remove(0);
            List<Integer> thisGuyPrefers = preferGuys.get(thisGuy);
            for (Integer girl : thisGuyPrefers) {
                System.out.println("2");
                if (engagedTo.get(girl) == null) {
                    engagedTo.put(girl, thisGuy);
                    break;
                } else {
                    Integer otherGuy = engagedTo.get(girl);
                    List<Integer> thisGirlPrefers = preferGirls.get(girl);
                    System.out.println(thisGirlPrefers.indexOf(thisGuy));
                    if (thisGirlPrefers.indexOf(thisGuy) <
                            thisGirlPrefers.indexOf(otherGuy)) {
                        engagedTo.put(girl, thisGuy);
                        freeGuys.add(otherGuy);
                        break;
                    }
                }
            }
        }
        return engagedTo;
    }
}
