package ru.kpfu.itis.group11506.homework.ListMortality;

import java.io.*;

public class Filling {


    public String readInputFile() throws IOException {
        String st = "";
        File f = new File("./src/ru/kpfu/itis/group11506/homework/ListMortality/Input.bin");
        try (FileReader reader = new FileReader(f)) {
            char[] buffer = new char[(int) f.length()];
            reader.read(buffer);
            st = new String(buffer);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return st;
    }

    public String[] stringsOfList(String string) {
        String[] strings = string.split("\r\n");
        return strings;
    }

    public int[] stringToIntArray(String string) {

        String[] items = string.split("\r\n");
        String ss = "";
        for (int i = 0; i < items.length; i++) {
            ss += items[i] + " ";
        }
        String[] newitems = ss.split(" ");
        int[] rr = new int[newitems.length];
        for (int i = 0; i < newitems.length; i++) {
            try {
                rr[i] = Integer.parseInt(newitems[i]);
            } catch (NumberFormatException nfe) {
            }
        }
        return rr;
    }

    public int valueV(int[] newitems) {
        int value = 0;

        for (int index = 0; index < newitems.length; index++) {

            if (value < newitems[index]) {
                value = newitems[index];
            }
        }

        return value + 1;
    }

    public int[][] createMatrix(int size, String[] strings) {
        String[] newStrings = new String[size];
        int[][] matrixMortality = new int[size][size];
        int[] arrayBuffer = new int[size];
        for (int i = 0; i < size; i++) {
            newStrings[i] = strings[i].replaceAll(" ", "");
            char[] chars = newStrings[i].toCharArray();
            if (chars[0] == '0') {
                arrayBuffer[i] = Integer.parseInt(newStrings[i]) * 10;
            } else {
                arrayBuffer[i] = Integer.parseInt(newStrings[i]);
            }
        }
        for (int i = 0; i < size; i++) {
            char[] chars;
            chars = String.valueOf(arrayBuffer[i]).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != 0) {
                    matrixMortality[i][Character.getNumericValue(chars[j])] = 1;
                } else {
                    matrixMortality[i][Character.getNumericValue(chars[j])] = 0;
                }
            }
        }
        return matrixMortality;
    }

    public void printLine(int[][] matrixMortality, int size){
        for (int i = 0; i < size; i++) {
            System.out.println("Вершина " + (i + 1));
            for (int j = 0; j < size; j++) {
                if (matrixMortality[i][j] != 0){
                    System.out.println("смежна с " + (j + 1));
                }

            }
        }
    }

}
