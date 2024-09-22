package model;

public class Car implements Comparable<Car> {
    private Integer horsePower;
    private Integer yearOfProduction;
    private String model;

    private Car(CarBuilder carBuilder) {
        this.horsePower = carBuilder.horsePower;
        this.yearOfProduction = carBuilder.yearOfProduction;
        this.model = carBuilder.model;
    }

    public Integer getHorsePower() { return this.horsePower; }

    public Integer getYearOfProduction() { return this.yearOfProduction; }

    public String getModel() { return this.model; }

    @Override
    public int compareTo(Car o) {
        return this.getHorsePower() - o.getHorsePower();
    }

    @Override
    public int hashCode() {
        int result = this.model == null ? 0 : this.model.hashCode();
        result = 31 * result + this.yearOfProduction;
        result = 31 * result + this.horsePower;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Car car = (Car) obj;

        if (this.horsePower != car.horsePower) return false;
        if (this.yearOfProduction != car.yearOfProduction) return false;
        return this.model.equals(car.model);
    }

    @Override
    public String toString() {
        return this.model + " - " + this.horsePower + " HP, " + yearOfProduction + " year.";
    }

    public static class CarBuilder {
        private Integer horsePower;
        private Integer yearOfProduction;
        private String model;

        public CarBuilder(Integer horsePower, Integer yearOfProduction, String model) {
            this.horsePower = horsePower;
            this.yearOfProduction = yearOfProduction;
            this.model = model;
        }

        public Car build() { return new Car(this); }

        public void resetBuilder() {
            this.horsePower = 0;
            this.yearOfProduction = 0;
            this.model = null;
        }
    }
}
