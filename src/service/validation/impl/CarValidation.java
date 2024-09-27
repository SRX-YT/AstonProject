package service.validation.impl;

import model.Car;
import service.validation.Validationable;

public class CarValidation implements Validationable<Car> {

    @Override
    public boolean validate(Car product) {
        return product.getModel() != null &&
                !product.getModel().isEmpty() &&
                product.getPower() > 0 &&
                product.getYear() > 1885;
    }
}
