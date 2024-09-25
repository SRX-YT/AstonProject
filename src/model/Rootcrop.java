package model;

public class RootCrop implements Comparable<RootCrop>{
    private String type;
    private double weight;
    private String colour;

    private RootCrop(RootCropBuilder RootCropBuilder) {
        if (RootCropBuilder.type == null) {
            this.type = "Корнеплод обыкновенный";
        } else {
            this.type = RootCropBuilder.type;
        }

        this.weight = RootCropBuilder.weight;

        if (RootCropBuilder.colour == null) {
            this.colour = "Бесцветный";
        } else {
            this.colour = RootCropBuilder.colour;
        }

        RootCropBuilder.resetRootCrop();
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return "RootVegetable{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", colour='" + colour + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RootCrop)) return false;

        RootCrop that = (RootCrop) o;
        return type.equals(that.type) && colour.equals(that.colour);
    }

    @Override
    public int hashCode() {
        int result = colour == null ? 0 : colour.hashCode();
        return type == null ? result : type.hashCode() + result;
    }


    @Override
    public int compareTo(RootCrop o) {
        return type.compareTo(o.getType());
    }

    public static class RootCropBuilder {
        private String type;
        private double weight;
        private String colour;

        public RootCropBuilder() {
        }

        public RootCropBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public RootCropBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public RootCropBuilder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }

        public void resetRootCrop() {
            this.type = null;
            this.weight = 0.0;
            this.colour = null;
        }
    }
}