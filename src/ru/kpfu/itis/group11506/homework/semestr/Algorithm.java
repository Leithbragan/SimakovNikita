package ru.kpfu.itis.group11506.homework.semestr;

import java.util.*;

public class Algorithm {

    // Передавать сюда какую-то модель
    public void printCouples(List<Integer> numberGuys, List<Integer> numberGirls, Map<Integer, List<Integer>> guysPrefer, Map<Integer, List<Integer>> girlPrefer, List<String> namesGuy, List<String> namesGirl) {
        Map<Integer, Integer> matches = implementationAlgorithm(numberGuys, guysPrefer, girlPrefer);
        System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
        for (Map.Entry<Integer, Integer> couple : matches.entrySet()) {
            for (int i = 0; i < namesGirl.size(); i++) {
                if (Objects.equals(couple.getKey(), numberGirls.get(i))){
                    System.out.print("\t\t" + namesGirl.get(i) +" замужем за ");
                    for (int j = 0; j < namesGuy.size(); j++) {
                        if (Objects.equals(couple.getValue(), numberGuys.get(j))){
                            System.out.print(namesGuy.get(j));
                            System.out.println();
                        }
                    }
                }
            }
        }
        System.out.println("♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥");
    }

    private Map<Integer, Integer> implementationAlgorithm(List<Integer> guys, Map<Integer, List<Integer>> preferGuys, Map<Integer, List<Integer>> preferGirls) {
        // Либо исправить, либо объяснить выбор структур данных
        Map<Integer, Integer> engagedTo = new HashMap<>();
        List<Integer> freeGuys = new ArrayList<>();
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
