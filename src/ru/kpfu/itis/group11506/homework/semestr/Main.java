package ru.kpfu.itis.group11506.homework.semestr;

import java.io.IOException;

public class Main {

    // Нормальные наименования пакетов
    public static void main(String[] args) throws IOException {

        DataHandling dataHandling = new DataHandling();
        Algorithm alg = new Algorithm();
        InteractionWithText interaction = new InteractionWithText();

        interaction.writeFile(interaction.createFile(args));
        dataHandling.setText(interaction.readFile());
        dataHandling.helper();
        dataHandling.createBaze();
        dataHandling.putInMap();
        alg.printCouples(dataHandling.getIdMen(),dataHandling.getIdWomen(), dataHandling.getMapForMen(), dataHandling.getMapForWomen(), dataHandling.getNamesMen(), dataHandling.getNamesWomen());
    }
}
