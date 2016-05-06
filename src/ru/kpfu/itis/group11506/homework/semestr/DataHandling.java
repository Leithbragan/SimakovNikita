package ru.kpfu.itis.group11506.homework.semestr;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataHandling {
    
    private static int total;
    private static int numberOfMen;
    private static int numberOfWomen;
    private static String[] m;
    private static String[] w;
    protected static String[] namesMen;
    protected static String[] namesWomen;
    protected static int[] idMen;
    protected static int[] idWomen;
    private static String[] selectionMen;
    private static String[] selectionWomen;
    protected static Map<Integer, List<Integer>> mapForMen = new HashMap<>();
    protected static Map<Integer, List<Integer>> mapForWomen = new HashMap<>();


    public static String readInputFile() throws IOException {
        String string = "";
        File f = new File("./src/ru/kpfu/itis/group11506/homework/semestr/Input.bin");
        try (FileReader reader = new FileReader(f)) {
            char[] buffer = new char[(int) f.length()];
            reader.read(buffer);
            string = new String(buffer);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return string;
    }

    public static void helper(String string) {
        int i = 0;
        String[] items = string.split(";\r\n");
        String[] newitems = items[0].split(", ");
        total = newitems.length;
        for (int n = 0; n < newitems.length; n++) {
            char[] b = newitems[n].toCharArray();
            if (b[b.length - 1] == 'm') {
                i++;
            }
        }
        numberOfMen = i;
        numberOfWomen = total - i;
    }

    public static void fileDivision(String string) {
        String[] men = new String[numberOfMen];
        String[] women = new String[numberOfWomen];
        int j = 0, i = 0;
        String[] items = string.split(";\r\n");
        String[] newitems = items[0].split(", ");
        for (int n = 0; n < newitems.length; n++) {
            char[] b = newitems[n].toCharArray();
            if (b[b.length - 1] == 'm') {
                men[i] = newitems[n];
                i++;
            } else {
                women[j] = newitems[n];
                j++;
            }
        }
        m = men;
        w = women;
    }

    public static void createBaze(String string) {
        //пременные для мужчин
        String menString = "";
        for (int i = 0; i < m.length; i++) {
            menString += m[i] + " ";
        }
        String[] ma = menString.split(" ");
        String[] menName = new String[m.length];
        int[] idM = new int[m.length];
        //переменные для женщин
        String womenString = "";
        for (int i = 0; i < m.length; i++) {
            womenString += w[i] + " ";
        }
        String[] wa = womenString.split(" ");
        String[] womenName = new String[w.length];
        //переменные для предпочтений
        String[] menS = new String[m.length];
        String[] womenS = new String[w.length];
        String sort = "";
        String[] items = string.split(";\r\n");
        String[] sortFirst = items[1].split("\r\n");
        String[] sortSecond;
        sortFirst[0] = sortFirst[0].replace("sort = ", "");
        for (int z = 0; z < total; z++) {
            sort += sortFirst[z] + " ";
        }
        sort = sort.replace("{", "");
        sort = sort.replace("}", "");
        sortSecond = sort.split(" ");
        //заполнение массивов для мужчин
        int k = 0;
        for (int i = 0; i < m.length * 3 - 2; i = i + 3) {
            menName[k] = ma[i];
            k++;
        }
        namesMen = menName;
        k = 0;
        for (int l = 1; l < m.length * 3 - 1; l = l + 3) {
            idM[k] = Integer.parseInt(ma[l]);
            k++;
        }
        idMen = idM;
        k = 0;
        for (int z = 0; z < total * 2 - 3; z = z + 2) {
            int gh = Integer.parseInt(sortSecond[z]);
            if (gh == idM[k]) {
                menS[k] = sortSecond[z + 1];
                k++;
            }
        }
        selectionMen = menS;
        //заполнение массивов для женщин
        k = 0;
        for (int i = 0; i < w.length * 3 - 2; i = i + 3) {
            womenName[k] = wa[i];
            k++;
        }
        namesWomen = womenName;
        k = 0;
        int[] idW = new int[numberOfWomen];
        for (int l = 1; l < w.length * 3 - 1; l = l + 3) {
            idW[k] = Integer.parseInt(wa[l]);
            k++;
        }
        idWomen = idW;
        k = 0;
        for (int z = 0; z < total * 2 - 1; z = z + 2) {
            int gh = Integer.parseInt(sortSecond[z]);
            if (gh == idW[k]) {
                womenS[k] = sortSecond[z + 1];
                k++;
                Map<Integer, List<Integer>> mapWomen = new HashMap<>();
            }
        }
        selectionWomen = womenS;
    }

    public static ArrayList<Integer> transfer(String selection) {
        List<Integer> listArray = new ArrayList<>();
        String[] helpString = selection.split(",");
        for (int j = 0; j < m.length; j++) {
            listArray.add(Integer.parseInt(helpString[j]));

        }
        return (ArrayList<Integer>) listArray;
    }

    public static void putInMap() {
        Map<Integer, List<Integer>> mapMen = new HashMap<>();
        Map<Integer, List<Integer>> mapWomen = new HashMap<>();
        for (int i = 0; i < m.length; i++) {
            mapMen.put(idMen[i], transfer(selectionMen[i]));

        }
        mapForMen = mapMen;
        for (int i = 0; i < w.length; i++) {
            mapWomen.put(idWomen[i], transfer(selectionWomen[i]));
        }
        mapForWomen = mapWomen;
    }

    private static void oops() {
        for (int i = 0; i < m.length; i++) {
            m1.add(idMen[i]);
        }
    }

    private static List<Integer> m1 = new LinkedList<>();

    public static void run() throws IOException {
        helper(readInputFile());
        fileDivision(readInputFile());
        createBaze(readInputFile());
        putInMap();
        oops();
        Magic.run(m1, mapForMen, mapForWomen, namesMen, namesWomen);
    }
}
