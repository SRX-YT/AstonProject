package service.strategy.input.impl;

import service.strategy.input.InputStrategy;
import service.strategy.input.ParseSetable;
import service.strategy.input.PromptSetable;
import service.strategy.parse.ProductParser;
import service.strategy.prompt.ProductPrompter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManualInputStrategy<T> implements InputStrategy<T>, ParseSetable, PromptSetable {
    private ProductParser<T> parser;
    private ProductPrompter promptStrategy;

    @Override
    public void setPromptStrategy(ProductPrompter promptStrategy) {
        this.promptStrategy = promptStrategy;
    }

    @Override
    public void setParseStrategy(ProductParser<?> parser) {
        this.parser = (ProductParser<T>) parser;
    }

    @Override
    public List<T> input(int count) throws IOException {
        List<T> dataList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            T car = inputObjectData();
            dataList.add(car);
        }
        return dataList;
    }

    private T inputObjectData() throws IOException {
        String infoLine = promptStrategy.prompt();
        return parser.parseProduct(infoLine).get();
    }
}