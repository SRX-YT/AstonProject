package service.search;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс, определяющий метод binarySearch для осуществления бинарного поиска.
 * Имеет реализации для конкретных видов классов-продуктов.
 * @param <T> тип данных, с которым работает поиск.
 */

public interface BinarySearchable<T extends Comparable<T>> {

    /**
     * Метод для осуществления бинарного поиска по отсортированному списку.
     * @param sortedList принимаемый отсортированный список.
     * @param target входящее значение поля объекта для поиска.
     * @return возвращает Optional объекта T.
     */
    Optional<T> binarySearch(List<T> sortedList, String target);
}
