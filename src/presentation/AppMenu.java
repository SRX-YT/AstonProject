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
        SORTING_MENU
    }

    private final Map<MenuType, List<String>> menus = new HashMap<>();

    public AppMenu() {
        menus.put(MenuType.MAIN_MENU, Arrays.asList(
                "\nВыберите действие:",
                "1. Выбор метода ввода данных",
                "2. Выбор алгоритма сортировки",
                "3. Выполнить бинарный поиск",
                "4. Выйти"
        ));

        menus.put(MenuType.DATA_INPUT_MENU, Arrays.asList(
                "\nВыберите способ ввода данных:",
                "1. Из файла",
                "2. Вручную",
                "3. Случайным образом"
        ));

        menus.put(MenuType.PRODUCT_CHOICE_MENU, Arrays.asList(
                "\nВыберите вид продукта:",
                "1. Авто",
                "2. Книга",
                "3. Корнеплод (чтоб его за ногу)"
        ));

        menus.put(MenuType.SORTING_MENU, Arrays.asList(
                "\nКак сортировать:",
                "1. MergeSort",
                "2. MergeSort по четным"
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