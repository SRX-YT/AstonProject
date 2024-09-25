package model;

public class RootCrop implements Comparable<RootCrop> {
    private final String type;
    private final double weight;
    private final String color;

    private RootCrop(RootCropBuilder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int compareTo(RootCrop other) {
        return this.type.compareTo(other.type); // Сортировка по типу по умолчанию
    }

    @Override
    public String toString() {
        return "Корнеплод: тип= " + type + ", вес= " + weight + ", цвет= " + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RootCrop)) return false;

        RootCrop that = (RootCrop) o;
        return type.equals(that.type) && color.equals(that.color);
    }

    @Override
    public int hashCode() {
        int result = color == null ? 0 : color.hashCode();
        return type == null ? result : type.hashCode() + result;
    }

    // Внутренний класс билдер
    public static class RootCropBuilder {
        private String type;
        private double weight;
        private String color;

        public RootCropBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public RootCropBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public RootCropBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }
}
