package service.strategy.parse.impl;

import model.Book;
import service.strategy.parse.ParseStrategy;
import service.validation.impl.BookValidation;
import util.AppUtils;

import java.util.Optional;

public class BookParseStrategy implements ParseStrategy<Book> {

    @Override
    public Optional<Book> parse(String line) {
        try {
            Book book;
            String[] parts = line.split(",");
            if (parts.length != 4) {
                System.out.println("Ошибка: некорректное количество параметров в строке.");
                return Optional.empty();
            }
            if (!parts[0].toLowerCase().equalsIgnoreCase(Book.class.getSimpleName())) {
                System.out.println("Ошибка: выбранный тип продукта и тип из файла не совпадают!");
                return Optional.empty();
            }
            book = new Book.BookBuilder()
                    .setAuthor(parts[1])
                    .setTitle(parts[2])
                    .setPages(AppUtils.parseInteger(parts[3], "Количество страниц должно быть числом."))
                    .build();
            if (!new BookValidation().validate(book)) {
                System.out.println("Ошибка: данные для полей не валидны.");
                return Optional.empty();
            }
            return Optional.of(book);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: тип данных после парсинга некорректен." + e.getMessage());
            return Optional.empty();
        }
    }
}