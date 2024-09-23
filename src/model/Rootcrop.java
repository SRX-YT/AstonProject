package model;

public class Rootcrop implements Comparable<Rootcrop>{
    private String type;
    private double weight;
    private String colour;

    private Rootcrop(RootcropBuilder rootcropBuilder) {
        if (rootcropBuilder.type == null) {
            this.type = "Корнеплод обыкновенный";
        } else {
            this.type = rootcropBuilder.type;
        }

        this.weight = rootcropBuilder.weight;

        if (rootcropBuilder.colour == null) {
            this.colour = "Бесцветный";
        } else {
            this.colour = rootcropBuilder.colour;
        }

        rootcropBuilder.resetRootVegetable();
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
        if (!(o instanceof Rootcrop)) return false;

        Rootcrop that = (Rootcrop) o;
        return type.equals(that.type) && colour.equals(that.colour);
    }

    @Override
    public int hashCode() {
        int result = colour == null ? 0 : colour.hashCode();
        return type == null ? result : type.hashCode() + result;
    }


    @Override
    //сравнение по-умолчанию (сравнивает по типу корнеплода)
    public int compareTo(Rootcrop o) {
        return type.compareTo(o.getType());
    }

    public static class RootcropBuilder {
        private String type;
        private double weight;
        private String colour;

        public RootcropBuilder() {
        }

        public RootcropBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public RootcropBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public RootcropBuilder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public Rootcrop build() {
            return new Rootcrop(this);
        }

        public void resetRootVegetable() {
            this.type = null;
            this.weight = 0.0;
            this.colour = null;
        }
    }
}
