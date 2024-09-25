package service.strategy.prompt.impl;

import service.strategy.prompt.PromptStrategy;
import util.AppUtils;

public class RootCropPromptStrategy implements PromptStrategy {

    @Override
    public String prompt() {
        return "RootCrop," +
                AppUtils.prompt("Введите тип корнеплода:\n") +
                "," +
                AppUtils.prompt("Введите вес корнеплода:\n") +
                "," +
                AppUtils.prompt("Введите цвет корнеплода:\n");
    }
}