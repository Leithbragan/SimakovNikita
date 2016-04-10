package ru.kpfu.itis.group11506.homework.delivery;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        product.printMenu();
        System.out.println("Введите номера тех блюд, которые вы хотите заказать, как сделаете свой выбор введите 0 для завершения выбора");
        double prise = product.printTotalPrise();
        try {
            UserFactory.createUser();
        } catch (UserInputException e) {
            System.err.println("Ошибка пользовательского ввода: " + e.getMessage());
            e.printStackTrace();
        }
        UserFactory.purchaseReceipt(prise);
    }
}
