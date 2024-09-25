package service.strategy.parse;

import java.io.IOException;
import java.util.Optional;

public class ProductParser<T> {
    private final ParseStrategy<T> parser;

    public ProductParser(ParseStrategy<T> parser) {
        this.parser = parser;
    }

    public Optional<T> parseProduct(String line) throws IOException {
        return parser.parse(line);
    }
}