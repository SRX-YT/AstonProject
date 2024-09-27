package service;

import model.Book;
import model.Car;
import model.RootCrop;
import presentation.AppMenu;
import service.comparator.BookPagesComparator;
import service.comparator.CarPowerComparator;
import service.comparator.RootCropWeightComparator;
import service.search.impl.BookBinarySearch;
import service.search.impl.CarBinarySearch;
import service.search.impl.RootCropBinarySearch;
import service.sort.EvenNumberMergeSort;
import service.sort.MergeSort;
import service.strategy.input.DataInputter;
import service.strategy.input.FileNameSetable;
import service.strategy.input.InputStrategy;
import service.strategy.input.ParseSetable;
import service.strategy.input.impl.FileInputStrategy;
import service.strategy.input.impl.ManualInputStrategy;
import service.strategy.input.impl.RandomInputStrategy;
import util.AppUtils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static util.AppUtils.parseInteger;
import static util.AppUtils.prompt;
import static util.StrategyGetterUtil.*;


/**
 * Класс, инкапсулирующий основную логику приложения.
 */

public class AppService {

    private final AppMenu appMenu;

    public AppService(AppMenu appMenu) {
        this.appMenu = appMenu;
    }

    /**
     * Метод обработки вариантов ввода: из файла, ручной, рандомный.
     *
     * @param inputChoice входная переменная выбора варианта ввода.
     * @return при успешной обработке возвращает заполненную указанным способ коллекцию.
     * @throws IOException
     */
    public List<?> getHandleDataInput(int inputChoice) throws IOException {

        List<?> products = List.of();
        DataInputter<?> strategy;

        switch (inputChoice) {
            case 1 -> {
                strategy = getInputStrategies(1);
                InputStrategy<?> inputStrategy = strategy.getInputStrategy();
                String fileName = prompt("\nВведите наименование файла: \n");

                if (!AppUtils.isValidFile(fileName)) {
                    return List.of();
                }
                if (inputStrategy instanceof FileInputStrategy<?>) {
                    ((FileNameSetable) inputStrategy).setFileName(fileName);
                } else {
                    System.out.println("Ошибка выбора стратегии ввода: не поддерживается.");
                    return products;
                }

                int productId = AppUtils.getValidPrompt(1, 3, appMenu,
                        AppMenu.MenuType.PRODUCT_CHOICE_MENU);

                ((ParseSetable) inputStrategy).setParseStrategy(getParseStrategies(productId));

                int count = AppUtils.getValidLocalPrompt(parseInteger(
                        prompt("\nУкажите кол-во считываемых элементов: \n"),
                        "Ввод должен быть числом"));

                products = strategy.input(count);

                return products;
            }
            case 2 -> {
                strategy = getInputStrategies(2);
                InputStrategy<?> inputStrategy = strategy.getInputStrategy();
                int productId = AppUtils.getValidPrompt(1, 3, appMenu,
                        AppMenu.MenuType.PRODUCT_CHOICE_MENU);

                if (inputStrategy instanceof ManualInputStrategy<?>) {
                    ((ManualInputStrategy<?>) inputStrategy)
                            .setParseStrategy(getParseStrategies(productId));
                    ((ManualInputStrategy<?>) inputStrategy)
                            .setPromptStrategy(getPromptStrategies(productId));
                } else {
                    System.out.println("Ошибка выбора стратегии ввода: не поддерживается.");
                    return products;
                }

                int count = parseInteger(prompt("\nУкажите кол-во вводимых элементов: " + "\n"),
                        "Ввод должен быть числом");
                products = strategy.input(count);
                return products;
            }
            case 3 -> {
                strategy = getInputStrategies(3);
                InputStrategy<?> inputStrategy = strategy.getInputStrategy();
                int productId = AppUtils.getValidPrompt(1, 3, appMenu,
                        AppMenu.MenuType.PRODUCT_CHOICE_MENU);

                if (inputStrategy instanceof RandomInputStrategy<?>) {
                    ((RandomInputStrategy<?>) inputStrategy)
                            .setRandomGeneratorStrategy(getRandomFillingStrategies(productId));
                } else {
                    System.out.println("Ошибка выбора стратегии ввода: не поддерживается.");
                    return products;
                }

                int count = AppUtils.getValidLocalPrompt(parseInteger(
                        prompt("\nУкажите кол-во считываемых элементов: " + "\n"),
                        "Ввод должен быть числом"));
                products = strategy.input(count);
                return products;
            }
            default -> System.out.println("\nНекорректный выбор.");
        }
        return products;
    }

    /**
     * Метод для обработки при выборе вида сортировки: MergeSort, EvenNumberMergeSort.
     *
     * @param products входящий список.
     * @param choice   пользовательский выбор вида сортировки.
     * @return возвращает отсортированный список.
     */
    public List<?> getHandleSorting(List<?> products, int choice) {
        switch (choice) {
            case 1 -> {
                new MergeSort<>().mergeSort((List) products);
                return products;
            }

            case 2 -> {
                if (products.get(0) instanceof Car) {
                    new EvenNumberMergeSort<>().evenMergeSort(
                            (List) products, new CarPowerComparator());
                    return products;
                } else if (products.get(0) instanceof Book) {
                    new EvenNumberMergeSort<>().evenMergeSort(
                            (List) products, new BookPagesComparator());
                    return products;
                } else if (products.get(0) instanceof RootCrop) {
                    new EvenNumberMergeSort<>().evenMergeSort(
                            (List) products, new RootCropWeightComparator());
                    return products;
                } else {
                    System.out.println("\nСписок заполнен чем-то не тем.");
                }
            }
            default -> System.out.println("\nНекорректный выбор.");
        }
        return List.of();
    }

    /**
     * Метод для выполнения бинарного поиска по отсортированному списку.
     *
     * @param sortedProducts входящий отсортированный список.
     */
    public void getHandleBinarySearch(List<?> sortedProducts) {
        if (sortedProducts.get(0) instanceof Car) {
            String target = AppUtils.prompt("\nВведите наименование модели: \n");
            Optional<Car> car = new CarBinarySearch().binarySearch(
                    (List<Car>) sortedProducts, target);
            if (car.isPresent()) {
                System.out.println(car.get());
            } else System.out.println("\nНичего не найдено :(");
        } else if (sortedProducts.get(0) instanceof Book) {
            String target = AppUtils.prompt("\nВведите название книги: \n");
            Optional<Book> book = new BookBinarySearch().binarySearch(
                    (List<Book>) sortedProducts, target);
            if (book.isPresent()) {
                System.out.println(book.get());
            } else System.out.println("\nНичего не найдено :(");
        } else if (sortedProducts.get(0) instanceof RootCrop) {
            String target = AppUtils.prompt("\nВведите тип корнеплода: \n");
            Optional<RootCrop> rootCrop = new RootCropBinarySearch().binarySearch(
                    (List<RootCrop>) sortedProducts, target);
            if (rootCrop.isPresent()) {
                System.out.println(rootCrop.get());
            } else System.out.println("\nНичего не найдено :(");
        } else {
            System.out.println("\nСписок заполнен чем-то не тем.");
        }
    }
}

