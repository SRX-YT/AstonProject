package model;

public class RootCrop implements Comparable<RootCrop> {
    private String color;
    private String type;
    private Double weight;

    private RootCrop(RootCropBuilder rootCropBuilder) {
        this.color = rootCropBuilder.color;
        this.type = rootCropBuilder.type;
        this.weight = rootCropBuilder.weight;
    }

    public String getColor() { return color; }

    public String getType() { return type; }

    public double getWeight() { return weight; }

    @Override
    public int compareTo(RootCrop o) { return this.weight.compareTo(o.getWeight()); }

    @Override
    public int hashCode() { return super.hashCode(); }

    @Override
    public boolean equals(Object obj) { return super.equals(obj); }

    @Override
    public String toString() { return "Weight: " + this.weight + ", color: " + this.color + ", type: " + this.type; }

    public static class RootCropBuilder {
        private String color;
        private String type;
        private Double weight;

        public RootCropBuilder(String color, String type, Double weight) {
            this.color = color;
            this.type = type;
            this.weight = weight;
        }

        public RootCrop build() { return new RootCrop(this); }

        // public RootCrop reset() { }
    }
}
