package service.strategy.input;

import service.strategy.parse.ProductParser;

public interface ParseSetable {
    void setParseStrategy(ProductParser<?> parser);
}
