package service.search.impl;

import model.RootCrop;
import service.search.BinarySearchable;

import java.util.List;
import java.util.Optional;

public class RootCropBinarySearch implements BinarySearchable<RootCrop> {
    @Override
    public Optional<RootCrop> binarySearch(List<RootCrop> sortedList, String target) {
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            RootCrop midElement = sortedList.get(middle);

            int comparison = target.compareTo(midElement.getType());

            if (comparison == 0) {
                return Optional.of(sortedList.get(middle));  // Найденный элемент
            } else if (comparison < 0) {
                right = middle - 1;  // Искомый элемент в левой части
            } else {
                left = middle + 1;  // Искомый элемент в правой части
            }
        }
        return Optional.empty();  // Элемент не найден
    }
}

