package WorkingWithEncapsulationExercise.ClassBox;

public class Box {
    private static final int MINIMAL_VALUE_OF_PARAMETER = 1;

    private static final String INVALID_PARAMETER_DISPLAY_MESSAGE = "The given value should be more than 0 and cannot be a negative value.";
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setLength(double length) {
        if (length >= MINIMAL_VALUE_OF_PARAMETER) {
            this.length = length;
        } else throw new IllegalArgumentException(INVALID_PARAMETER_DISPLAY_MESSAGE);
    }

    public void setWidth(double width) {
        if (width >= MINIMAL_VALUE_OF_PARAMETER) {
            this.width = width;
        } else throw new IllegalArgumentException(INVALID_PARAMETER_DISPLAY_MESSAGE);
    }

    public void setHeight(double height) {
        if (height >= MINIMAL_VALUE_OF_PARAMETER) {
            this.height = height;
        } else throw new IllegalArgumentException(INVALID_PARAMETER_DISPLAY_MESSAGE);
    }

    public double calculateSurfaceArea() {
        return 2 * this.length * this.width + 2 * this.length + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width + 2 * this.height;
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format(
                "Surface Area - %.2f\nLateral Surface Area - %.2f\nVolume – %.2f",
                calculateSurfaceArea(),
                calculateLateralSurfaceArea(),
                calculateVolume());
    }
}
