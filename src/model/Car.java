package model;

public class Car implements Comparable<Car> {
    private int horsePower;
    private int yearOfProduction;
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
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
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

        // public Car reset() { }
    }
}
