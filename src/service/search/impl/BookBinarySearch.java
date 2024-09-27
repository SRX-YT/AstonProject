package service.search.impl;

import model.Book;
import service.search.BinarySearchable;

import java.util.List;
import java.util.Optional;

/**
 * Класс-реализация интерфейса BinarySearchable, реализующий метод binarySearch
 * для осуществления бинарного поиска по объектам класса Book.
 */

public class BookBinarySearch implements BinarySearchable<Book> {

    /**
     * Реализация метода для осуществления бинарного поиска по отсортированному списку.
     *
     * @param sortedList принимаемый отсортированный список объектов Book.
     * @param target     входящее значение поля объекта Book для поиска.
     * @return возвращает Optional объекта Book.
     */
    @Override
    public Optional<Book> binarySearch(List<Book> sortedList, String target) {
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            Book midElement = sortedList.get(middle);

            int comparison = target.compareTo(midElement.getTitle());

            if (comparison == 0) {
                return Optional.of(sortedList.get(middle));
            } else if (comparison < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return Optional.empty();
    }
}
