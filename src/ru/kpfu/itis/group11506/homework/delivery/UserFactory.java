package ru.kpfu.itis.group11506.homework.delivery;
import java.util.Scanner;

public class UserFactory {

    public static int MAX_TRY = 10;

    public static void purchaseReceipt(double shekel) {
        System.out.println("Это ваш чек, вы можете его распечатать");
        decoration();
        decoration();
        System.out.println("город Казань\nул. " + User.getStreet() + "\nдом " + User.getHome() + "\nкв. " + User.getFlat() + "\nтел. " + User.getNumber() + "\n" + User.getName());
        System.out.println("Итоговая цена к оплате " + shekel + " руб.");
        decoration();
        decoration();

    }

    public static User createUser() throws UserInputException {
        Scanner scanner = new Scanner(System.in);
        boolean hasInputNumber = false;
        boolean hasInputName = false;
        boolean hasInputCard = false;
        boolean hasInputHome = false;
        String number = null;
        String name = null;
        String numberCard = null;
        String street = null;
        String home = null;
        String flat = null;
        decoration();
        System.out.println("Заполните обязательные поля своей личной информации\n" +
                "Вводите пожалуйста корректную информацию с первого раза\nЭто облегчит нашу работу и ускорит время доставки");
        decoration();
        for (int tryIndex = 0; tryIndex < MAX_TRY && !hasInputNumber && !hasInputName && !hasInputCard && !hasInputHome; tryIndex++) {
            for (tryIndex = 0; tryIndex < MAX_TRY && !hasInputNumber; tryIndex++) {
                System.out.println("Введите номер телефона");
                try {
                    number = getPhoneNumber(scanner);
                    hasInputNumber = true;
                    decoration();
                } catch (UserInputException exception) {
                    exception.printStackTrace();
                    System.err.println("Неправильный ввод данных: " + exception.getMessage());
                }
            }
            for (tryIndex = 0; tryIndex < MAX_TRY && !hasInputName; tryIndex++) {
                System.out.println("Введите ваше имя");
                try {
                    name = getName(scanner);
                    hasInputName = true;
                } catch (UserInputException exception) {
                    exception.printStackTrace();
                    System.err.println("Неправильный ввод данных" + exception.getMessage());
                }
                decoration();
            }
            for (tryIndex = 0; tryIndex < MAX_TRY && !hasInputCard; tryIndex++) {
                System.out.println("Введите номер вашей кредитной карты");
                try {
                    numberCard = getNumberCreditCard(scanner);
                    hasInputCard = true;
                } catch (UserInputException exception) {
                    exception.printStackTrace();
                    System.err.println("Неправильный ввод данных" + exception.getMessage());
                }
                decoration();
            }

            System.out.println("Введите улицу");
            street = scanner.next();
            decoration();

            for (tryIndex = 0; tryIndex < MAX_TRY && !hasInputHome; tryIndex++) {
                System.out.println("Введите номер дома");
                try {
                    home = getHome(scanner);
                    hasInputHome = true;
                } catch (UserInputException exception) {
                    exception.printStackTrace();
                    System.err.println("Неправильный ввод данных" + exception.getMessage());
                }
                decoration();
            }

            System.out.println("Введите номер квартры");
            flat = scanner.next();
            decoration();

        }
        return new User(name, number, numberCard, street, home, flat);
    }


    private static String getPhoneNumber(Scanner scanner) throws UserInputException {
        String userInput = scanner.next();

        int inputSize = userInput.length();
        if (inputSize != 11 && inputSize != 7) {
            throw new UserInputException("Неправильная длина телефонного номера");
        }
        return userInput;
    }

    private static String getName(Scanner scanner) throws UserInputException {
        String userInput = scanner.next();

        char[] nameArray;
        nameArray = userInput.toCharArray();
        char[] value = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int indexOfString = 0; indexOfString < nameArray.length; indexOfString++) {
            for (int index0fValue = 0; index0fValue < value.length; index0fValue++) {
                if (nameArray[indexOfString] == value[index0fValue]) {
                    throw new UserInputException("Наличие в имени некорректных символов");
                }
            }
        }

        return userInput;
    }

    public static String getNumberCreditCard(Scanner scanner) throws UserInputException {
        String userInput = scanner.next();
        int inputSize = userInput.length();
        if (inputSize != 16) {
            throw new UserInputException("Неправильная длина номера кредитной карты");
        }
        return userInput;
    }

    private static String getHome(Scanner scanner) throws UserInputException {
        String userInput = scanner.next();

        int number = Integer.parseInt(userInput);
        if (number > 300 || number < 1) {
            throw new UserInputException("Такого дома нет");
        }
        return userInput;
    }

    public static void decoration() {
        System.out.println("********************************************************");
    }
}
