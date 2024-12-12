package WorkingWithEncapsulationExercise.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public double calculateCalories() {
        return 0;
    }

    public void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
