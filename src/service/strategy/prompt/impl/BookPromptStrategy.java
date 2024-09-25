package service.strategy.prompt.impl;

import service.strategy.prompt.PromptStrategy;
import util.AppUtils;

public class BookPromptStrategy implements PromptStrategy {

    @Override
    public String prompt() {
        return "Book," +
                AppUtils.prompt("Введите автора книги:\n") +
                "," +
                AppUtils.prompt("Введите название книги:\n") +
                "," +
                AppUtils.prompt("Введите количество страниц:\n");
    }
}