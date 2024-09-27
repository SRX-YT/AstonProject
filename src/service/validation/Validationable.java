package service.validation;

/**
 * Интерфейс, определяющий метод validate().
 * Используется для реализации конкретных валидаторов с реализованным методом validate().
 */

public interface Validationable<T> {

    boolean validate(T product);
}
