package ru.kpfu.itis.group11506.homework.semestr;

import java.util.*;
import java.util.List;

// Вынести IO, выделить модель (data) в отдельный класс. Получать и записывать data вне core модуля
public class DataHandling {

    private String text;
    private int total;
    private int numberOfMen;
    private int numberOfWomen;
    private List<String> namesMen;
    private List<String> namesWomen;
    private List<Integer> idMen;
    private List<Integer> idWomen;
    private List<String> selectionMen;
    private List<String> selectionWomen;
    private Map<Integer, List<Integer>> mapForMen = new HashMap<>();
    private Map<Integer, List<Integer>> mapForWomen = new HashMap<>();

    public String elementStringArray(String string, int numberElement) {
        String[] items = string.split("; \r\n");
        return items[numberElement];
    }

    public String[] sortArray() {
        String sort = "";
        String[] sortFirst = elementStringArray(text, 1).split("\n");
        sortFirst[0] = sortFirst[0].replace("sort = ", "");
        for (int z = 0; z < total; z++) {
            sort += sortFirst[z] + " ";
        }
        sort = sort.replace("{", "");
        sort = sort.replace("}", "");
        String[] sortArray = sort.split(" ");
        return sortArray;
    }

    public String createString(String[] stringArray) {
        String string = "";
        for (int i = 0; i < numberOfMen; i++) {
            string += stringArray[i] + " ";
        }
        return string;
    }

    public String[] initialization(int size, char gender) {
        String[] items = elementStringArray(text, 0).split(", ");
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

    public List<String> names(String[] clients, int size) {
        List<String> namesClients = new ArrayList<>();
        for (int i = 0; i < size * 3 - 2; i = i + 3) {
            namesClients.add(clients[i]);
        }
        return namesClients;
    }

    public List<Integer> ids(String[] clients, int size) {
        List<Integer> idsClients = new ArrayList<>();
        for (int l = 1; l < size * 3 - 1; l = l + 3) {
            idsClients.add(Integer.parseInt(clients[l]));
        }
        return idsClients;
    }

    private char lastLetter() {
        String data = elementStringArray(text, 0);
        char[] dataCharArray = data.toCharArray();
        return dataCharArray[dataCharArray.length - 1];
    }

    public List<String> sortArray(char letter, String[] sortArray, List<Integer> ids) {
        List<String> selectiveSorting = new ArrayList<>();
        int condition, k = 0;
        char let = lastLetter();
        if (Objects.equals(letter, let)) {
            condition = 1;
        } else {
            condition = 3;
        }
        for (int z = 0; z < total * 2 - condition; z = z + 2) {
            int gh = Integer.parseInt(sortArray[z]);
            if (gh == ids.get(k)) {
                selectiveSorting.add(sortArray[z + 1]);
                k++;
            }
        }
        return selectiveSorting;
    }

    public void helper() {
        String[] newitems = elementStringArray(text, 0).split(", ");
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

    public void createBaze() {
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
        selectionMen = sortArray('m', sortSecond, idMen);
        //заполнение массивов для женщин
        namesWomen = names(wa, numberOfWomen);
        idWomen = ids(wa, numberOfWomen);
        selectionWomen = sortArray('f', sortSecond, idWomen);
    }

    public ArrayList<Integer> transfer(String selection, int size) {
        List<Integer> listArray = new ArrayList<>();
        String[] oneSelectionArray = selection.split(",");
        for (int j = 0; j < size; j++) {
            listArray.add(Integer.parseInt(oneSelectionArray[j]));
        }
        return (ArrayList<Integer>) listArray;
    }

    public void putInMap() {
        for (int i = 0; i < numberOfMen; i++) {
            mapForMen.put(idMen.get(i), transfer(selectionMen.get(i), numberOfMen));
        }

        for (int i = 0; i < numberOfWomen; i++) {
            mapForWomen.put(idWomen.get(i), transfer(selectionWomen.get(i), numberOfWomen));
        }
    }


    public List<Integer> getIdMen() {
        return idMen;
    }

    public List<Integer> getIdWomen() {
        return idWomen;
    }

    public List<String> getNamesWomen() {
        return namesWomen;
    }

    public List<String> getNamesMen() {
        return namesMen;
    }

    public Map<Integer, List<Integer>> getMapForMen() {
        return mapForMen;
    }

    public Map<Integer, List<Integer>> getMapForWomen() {
        return mapForWomen;
    }

    public void setText(String text) {
        this.text = text;
    }
}