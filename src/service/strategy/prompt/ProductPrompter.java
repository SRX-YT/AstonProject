package service.strategy.prompt;

/**
 * Прокси-класс, предоставляющий возможность выбора стратегии считывания для классов-продуктов.
 */

public class ProductPrompter {
    private final PromptStrategy promptStrategy;

    public ProductPrompter(PromptStrategy promptStrategy) {
        this.promptStrategy = promptStrategy;
    }

    public String prompt() {
        return this.promptStrategy.prompt();
    }
}