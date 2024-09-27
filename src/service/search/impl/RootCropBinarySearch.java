package service.search.impl;

import model.RootCrop;
import service.search.BinarySearchable;

import java.util.List;
import java.util.Optional;

/**
 * Класс-реализация интерфейса BinarySearchable, реализующий метод binarySearch
 * для осуществления бинарного поиска по объектам класса RootCrop.
 */
public class RootCropBinarySearch implements BinarySearchable<RootCrop> {

    /**
     * Реализация метода для осуществления бинарного поиска по отсортированному списку.
     *
     * @param sortedList принимаемый отсортированный список объектов RootCrop.
     * @param target     входящее значение поля объекта RootCrop для поиска.
     * @return возвращает Optional объекта RootCrop.
     */

    @Override
    public Optional<RootCrop> binarySearch(List<RootCrop> sortedList, String target) {
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            RootCrop midElement = sortedList.get(middle);

            int comparison = target.compareTo(midElement.getType());

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

