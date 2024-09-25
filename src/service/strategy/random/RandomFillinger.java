package service.strategy.random;

import java.util.List;

public class RandomFillinger<T> {
    RandomFillingStrategy<T> random;

    public RandomFillinger(RandomFillingStrategy<T> random) {
        this.random = random;
    }
    public List<T> getRandomData(int count){
        return this.random.generateRandomData(count);
    }
}
