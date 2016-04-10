package ru.kpfu.itis.group11506.homework.stack;

public class Main {

    public static void main(String[] args) {
        int size = 10;
        boolean k = true;
        FixedSizeStack fixedSizeStack = new FixedSizeStack(size);
        String d = "{1+{2+(4[^{(5-8+43)*5}])}}";
        System.out.println(d);
        char[] dd = d.toCharArray();

        for (int index = 0; index < dd.length; index++) {
            if (dd[index] == '(' || dd[index] == '[' || dd[index] == '{') {
                fixedSizeStack.push(dd[index]);
            } else if (dd[index] == ')' || dd[index] == ']' || dd[index] == '}') {
                char c = (char) fixedSizeStack.poll();
                if (((dd[index] == ')') && (c == '(')) || ((dd[index] == '}') && (c == '{')) || ((dd[index] == ']') && (c == '['))) {

                } else {
                    k = false;
                    break;
                }
            }
        }
        if (k) {
            System.out.println("скобки раставлены павильно");
        } else System.out.println("ошибка в строке");
    }
}
