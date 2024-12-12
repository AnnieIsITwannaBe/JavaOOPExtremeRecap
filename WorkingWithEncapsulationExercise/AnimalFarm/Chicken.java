package WorkingWithEncapsulationExercise.AnimalFarm;

public class Chicken {
    public static final String NAME_CANNOT_BE_NULL_EMPTY_OR_WHITESPACE = "Name cannot be null, empty, or whitespace.";
    public static final String AGE_SHOULD_BE_BETWEEN_0_AND_15 = "Age should be between 0 and 15.";
    //-	name: String
    //-	age: int

    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private double productPerDay() {
        if (this.age >= 0 && this.age < 6) {
            return 2.0;
        } else if (this.age >= 6 && this.age <= 11) {
            return 1.0;
        } else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.\n", this.name, this.age, this.productPerDay());
    }

    public void setName(String name) {
        //it cannot be null, empty, or whitespace
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_CANNOT_BE_NULL_EMPTY_OR_WHITESPACE);
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            this.age = age;
        } else throw new IllegalArgumentException(AGE_SHOULD_BE_BETWEEN_0_AND_15);
    }
}
