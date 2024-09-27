package service.strategy.input;

import java.io.IOException;
import java.util.List;

/**
 * Прокси-класс, предоставляющий возможность выбора стратегии ввода.
 * @param <T> тип данных, с которым работает DataInputter.
 */

public class DataInputter<T> {
    InputStrategy<T> inputStrategy;

    public DataInputter(InputStrategy<?> inputStrategy) {
        this.inputStrategy = (InputStrategy<T>) inputStrategy;
    }

    public List<T> input(int count) throws IOException {
        return this.inputStrategy.input(count);
    }

    public InputStrategy<T> getInputStrategy() {
        return inputStrategy;
    }
}
