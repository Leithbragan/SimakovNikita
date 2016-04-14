package ru.kpfu.itis.group11506.homework.stringIO;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Recognizer recognizer = new Recognizer(args);
        FileFinder fileFinder = new FileFinder();
        recognizer.recognizer();
        System.out.println(recognizer.fullPath());
        fileFinder.searchFile(recognizer.fullPath());
        fileFinder.searchText(recognizer.fullPath(), recognizer.getText());
    }
}
