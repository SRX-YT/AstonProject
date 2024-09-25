package service.validation.impl;

import model.RootCrop;
import service.validation.Validationable;

public class RootCropValidation implements Validationable<RootCrop> {
    @Override
    public boolean validate(RootCrop product) {
        return product.getType() != null &&
                !product.getType().isEmpty() &&
                product.getWeight() > 0 &&
                product.getColour() != null &&
                !product.getColour().isEmpty();
    }
}