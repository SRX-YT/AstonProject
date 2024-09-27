package model;

import java.util.Comparator;

public interface ComparatorGetable<T> {
    Comparator<T> getComparator();
}