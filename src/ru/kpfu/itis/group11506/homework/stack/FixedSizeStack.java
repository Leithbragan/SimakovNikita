package ru.kpfu.itis.group11506.homework.stack;

import java.util.Iterator;

public class FixedSizeStack<T> implements Stack<T> {

    public T[] fixArrayBegin;

    public FixedSizeStack(int size) {
        fixArrayBegin = (T[]) new Object[size];
    }

    @Override
    public void push(T t) {
        for (int index = 0; index < fixArrayBegin.length - 1; index++) {
            if (fixArrayBegin[index] == null && fixArrayBegin[index + 1] == null) {
                fixArrayBegin[index] = t;
                break;
            }
        }

    }

    @Override
    public T poll() {
        for (int index = 0; index < fixArrayBegin.length - 1; index++) {
            if (fixArrayBegin[index] != null && fixArrayBegin[index + 1] == null) {
                T t = fixArrayBegin[index];
                fixArrayBegin[index] = null;
                return t;
            }
        }
        return null;
    }

    @Override
    public T peek() {
        for (int index = 0; index < fixArrayBegin.length - 1; index++) {
            if (fixArrayBegin[index] != null && fixArrayBegin[index + 1] == null) {
                return fixArrayBegin[index];
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
