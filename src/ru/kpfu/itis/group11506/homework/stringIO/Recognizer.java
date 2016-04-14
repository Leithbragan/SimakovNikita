package ru.kpfu.itis.group11506.homework.stringIO;

import java.util.Objects;

public class Recognizer {

    private String[] args = null;
    private String path = null;
    private String nameFile = null;
    private String text = null;

    public String fullPath() {
        String fullPath = path + "\\" + nameFile;
        return fullPath;
    }

    public Recognizer(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public String getText() {
        return text;
    }

    public void recognizer() {
        for (int index = 0; index < args.length; index++) {
            if (Objects.equals(args[index], "-p")) {
                path = args[index + 1];
            }
            if (Objects.equals(args[index], "-c")) {
                text = args[index + 1];
            }
            if (Objects.equals(args[index], "-n")) {
                nameFile = args[index + 1];
            }
        }
    }
}
