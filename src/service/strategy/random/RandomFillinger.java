package service.strategy.random;

import java.util.List;

/**
 * Прокси-класс, предоставляющий возможность выбора стратегии рандомного заполнения.
 *
 * @param <T> тип данных, с которым работает RandomFillinger.
 */

public class RandomFillinger<T> {

    private final RandomFillingStrategy<T> random;

    public RandomFillinger(RandomFillingStrategy<T> random) {
        this.random = random;
    }

    public List<T> getRandomData(int count) {
        return this.random.generateRandomData(count);
    }
}