package ru.kpfu.itis.group11506.homework.ListMortality;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Filling filling = new Filling();
        filling.printLine(filling.createMatrix(filling.valueV(filling.stringToIntArray(filling.readInputFile())), filling.stringsOfList(filling.readInputFile())), filling.valueV(filling.stringToIntArray(filling.readInputFile())));
    }

}
