package service.sort;

import model.Book;
import model.Car;
import model.RootCrop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EvenNumberMergeSort<T extends Comparable<T>> {

    public void evenMergeSort(List<T> list, Comparator comparator) {
        // Сначала создадим список для четных элементов
        List<T> evenElements = new ArrayList<>();

        for (T item : list) {
            if (isEven(item)) {
                evenElements.add(item);
            }
        }

        // Сортируем только четные элементы
        mergeSortEven(evenElements, comparator);

        // Вставляем отсортированные четные элементы обратно в исходный список
        int evenIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isEven(list.get(i))) {
                list.set(i, evenElements.get(evenIndex++));
            }
        }
        return;
    }

    // Проверка на четность.
    private boolean isEven(T item) {
        if (item instanceof Car) {
            return ((Car) item).getPower() % 2 == 0;
        }
        if (item instanceof Book) {
            return ((Book) item).getPages() % 2 == 0;
        }
        if (item instanceof RootCrop) {
            return ((RootCrop) item).getWeight() % 2 == 0;
        }
        return false; // Возвращаем false по умолчанию для других типов
    }

    private void mergeSortEven(List<T> list, Comparator comparator) {
        if (list.size() > 1) {
            int middle = list.size() / 2;

            List<T> left = new ArrayList<>(list.subList(0, middle));
            List<T> right = new ArrayList<>(list.subList(middle, list.size()));

            mergeSortEven(left, comparator);
            mergeSortEven(right, comparator);

            merge(list, left, right, comparator);
        }
    }

    private void merge(List<T> list, List<T> left, List<T> right, Comparator comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
}