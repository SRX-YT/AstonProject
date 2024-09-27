package service.strategy.input.impl;

import service.strategy.input.FileNameSetable;
import service.strategy.input.InputStrategy;
import service.strategy.input.ParseSetable;
import service.strategy.parse.ProductParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FileInputStrategy<T> implements InputStrategy<T>, FileNameSetable, ParseSetable {
    private String fileName;
    private ProductParser<?> parser;

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void setParseStrategy(ProductParser<?> parser) {
        this.parser = parser;
    }

    @Override
    public List<T> input(int count) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IOException("Ошибка чтения файла", e);
        }
        count = AppUtils.getEnoughData(lines, count); //проверяем, достаточно ли данных в файле.
        if(count != 0) {
            List<T> dataList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                try {
                    T object = (T) parser.parseProduct(lines.get(i)).get();
                    dataList.add(object);
                } catch (NumberFormatException | NoSuchElementException e) {
                    System.out.println("Данные в файле некорректны!" + e.getMessage()); // TODO Возможно убрать отсюда валидацию.
                }
            }
            return dataList;
        }
        return List.of();
    }
}
