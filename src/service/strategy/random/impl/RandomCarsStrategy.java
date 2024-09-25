package service.strategy.random.impl;

import model.Car;
import service.strategy.random.RandomFillingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCarsStrategy implements RandomFillingStrategy<Car> {
    @Override
    public List<Car> generateRandomData(int count) {
        Random random = new Random(); //TODO убрать в рандомайзер
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car.CarBuilder()
                    .setModel("Model" + random.nextInt(1, 100))
                    .setPower((int) (Math.random() * 200 + 50))
                    .setYear((int) (Math.random() * 40 + 1980))
                    .build());
        }
        return cars;
    }
}
