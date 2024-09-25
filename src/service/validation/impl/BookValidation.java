package service.validation.impl;

import model.Book;
import service.validation.Validationable;

public class BookValidation implements Validationable<Book> {
    @Override
    public boolean validate(Book product) {
        return product.getAuthor() != null &&
                !product.getAuthor().isEmpty() &&
                product.getTitle() != null &&
                !product.getTitle().isEmpty() &&
                product.getPages() > 0;
    }
}