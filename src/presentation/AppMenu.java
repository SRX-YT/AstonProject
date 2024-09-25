package presentation;

import util.AppUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppMenu {
    public enum MenuType {
        MAIN_MENU,
        DATA_INPUT_MENU,
        PRODUCT_CHOICE_MENU,
        SORTING_MENU,
        CAR_FILED_CHOICE,
        BOOK_FILED_CHOICE,
        ROOT_CROP_FIELD_CHOICE,
        ASCENDING_CHOICE
    }

    private final Map<MenuType, List<String>> menus = new HashMap<>();

    public AppMenu() {
        menus.put(MenuType.MAIN_MENU, Arrays.asList(
                "Выберите действие:",
                "1. Выбор метода ввода данных",
                "2. Выбор алгоритма сортировки",
                "3. Выполнить бинарный поиск",
                "4. Выйти"
        ));

        menus.put(MenuType.DATA_INPUT_MENU, Arrays.asList(
                "Выберите способ ввода данных:",
                "1. Из файла",
                "2. Вручную",
                "3. Случайным образом"
        ));

        menus.put(MenuType.PRODUCT_CHOICE_MENU, Arrays.asList(
                "Выберите вид продукта:",
                "1. Авто",
                "2. Книга",
                "3. Корнеплод (чтоб его за ногу)"
        ));
        menus.put(MenuType.CAR_FILED_CHOICE, Arrays.asList(
                "Выберите поле продукта:",
                "1. Модель",
                "2. Мощность",
                "3. Год выпуска"
        ));

        menus.put(MenuType.BOOK_FILED_CHOICE, Arrays.asList(
                "Выберите поле продукта:",
                "1. Автор",
                "2. Название",
                "3. Кол-во страниц"
        ));

        menus.put(MenuType.ROOT_CROP_FIELD_CHOICE, Arrays.asList(
                "Выберите поле продукта:",
                "1. Тип корнеплода",
                "2. Вес корнеплода",
                "3. Цвет корнеплода"
        ));

        menus.put(MenuType.ASCENDING_CHOICE, Arrays.asList(
                "Как сортировать:",
                "1. По возрастанию",
                "2. По убыванию"
        ));

    }

    public int showMenu(MenuType menuType) {
        List<String> menuItems = menus.get(menuType);
        for (String item : menuItems) {
            System.out.println(item);
        }
        return AppUtils.parseInteger(AppUtils.promptWithOutMessage(), "Ввод должен быть числом.");
    }
}