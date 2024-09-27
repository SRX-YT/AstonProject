package util;

import presentation.AppMenu;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * Утилитный класс с общими для всего приложения методами id.<br>
 */
public class AppUtils {

    private AppUtils() {
        throw new UnsupportedOperationException("AppUtils - это утилитарный класс, " +
                "экземпляр не может быть создан!");
    }

    /**
     * Промптер без выводящегося сообщения.
     *
     * @return возвращает вводимую через консоль строку.
     */
    public static String promptWithOutMessage() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    /**
     * Промптер с выводящимся пользователю сообщением.
     *
     * @param message - сообщение пользователю.
     * @return - возвращает вводимую через консоль строку.
     */
    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    /**
     * Парсер с выводящимся сообщением об ошибке.
     *
     * @param input        входная строка.
     * @param errorMessage потенциально выводимое сообщение об ошибке.
     * @return при успешном парсинге возвращает int, иначе выводит сообщение об ошибке.
     */
    public static int parseInteger(String input, String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
            return 0;
        }
    }

    /**
     * Валидатор числового ввода - не отпустит, пока не сделан правильный выбор ;)
     *
     * @param leftBound  левая граница.
     * @param rightBound правая граница.
     * @param appMenu    объект {@link AppMenu}
     * @param menuType   конкретное значение меню.
     * @return при валидном вводе возвращает int.
     */
    public static int getValidPrompt(int leftBound, int rightBound, AppMenu appMenu, AppMenu.MenuType menuType) {
        int dataInputChoice = appMenu.showMenu(menuType);
        while (dataInputChoice < leftBound || dataInputChoice > rightBound) {
            System.out.println("\nНекорректный выбор. Повторите.");
            dataInputChoice = appMenu.showMenu(menuType);
        }
        return dataInputChoice;
    }

    /**
     * Локальный валидатор числового ввода.
     *
     * @param dataInputChoice выбор пользователя.
     * @return при успехе возвращает int, иначе не отпустит.
     */
    public static int getValidLocalPrompt(int dataInputChoice) {
        while (dataInputChoice == 0) {
            dataInputChoice = parseInteger(promptWithOutMessage(), "Опять мимо.");
        }
        return dataInputChoice;
    }

    /**
     * Метод для проверки наличия файла.
     * @param fileName название файла.
     * @return true/false.
     */
    public static boolean isValidFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.printf("\nФайл \"%s\" не найден.\n", fileName);
            return false;
        }
        return true;
    }

    /**
     * Метод для проверки пустой ли ли список.
     * @param products входящий список.
     * @return true/false.
     */
    public static boolean isListEmpty(List<?> products) {
        if (products.isEmpty()) {
            System.out.println("Выводить нечего.");
            return true;
        } else {
            System.out.println("\nПолученные данные: ");
            products.forEach(System.out::println);
            return false;
        }
    }

    /**
     * Проверяет наличие данных в файле для считывания.
     * @param lines входящий список.
     * @param dataInputChoice входящий пользовательский выбор.
     * @return int выбор пользователя.
     */
    public static int getEnoughData(List<?> lines, int dataInputChoice) {
        if(lines.isEmpty()){
            System.out.println("Ошибка: нет данных для считывания.");
            return 0;
        } else {
            while (dataInputChoice <= 0 || dataInputChoice > lines.size()) {
                System.out.println("Ошибка: данных в файле недостаточно. Попробуйте указать иное количество.");
                dataInputChoice = parseInteger(promptWithOutMessage(), "Опять 25...");
            }
            return dataInputChoice;
        }
    }
}