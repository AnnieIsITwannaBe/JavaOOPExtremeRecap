package WorkingWithEncapsulationExercise.ShoppingSpreeThirdTimeForTheSport;

import static WorkingWithEncapsulationExercise.AnimalFarm.Chicken.NAME_CANNOT_BE_NULL_EMPTY_OR_WHITESPACE;

public class Product implements Identity {
    public static final String THE_COST_SHOULD_BE_A_POSITIVE_NUMBER_AND_BIGGER_THAN_0 =
            "The cost should be a positive number and bigger than 0";
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_CANNOT_BE_NULL_EMPTY_OR_WHITESPACE);
        }
        this.name = name;
    }

    public void setCost(double cost) {
        if (cost > 0) {
            this.cost = cost;
        } else throw new IllegalArgumentException(THE_COST_SHOULD_BE_A_POSITIVE_NUMBER_AND_BIGGER_THAN_0);
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }
}
