package ru.kpfu.itis.group11506.homework.io;

import java.io.*;
import java.util.Random;

public class Filling {

    private static String headOfProgramm = randomNumber();

    public static String getHeadOfProgramm() {
        return headOfProgramm;
    }

    public static String randomNumber() {
        Random random = new Random();
        String randomAllNumberString = "";
        for (int index = 0; index < 100; index++) {
            String rep = Integer.toString(random.nextInt(1000) + 1);
            randomAllNumberString += rep + "; ";
        }
        return randomAllNumberString;
    }

    public static void writeInputFile() {

        byte[] byteArrayWhichOutputInTxTFile = headOfProgramm.getBytes();

        try (DataOutputStream bos = new DataOutputStream(new FileOutputStream(
                        new File("./src/ru/kpfu/itis/group11506/homework/io/Input.bin")))) {

            bos.write(byteArrayWhichOutputInTxTFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int lineOfArray() {
        byte[] byteArrayWhichOutputInTxTFile = headOfProgramm.getBytes();
        return byteArrayWhichOutputInTxTFile.length;
    }

    public static String readInputFile() throws IOException {
        byte[] bufferArray = new byte[lineOfArray()];
        String string = "";
        try (DataInputStream bos = new DataInputStream(
                new FileInputStream(
                        new File("./src/ru/kpfu/itis/group11506/homework/io/Input.bin")))) {

            bos.read(bufferArray);

            string = new String(bufferArray);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static void writeOutputFile(String stringForOutput) {

        byte[] byteArrayWhichInOutputFile = stringForOutput.getBytes();

        try (DataOutputStream bos = new DataOutputStream(new FileOutputStream(
                        new File("./src/ru/kpfu/itis/group11506/homework/io/Output.bin")))) {

            bos.write(byteArrayWhichInOutputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int[] outputIntArray(String numbers) {

        String arr = numbers;
        String[] items = arr.split("; ");

        int[] results = new int[100];
        for (int i = 0; i < items.length; i++) {
            try {

                results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
            }
        }
        int l = 0;
        int[] even = new int[100];
        for (int index = 0; index < results.length; index++) {
            if (results[index] % 2 != 0) {
                even[l] = results[index];
                l++;
            }
        }


        return even;
    }

    public static String evenString(int[] even) {
        String evenString = "";

        for (int index = 0; index < 100; index++) {
            if (even[index] == 0){
                break;
            }

            String rep = Integer.toString(even[index]);
            evenString += rep + "; ";


        }
        return evenString;
    }
}