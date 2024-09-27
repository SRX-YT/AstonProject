package service.strategy.random;

import java.util.List;

/**
 * Интерфейс, определяющий метод prompt().
 * Используется для реализации конкретных стратегий рандомного заполнения с реализованным методом generateRandomData().
 */

public interface RandomFillingStrategy<T> {

    List<T> generateRandomData(int count);
}