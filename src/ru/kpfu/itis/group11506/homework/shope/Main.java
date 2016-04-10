package ru.kpfu.itis.group11506.homework.shope;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();
        System.out.println("Enter 1 - If you need sports equipment or 2 - If you need electronics");
        product.sortingPrint(scanner.nextInt());

    }
}

