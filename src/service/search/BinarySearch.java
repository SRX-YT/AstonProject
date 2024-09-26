package service.search;

import java.util.Comparator;
import java.util.List;

public class BinarySearch<T> {

    public int binarySearch(List<T> list, T key, Comparator<T> comparator) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int cmp = comparator.compare(key, list.get(middle));

            if (cmp == 0) {
                return middle;
            } else if (cmp < 0) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

}
