package model;

public class CarBuilder {
    private Integer horsePower;
    private Integer yearOfProduction;
    private String model;

    public CarBuilder() { }

    public CarBuilder setHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public CarBuilder setYearOfProduction(int year) {
        this.yearOfProduction = year;
        return this;
    }

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public String getModel() {
        return model;
    }

    public Car build() {
        return new Car(this);
    }

    public void resetBuilder() {
        this.model = null;
        this.horsePower = null;
        this.yearOfProduction = null;
    }
}
