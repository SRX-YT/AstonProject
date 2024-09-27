package service.strategy.parse;

import java.io.IOException;
import java.util.Optional;

/**
 * Интерфейс, определяющий метод parse().
 * Используется для реализации конкретных стратегий парсинга с реализованным методом parse().
 */

public interface ParseStrategy<T> {

    Optional<T> parse(String line) throws IOException;
}