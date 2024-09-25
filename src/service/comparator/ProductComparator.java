package service.comparator;

import java.lang.reflect.Field;
import java.util.Comparator;

public class ProductComparator<T> implements Comparator<T> {
    private final String fieldName;
    private final boolean ascending;

    public ProductComparator(String fieldName, boolean ascending) {
        this.fieldName = fieldName;
        this.ascending = ascending;
    }

    @Override
    public int compare(T o1, T o2) {
        try {
            Field field = o1.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            Object value1 = field.get(o1);
            Object value2 = field.get(o2);

            if (value1 == null && value2 == null) {
                return 0;
            } else if (value1 == null) {
                return -1;
            } else if (value2 == null) {
                return 1;
            }

            if (value1 instanceof Comparable) {
                int comparison = ((Comparable) value1).compareTo(value2);
                return ascending ? comparison : -comparison;
            } else {
                throw new UnsupportedOperationException("Невозможно сравнить объекты типа: " + value1.getClass());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Ошибка при сравнении объектов.", e);
        }
    }
}