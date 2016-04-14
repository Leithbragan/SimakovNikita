package ru.kpfu.itis.group11506.homework.stringIO;

import java.io.*;

public class FileFinder {


    public void searchFile(String s) {
        File file = new File(s);
        if (file.exists()) {
            System.out.println("такой файл есть");
        } else {
            System.out.println("Файл отсутствует");
        }
    }


    public void searchText(String allinPath, String sText) {
        FileReader fileReader = null;
        try {
            File file = new File(allinPath);
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.err.println("файл не найден");
        }
        assert fileReader != null;
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        try {
            while ((s = bufferedReader.readLine()) != null) {
                if (s.contains(sText)) {
                    System.out.println("Ваш текст есть в файле");
                } else {
                    System.out.println("Текст, который вы ищите, отсутствует");
                }
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

}
