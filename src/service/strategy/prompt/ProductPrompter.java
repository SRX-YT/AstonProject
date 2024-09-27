package service.strategy.prompt;

public class ProductPrompter {
    private final PromptStrategy promptStrategy;

    public ProductPrompter(PromptStrategy promptStrategy) {
        this.promptStrategy = promptStrategy;
    }

    public String prompt() {
        return this.promptStrategy.prompt();
    }
}