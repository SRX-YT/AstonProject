package service.strategy.input;

import service.strategy.prompt.ProductPrompter;

public interface PromptSetable {

    void setPromptStrategy(ProductPrompter promptStrategy);
}