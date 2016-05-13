package ru.kpfu.itis.group11506.homework.semestr;

import java.util.*;

public class Magic {

    public static void run(List<Integer> numberGuys, Map<Integer, List<Integer>> guysPrefer, Map<Integer, List<Integer>> girlPrefer, List<String> namesGuy, List<String> namesGirl) {
        Map<Integer, Integer> matches = match(numberGuys, guysPrefer, girlPrefer);
        System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
        for (Map.Entry<Integer, Integer> couple : matches.entrySet()) {
            for (int i = 0; i < namesGirl.size(); i++) {
                if (Objects.equals(couple.getKey(), DataHandling.getIdWomen().get(i))){
                    System.out.print("\t\t" + namesGirl.get(i) +" замужем за ");
                    for (int j = 0; j < namesGuy.size(); j++) {
                        if (Objects.equals(couple.getValue(), DataHandling.getIdMen().get(j))){
                            System.out.print(namesGuy.get(j));
                            System.out.println();
                        }
                    }
                }
            }
        }
        System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
    }

    private static Map<Integer, Integer> match(List<Integer> guys, Map<Integer, List<Integer>> preferGuys, Map<Integer, List<Integer>> preferGirls) {
        Map<Integer, Integer> engagedTo = new TreeMap<>();
        List<Integer> freeGuys = new LinkedList<>();
        freeGuys.addAll(guys);
        while (!freeGuys.isEmpty()) {
            Integer thisGuy = freeGuys.remove(0);
            List<Integer> thisGuyPrefers = preferGuys.get(thisGuy);
            for (Integer girl : thisGuyPrefers) {
                if (engagedTo.get(girl) == null) {
                    engagedTo.put(girl, thisGuy);
                    break;
                } else {
                    Integer otherGuy = engagedTo.get(girl);
                    List<Integer> thisGirlPrefers = preferGirls.get(girl);

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
