package service;

import presentation.AppMenu;
import service.strategy.input.DataInputter;
import service.strategy.input.InputStrategy;
import service.strategy.input.FileNameSetable;
import service.strategy.input.ParseSetable;
import service.strategy.input.impl.FileInputStrategy;
import service.strategy.input.impl.ManualInputStrategy;
import service.strategy.input.impl.RandomInputStrategy;
import util.AppUtils;

import java.io.IOException;
import java.util.List;

import static util.AppUtils.*;
import static util.StrategyGetterUtil.*;

/**
 * Утильный класс с методами для основной логики.
 */
public class AppService {

    private final AppMenu appMenu;

    public AppService(AppMenu appMenu) {
        this.appMenu = appMenu;
    }

    public void getHandleDataInput(int inputChoice) throws IOException {

        List<?> products;
        DataInputter<?> strategy;

        switch (inputChoice) {
            case 1 -> {
                strategy = getInputStrategies(1);
                InputStrategy<?> inputStrategy = strategy.getInputStrategy();
                String fileName = prompt("Введите наименование файла: \n");
                if (inputStrategy instanceof FileInputStrategy<?>) {
                    ((FileNameSetable) inputStrategy).setFileName(fileName);
                } else {
                    throw new UnsupportedOperationException("Что-то напутано в методе выбора стратегии ввода.");
                }

                int productId = appMenu.showMenu(AppMenu.MenuType.PRODUCT_CHOICE_MENU);
                ((ParseSetable) inputStrategy).setParseStrategy(getParseStrategies(productId));

                int count = AppUtils.parseInteger(prompt("Введите кол-во считываемых элементов: \n"), "Ввод должен быть числом");
                products = strategy.getInputData(count);
            }
            case 2 -> {
                strategy = getInputStrategies(2);
                InputStrategy<?> inputStrategy = strategy.getInputStrategy();
                int productId = appMenu.showMenu(AppMenu.MenuType.PRODUCT_CHOICE_MENU);

                if (inputStrategy instanceof ManualInputStrategy<?>) {
                    ((ManualInputStrategy<?>) inputStrategy).setParseStrategy(getParseStrategies(productId));
                    ((ManualInputStrategy<?>) inputStrategy).setPromptStrategy(getPromptStrategies(productId));
                } else {
                    throw new UnsupportedOperationException("Что-то напутано в методе выбора стратегии ввода.");
                }

                int count = AppUtils.parseInteger(prompt("Введите кол-во вводимых элементов: \n"), "Ввод должен быть числом");
                products = strategy.getInputData(count);
            }
            case 3 -> {
                strategy = getInputStrategies(3);
                InputStrategy<?> inputStrategy = strategy.getInputStrategy();
                int productId = appMenu.showMenu(AppMenu.MenuType.PRODUCT_CHOICE_MENU);

                if (inputStrategy instanceof RandomInputStrategy<?>) {
                    ((RandomInputStrategy<?>) inputStrategy).setRandomGeneratorStrategy(getRandomFillingStrategies(productId));
                } else {
                    throw new UnsupportedOperationException("Что-то напутано в методе выбора стратегии ввода.");
                }

                int count = AppUtils.parseInteger(prompt("Введите кол-во генерируемых элементов: \n"), "Ввод должен быть числом");
                products = strategy.getInputData(count);
            }
            default -> {
                System.out.println("Некорректный выбор.");
                return;
            }
        }
        System.out.println("Полученные данные: " + products + "\n");
    }

    public static void getHandleSorting() {

    }

    public static void getHandleBinarySearch() {

    }
}