package service.strategy.parse;

import java.io.IOException;
import java.util.Optional;

/**
 * Прокси-класс, предоставляющий возможность выбора стратегии парсинга.
 *
 * @param <T> тип данных, с которым работает ProductParser.
 */

public class ProductParser<T> {
    private final ParseStrategy<T> parser;

    public ProductParser(ParseStrategy<T> parser) {
        this.parser = parser;
    }

    public Optional<T> parseProduct(String line) throws IOException {
        return parser.parse(line);
    }
}