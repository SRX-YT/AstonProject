package model;

public class Car implements Comparable<Car> {
    private final String model;
    private final int power;
    private final int year;

    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.power = builder.power;
        this.year = builder.year;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getYear() {
        return year;
    }

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

        if (this.power != car.power) return false;
        if (this.year != car.year) return false;
        return this.model.equals(car.model);
    }

    @Override
    public String toString() {
        return "Авто: модель= " + model + ", мощность= " + power + ", дата выпуска= " + year;
    }

    public static class CarBuilder {
        private String model;
        private int power;
        private int year;

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setPower(int power) {
            this.power = power;
            return this;
        }

        public CarBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
