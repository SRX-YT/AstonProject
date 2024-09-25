package service.strategy.prompt.impl;

import service.strategy.prompt.PromptStrategy;
import util.AppUtils;

public class CarPromptStrategy implements PromptStrategy {
    @Override
    public String prompt() {
        return "Car," +
                AppUtils.prompt("Введите модель автомобиля:\n") +
                "," +
                AppUtils.prompt("Введите мощность автомобиля:\n") +
                "," +
                AppUtils.prompt("Введите год производства:\n");
    }
}