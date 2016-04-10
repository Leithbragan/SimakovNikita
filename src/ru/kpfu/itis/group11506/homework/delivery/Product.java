package ru.kpfu.itis.group11506.homework.delivery;

import java.util.Scanner;

public class Product {

    Menu[] menu = {new Menu("Салфетка", 0, 0),
            new Menu("Селедка под шубой", 150, 100),
            new Menu("Чизкейк", 250, 90),
            new Menu("Куриные крылья", 550, 400),
            new Menu("Стейк Рибай", 1350, 480),
            new Menu("Шницель", 390, 550),
            new Menu("Ролл Тунец", 170, 100),
            new Menu("Пицца закрытая", 350, 350),
            new Menu("Салат Цезарь", 200, 170),
            new Menu("Кола", 90, 25),
            new Menu("Картошка по-французски", 350, 350),
            new Menu("Сет Дракон", 2500, 1800),
            new Menu("Пицца Маргарита", 280, 550),
            new Menu("Бургер с картофелем", 390, 270),
            new Menu("Шаурма с сыром", 160, 200)};

    public void printMenu() {
        for (int index = 0; index < menu.length; index++) {
            System.out.println(index + menu[index].getName() + "\t" + menu[index].getShekel() + " рублей\t" + menu[index].getWeight() + " г");
        }
    }

    public double printTotalPrise() {
        String selection;
        double totalPrice = 0;
        double error = 0;
        int numberProduct = -1;
        while (numberProduct != 0) {
            Scanner scanner = new Scanner(System.in);
            selection = scanner.next();
            numberProduct = Integer.parseInt(selection);
            totalPrice += menu[numberProduct].getShekel();

        }
        error = totalPrice - menu[0].getShekel();
        return error;
    }
}
