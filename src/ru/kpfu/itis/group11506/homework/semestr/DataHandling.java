package ru.kpfu.itis.group11506.homework.semestr;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataHandling {

    /**
     * total - общее количество клиентов.
     * numberOfMen - количество мужчин.
     * numberOfWomen - количество женщин.
     * m - массив с данными только мужчин, без учета их предпочтений.
     * w - массив с данными только женщин, без учета их предпочтений.
     */
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

    /**
     * Input.bin - файл для считки.
     * В методе считываются из файла данные в массив char. Далее массив преобразуется в строку.
     * return string - строка с данными из файла.
     */
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

    /**
     * Метод для подсчета количества мужчин и женщин.
     * На вход принимает строку с танными клиентов.
     * split() -  разделяет считаную строку на два элемента массива строк String[] items.
     * Первый он же нулевой элемент массива строк с помощью метода split() разднляется на новый массив строк String[] newitems.
     * Статической переменой total присваевается значение длины массива newitems, так как количество элементов массива равно
     * общем количеству клиентов.
     * В цикле for пробегает по всем элементам массива String[] newitems преобразует в масив символов char[] b.
     * Каждый элемент массив символов char[] b проверяется на наличие символа 'm', если же такой есть счетчик увеличивается.
     * Скетчик приравнивается к статической переменной numberOfMen. Далее другой статической переменной numberOfWomen присваевается
     * число равное разности общего количества клиентов и количества клиентов мужского пола.
     */
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

    /**
     * Метод заполняет массивы
     * m - массив с данными только мужчин, без учета их предпочтений.
     * w - массив с данными только женщин, без учета их предпочтений.
     * На вход принимает строку с данными клиентов.
     * Два массива мужчин и женьщин
     * split() -  разделяет считаную строку на два элемента массива строк String[] items.
     * Первый он же нулевой элемент массива строк с помощью метода split() разднляется на новый массив строк String[] newitems.
     * В цикле for пробегает по всем элементам массива String[] newitems преобразует в масив символов char[] b.
     * Каждый элемент массив символов char[] b проверяется на наличие символа 'm', если же такой есть
     * элнмент масива строк String[] newitems приравнивается порядковому элементу локального массива мужчин String[] men,
     * иначе массиву женщин.
     * Локальные массивы приравниваются "глобальнвм" статическим.
     */
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

    /**
     * Строка с данными мужчин несет
     * вспомогательный характер для удобного использования split() метода, метод for создает из глобального массива с данными
     * строку с пробелами между клиетами, String[] ma массив строк после split().
     * Массивы  String[] menName и int[] idM с разделенными данными.
     * Три цикла for для заполнения массивов и класса массива. Для заполнения используется шаг 3 и для индексов
     * метод перевода в int, последний for Класс массив заполняется данными.(Аналогичные переменные для девушек).
     */
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
            }
        }
        selectionWomen = womenS;
    }

    public static void putInMap() {
        List<Integer> listArray = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            String[] helpString = selectionMen[i].split(",");
            for (int j = 0; j < w.length; j++) {
                listArray.add(Integer.parseInt(helpString[j]));
            }
            mapForMen.put(idMen[i], listArray);
            listArray.clear();
        }
        for (int i = 0; i < w.length; i++) {
            String[] helpString = selectionWomen[i].split(",");
            for (int j = 0; j < m.length; j++) {
                listArray.add(Integer.parseInt(helpString[j]));

            }
            mapForWomen.put(idWomen[i], listArray);
            listArray.clear();
        }
    }

    private static void oops() {
        for (int i = 0; i < m.length; i++) {
            m1.add(idMen[i]);
        }
    }

    public static List<Integer> m1 = new LinkedList<>();


    public static void run() throws IOException {
        helper(readInputFile());
        fileDivision(readInputFile());
        createBaze(readInputFile());
        putInMap();
        oops();
        Magic.run(m1, mapForMen, mapForWomen);
    }
}