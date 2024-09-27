package service.search;

import java.util.List;
import java.util.Optional;

public interface BinarySearchable<T extends Comparable<T>> {
    Optional<T> binarySearch(List<T> sortedList, String target);
}
