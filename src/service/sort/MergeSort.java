package service.sort;

import java.util.Comparator;

public class MergeSort<T> {

    public void mergeSort(T[] list, Comparator<T> comparator) {
        if (list.length > 1) {
            int middle = list.length / 2;

            T[] left = (T[]) new Object[middle];
            T[] right = (T[]) new Object[list.length - middle];

            System.arraycopy(list, 0, left, 0, middle);
            System.arraycopy(list, middle, right, 0, list.length - middle);

            mergeSort(left, comparator);
            mergeSort(right, comparator);

            merge(list, left, right, comparator);
        }
    }

    private void merge(T[] list, T[] left, T[] right, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                list[k++] = left[i++];
            } else {
                list[k++] = right[j++];
            }
        }

        while (i < left.length) {
            list[k++] = left[i++];
        }

        while (j < right.length) {
            list[k++] = right[j++];
        }
    }

}
