package service.strategy.prompt;

/**
 * Интерфейс, определяющий метод prompt().
 * Используется для реализации конкретных стратегий промпта с реализованным методом prompt().
 */

public interface PromptStrategy {
    String prompt();
}
