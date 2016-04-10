package ru.kpfu.itis.group11506.homework.io;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Digits of randomness");
        System.out.println(Filling.getHeadOfProgramm());
        Filling.writeInputFile();
        System.out.println("Digits even");
        System.out.println(Filling.evenString(Filling.outputIntArray(Filling.readInputFile())));
        Filling.writeOutputFile(Filling.evenString(Filling.outputIntArray(Filling.readInputFile())));

    }


}
