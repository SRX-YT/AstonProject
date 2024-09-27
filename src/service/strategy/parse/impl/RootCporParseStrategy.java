package service.strategy.parse.impl;

import model.RootCrop;
import service.strategy.parse.ParseStrategy;
import service.validation.impl.RootCropValidation;
import util.AppUtils;

import java.util.Optional;

public class RootCporParseStrategy implements ParseStrategy<RootCrop> {
    @Override
    public Optional<RootCrop> parse(String line) {
        try {
            RootCrop rootCrop;
            String[] parts = line.split(",");
            if (parts.length != 4) {
                System.out.println("Ошибка: некорректное количество параметров в строке.");
                return Optional.empty();
            }
            if(!parts[0].toLowerCase().equalsIgnoreCase(RootCrop.class.getSimpleName())){
                System.out.println("Ошибка: выбранный тип продукта и тип из файла не совпадают!");
                return Optional.empty();
            }
            rootCrop = new RootCrop.RootCropBuilder()
                    .setType(parts[1])
                    .setWeight(AppUtils.parseInteger(parts[2], "Вес корнеплода должен быть числом."))
                    .setColor(parts[3])
                    .build();
            if (!new RootCropValidation().validate(rootCrop)) {
                System.out.println("Ошибка: данные для полей не валидны.");
                return Optional.empty();
            }
            return Optional.of(rootCrop);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: тип данных после парсинга некорректен." + e.getMessage());
            return Optional.empty();
        }
    }
}
