package service.strategy.input.impl;

import service.strategy.input.InputStrategy;
import service.strategy.input.RandomGeneratorSetable;
import service.strategy.random.RandomFillinger;

import java.util.List;

public class RandomInputStrategy<T> implements InputStrategy<T>, RandomGeneratorSetable {
    private RandomFillinger<T> generator;
    // TODO: добавить аннотацию SuppressWarnings("unchecked") везде, где необходимо.
    @Override
    public void setRandomGeneratorStrategy(RandomFillinger<?> generator) {
        this.generator = (RandomFillinger<T>) generator;
    }

    @Override
    public List<T> input(int count) {
        return generator.getRandomData(count);
    }
}
