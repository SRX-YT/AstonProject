package model;

public class Car implements Comparable<Car> {
    private final Integer power;
    private final Integer year;
    private final String model;

    public Car(CarBuilder carBuilder) {
        this.power = carBuilder.power;
        this.year = carBuilder.year;
        this.model = carBuilder.model;

        carBuilder.resetBuilder();
    }

    public Integer getPower() { return this.power; }

    public Integer getYear() { return this.year; }

    public String getModel() { return this.model; }

    @Override
    public int compareTo(Car other) {
        return this.model.compareTo(other.model);
    }

    @Override
    public int hashCode() {
        int result = this.model == null ? 0 : this.model.hashCode();
        result = 31 * result + this.year;
        result = 31 * result + this.power;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Car car = (Car) obj;

        if (!this.power.equals(car.power)) return false;
        if (!this.year.equals(car.year)) return false;
        return this.model.equals(car.model);
    }

    @Override
    public String toString() {
        return "Авто: модель= " + model + ", мощность= " + power + ", дата выпуска= " + year;
    }

    public static class CarBuilder {
        private Integer power;
        private Integer year;
        private String model;

        public CarBuilder setHorsePower(int horsePower) {
            this.power = horsePower;
            return this;
        }

        public CarBuilder setYearOfProduction(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

        public void resetBuilder() {
            this.model = null;
            this.power = null;
            this.year = null;
        }
    }
}
