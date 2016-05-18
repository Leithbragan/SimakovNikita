package ru.kpfu.itis.group11506.homework.semestr;

import java.io.*;
import java.util.Objects;

public class InteractionWithText {

    public String readFile() throws IOException {
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

    public void writeFile(String data) {

        byte[] dataByteArray = data.getBytes();

        try (DataOutputStream bos = new DataOutputStream(new FileOutputStream(
                new File("./src/ru/kpfu/itis/group11506/homework/semestr/Input.bin")))) {

            bos.write(dataByteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String createFile(String[] args) {
        String data = "";
        int i = 0;
        while (!Objects.equals(args[i], "sort")) {
            data += args[i] + " ";
            i++;
        }
        data += "\r\n";
        while (!Objects.equals(args[i], ".")) {
            if (i % 2 != 0 && i > 31) {
                data += args[i] + "\n";
            } else {
                data += args[i] + " ";
            }
            i++;
        }
        return data;
    }
}
