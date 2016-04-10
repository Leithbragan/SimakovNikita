package ru.kpfu.itis.group11506.homework.stack;

public interface Stack<T> extends Iterable<T> {

    void push(T t);

    T poll();

    T peek();

}
