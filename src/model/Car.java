package model;

public class Car implements Comparable<Car> {
    private Integer horsePower;
    private Integer yearOfProduction;
    private String model;

    public Car(CarBuilder carBuilder) {
        this.horsePower = carBuilder.getHorsePower() == null ? 0 : carBuilder.getHorsePower();
        this.yearOfProduction = carBuilder.getYearOfProduction() == null ? 0 : carBuilder.getYearOfProduction();
        this.model = carBuilder.getModel() == null ? "Неизвестно" : carBuilder.getModel();

        carBuilder.resetBuilder();
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

        if (!this.horsePower.equals(car.horsePower)) return false;
        if (!this.yearOfProduction.equals(car.yearOfProduction)) return false;
        return this.model.equals(car.model);
    }

    @Override
    public String toString() {
        return this.model + " - " + this.horsePower + " HP, " + yearOfProduction + " year.";
    }
}
