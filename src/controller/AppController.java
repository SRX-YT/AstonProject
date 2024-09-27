package controller;

import presentation.AppMenu;
import service.AppService;
import util.AppUtils;

import java.io.IOException;
import java.util.*;

/**
 * Класс-контроллер приложения. Осуществляет взаимодействие между пользователем и логикой.
 */

public class AppController {
    private final AppMenu appMenu;
    private final AppService appService;

    public AppController(AppMenu appMenu, AppService appService) {
        this.appMenu = appMenu;
        this.appService = appService;
    }

    public void run() {

        Map<Integer, List<?>> products = new HashMap<>();

        boolean exit = false;
        while (!exit) {
            int choice = AppUtils.getValidPrompt(1, 4, appMenu,
                    AppMenu.MenuType.MAIN_MENU);

            switch (choice) {
                case 1 -> {
                    try {
                        products.clear();
                        choice = AppUtils.getValidPrompt(1, 3, appMenu,
                                AppMenu.MenuType.DATA_INPUT_MENU);
                        List<?> objects = appService.getHandleDataInput(choice);
                        if (!AppUtils.isListEmpty(objects)) {
                            products.put(0, objects);
                        }
                    } catch (IOException e) {
                        System.out.println("\nОшибка ввода данных: " + e.getMessage());
                        System.out.println("Пожалуйста, повторите ввод.");
                    }
                }
                case 2 -> {
                    if (!products.containsKey(0)) {
                        System.out.println("\nСначала следует заполнить список.");
                    } else {
                        choice = AppUtils.getValidPrompt(1, 2, appMenu,
                                AppMenu.MenuType.SORTING_MENU);
                        switch (choice) {
                            case 1 -> {
                                products.put(1, appService.getHandleSorting(products.get(0), choice));
                                products.get(1).forEach(System.out::println);
                            }
                            case 2 -> {
                                if (!products.containsKey(1)) {
                                    products.put(2, appService.getHandleSorting(products.get(0), choice));
                                    products.get(2).forEach(System.out::println);
                                } else {
                                    List<?> temp = products.get(0);
                                    products.put(2, appService.getHandleSorting(temp, choice));
                                    temp.forEach(System.out::println);
                                }
                            }
                            default -> System.out.println("\nНекорректный выбор. Повторите.");
                        }
                    }
                }
                case 3 -> {
                    if (!products.containsKey(0)) {
                        System.out.println("\nСначала следует заполнить список.");
                    } else if (!products.containsKey(1)) {
                        System.out.println("\nСначала следует отсортировать список через MergeSort.");
                    } else {
                        appService.getHandleBinarySearch(products.get(1));
                    }
                }
                case 4 -> exit = true;
                default -> System.out.println("Некорректный выбор. Повторите.");
            }
        }
    }
}