package service.validation;

public interface Validationable<T> {
    boolean validate(T product);
}
