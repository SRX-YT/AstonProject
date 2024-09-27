package service.search.impl;

import model.Car;
import service.search.BinarySearchable;

import java.util.List;
import java.util.Optional;

/**
 * Класс-реализация интерфейса BinarySearchable, реализующий метод binarySearch
 * для осуществления бинарного поиска по объектам класса Car.
 */
public class CarBinarySearch implements BinarySearchable<Car> {

    /**
     * Реализация метода для осуществления бинарного поиска по отсортированному списку.
     * @param sortedList принимаемый отсортированный список объектов Car.
     * @param target входящее значение поля объекта Car для поиска.
     * @return возвращает Optional объекта Car.
     */

    @Override
    public Optional<Car> binarySearch(List<Car> sortedList, String target) {
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            Car midElement = sortedList.get(middle);

            int comparison = target.compareTo(midElement.getModel());

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
