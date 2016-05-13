package ru.kpfu.itis.group11506.homework.semestr;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class DataHandling {

    private static int total;
    private static int numberOfMen;
    private static int numberOfWomen;
    private static List<String> namesMen;
    private static List<String> namesWomen;
    private static List<Integer> idMen;
    private static List<Integer> idWomen;
    private static List<String> selectionMen;
    private static List<String> selectionWomen;
    private static Map<Integer, List<Integer>> mapForMen = new HashMap<>();
    private static Map<Integer, List<Integer>> mapForWomen = new HashMap<>();


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

    public static String elementStringArray(String string, int numberElement) {
        String[] items = string.split(";\r\n");
        return items[numberElement];
    }

    public static String[] sortArray() throws IOException {
        String sort = "";
        String[] sortFirst = elementStringArray(readInputFile(), 1).split("\r\n");
        sortFirst[0] = sortFirst[0].replace("sort = ", "");
        for (int z = 0; z < total; z++) {
            sort += sortFirst[z] + " ";
        }
        sort = sort.replace("{", "");
        sort = sort.replace("}", "");
        String[] sortArray = sort.split(" ");
        return sortArray;
    }

    public static String createString(String[] stringArray) {
        String string = "";
        for (int i = 0; i < numberOfMen; i++) {
            string += stringArray[i] + " ";
        }
        return string;
    }

    public static String[] initialization(int size, char gender) throws IOException {
        String[] items = elementStringArray(readInputFile(), 0).split(", ");
        int i = 0;
        String[] strings = new String[size];
        for (int n = 0; n < items.length; n++) {
            char[] b = items[n].toCharArray();
            if (b[b.length - 1] == gender) {
                strings[i] = items[n];
                i++;
            }

        }
        return strings;
    }

    public static List<String> names(String[] clients, int size) {
        List<String> namesClients = new ArrayList<>();
        for (int i = 0; i < size * 3 - 2; i = i + 3) {
            namesClients.add(clients[i]);
        }
        return namesClients;
    }

    public static List<Integer> ids(String[] clients, int size) {
        List<Integer> idsClients = new ArrayList<>();
        for (int l = 1; l < size * 3 - 1; l = l + 3) {
            idsClients.add(Integer.parseInt(clients[l]));
        }
        return idsClients;
    }

    private static char lastLetter() throws IOException {
        String data = elementStringArray(readInputFile(), 0);
        char[] dataCharArray = data.toCharArray();
        return dataCharArray[dataCharArray.length - 1];
    }

    public static List<String> sortA(String letter, String[] sortArray) throws IOException {
        List<String> selectiveSorting = new ArrayList<>();
        int condition, k = 0;
        if (Objects.equals(letter, lastLetter())) {
            condition = 1;
        } else {
            condition = 3;
        }
        for (int z = 0; z < total * 2 - condition; z = z + 2) {
            int gh = Integer.parseInt(sortArray[z]);
            if (gh == idMen.get(k)) {
                selectiveSorting.add(sortArray[z+1]);
                k++;
            }
        }
        return selectiveSorting;
    }

    public static void helper() throws IOException {
        String[] newitems = elementStringArray(readInputFile(), 0).split(", ");
        total = newitems.length;
        for (int n = 0; n < newitems.length; n++) {
            char[] b = newitems[n].toCharArray();
            if (b[b.length - 1] == 'm') {
                numberOfMen++;
            } else {
                numberOfWomen++;
            }
        }
    }

    public static void createBaze() throws IOException {
        //пременные для мужчин
        String menString = createString(initialization(numberOfMen, 'm'));
        String[] ma = menString.split(" ");
        //переменные для женщин
        String womenString = createString(initialization(numberOfWomen, 'f'));
        String[] wa = womenString.split(" ");
        //переменные для предпочтений
        String[] sortSecond = sortArray();
        //заполнение массивов для мужчин
        namesMen = names(ma, numberOfMen);
        idMen = ids(ma, numberOfMen);
        selectionMen = sortA("m", sortSecond);
        //заполнение массивов для женщин
        namesWomen = names(wa, numberOfWomen);
        idWomen = ids(wa, numberOfWomen);
        selectionWomen = sortA("f", sortSecond);
    }

    public static ArrayList<Integer> transfer(String selection, int size) {
        List<Integer> listArray = new ArrayList<>();
        String[] oneSelectionArray = selection.split(",");
        for (int j = 0; j < numberOfMen; j++) {
            listArray.add(Integer.parseInt(oneSelectionArray[j]));
        }
        return (ArrayList<Integer>) listArray;
    }

    public static void putInMap() {
        for (int i = 0; i < numberOfMen; i++) {
            mapForMen.put(idMen.get(i), transfer(selectionMen.get(i), numberOfMen));
        }

        for (int i = 0; i < numberOfWomen; i++) {
            mapForWomen.put(idWomen.get(i), transfer(selectionWomen.get(i),numberOfWomen));
        }
    }

    public static void run() throws IOException {
        helper();
        createBaze();
        putInMap();
        Magic.run(idMen, mapForMen, mapForWomen, namesMen, namesWomen);
    }

    public static List<Integer> getIdMen() {
        return idMen;
    }

    public static List<Integer> getIdWomen() {
        return idWomen;
    }
}
