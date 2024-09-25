package service.strategy.input;

import service.strategy.random.RandomFillinger;

public interface RandomGeneratorSetable {

    void setRandomGeneratorStrategy(RandomFillinger<?> generator);
}