package service.strategy.random.impl;

import model.Book;
import service.strategy.random.RandomFillingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBookStrategy implements RandomFillingStrategy<Book> {
    @Override
    public List<Book> generateRandomData(int count) {
        Random random = new Random(); //TODO убрать в рандомайзер
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            books.add(new Book.BookBuilder()
                    .setAuthor("Author" + random.nextInt(100))
                    .setTitle("Title" + random.nextInt(100))
                    .setPages((int) (Math.random() * 1000 + 50))
                    .build());
        }
        return books;
    }
}