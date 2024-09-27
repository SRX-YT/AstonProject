package util;

import service.strategy.input.DataInputter;
import service.strategy.input.impl.FileInputStrategy;
import service.strategy.input.impl.ManualInputStrategy;
import service.strategy.input.impl.RandomInputStrategy;
import service.strategy.parse.ProductParser;
import service.strategy.parse.impl.BookParseStrategy;
import service.strategy.parse.impl.CarParseStrategy;
import service.strategy.parse.impl.RootCporParseStrategy;
import service.strategy.prompt.ProductPrompter;
import service.strategy.prompt.impl.BookPromptStrategy;
import service.strategy.prompt.impl.CarPromptStrategy;
import service.strategy.prompt.impl.RootCropPromptStrategy;
import service.strategy.random.RandomFillinger;
import service.strategy.random.impl.RandomBookStrategy;
import service.strategy.random.impl.RandomCarsStrategy;
import service.strategy.random.impl.RandomRootCropsStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Утилитный класс с методами получения стратегий по id.<br>
 */

public class StrategyGetterUtil {

    private StrategyGetterUtil() {
        throw new UnsupportedOperationException("StrategyGetterUtil - это утилитарный класс, " +
                "экземпляр не может быть создан!");
    }

    /**
     * Открытый статический метод получения стратегии рандома по id.<br>
     * 1 - рандом для Авто.<br>
     * 2 - рандом для Книги.<br>
     * 3 - рандом для Корнеплода (чтоб его за ногу).
     *
     * @param id - идентификатор стратегии.
     * @return RandomFillinger - возвращает общий для стратегий тип RandomFillinger,
     * имеющий метод получения списка рандомных объектов в зависимости от продукта.
     */
    public static RandomFillinger<?> getRandomFillingStrategies(int id) {
        Map<Integer, RandomFillinger<?>> randomFillingStrategies = new HashMap<>();
        randomFillingStrategies.put(1, new RandomFillinger<>(new RandomCarsStrategy()));
        randomFillingStrategies.put(2, new RandomFillinger<>(new RandomBookStrategy()));
        randomFillingStrategies.put(3, new RandomFillinger<>(new RandomRootCropsStrategy()));
        return randomFillingStrategies.get(id);
    }

    /**
     * Открытый статический метод получения стратегии промпта по id.<br>
     * 1 - промпт для Авто.<br>
     * 2 - промпт для Книги.<br>
     * 3 - промпт для Корнеплода (чтоб его за ногу).
     *
     * @param id - идентификатор стратегии.
     * @return ProductPrompter - возвращает общий для стратегий тип ProductPrompter,
     * имеющий метод промпта в зависимости от продукта.
     */
    public static ProductPrompter getPromptStrategies(int id) {
        Map<Integer, ProductPrompter> promptStrategies = new HashMap<>();
        promptStrategies.put(1, new ProductPrompter(new CarPromptStrategy()));
        promptStrategies.put(2, new ProductPrompter(new BookPromptStrategy()));
        promptStrategies.put(3, new ProductPrompter(new RootCropPromptStrategy()));
        return promptStrategies.get(id);
    }

    /**
     * Открытый статический метод получения стратегии парсинга по id.<br>
     * 1 - парсинг Авто.<br>
     * 2 - парсинг Книги.<br>
     * 3 - парсинг Корнеплода (чтоб его за ногу).
     *
     * @param id - идентификатор стратегии.
     * @return ProductParser - возвращает общий для стратегий тип ProductParser,
     * имеющий метод парсинга в зависимости от продукта.
     */
    public static ProductParser<?> getParseStrategies(int id) {
        Map<Integer, ProductParser<?>> parserStrategies = new HashMap<>();
        parserStrategies.put(1, new ProductParser<>(new CarParseStrategy()));
        parserStrategies.put(2, new ProductParser<>(new BookParseStrategy()));
        parserStrategies.put(3, new ProductParser<>(new RootCporParseStrategy()));
        return parserStrategies.get(id);
    }

    /**
     * Открытый статический метод получения стратегии ввода по id.<br>
     * 1 - ввод из файла.<br>
     * 2 - ввод вручную.<br>
     * 3 - ввод рандом.
     *
     * @param id - идентификатор стратегии.
     * @return DataInputter - возвращает общий для стратегий тип DataInputter, с полем стратегии ввода.
     */
    public static DataInputter<?> getInputStrategies(int id) {
        Map<Integer, DataInputter<?>> inputStrategies = new HashMap<>();
        inputStrategies.put(1, new DataInputter<>(new FileInputStrategy<>()));
        inputStrategies.put(2, new DataInputter<>(new ManualInputStrategy<>()));
        inputStrategies.put(3, new DataInputter<>(new RandomInputStrategy<>()));
        return inputStrategies.get(id);
    }
}