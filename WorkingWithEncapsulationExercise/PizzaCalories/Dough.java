package WorkingWithEncapsulationExercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public double calculateCalories() {
        return 0;
    }

    public void setFlourType(String flourType) {
        //•	White – 1.5;
        //•	Wholegrain – 1.0;
        //•	Crispy – 0.9;
        //•	Chewy – 1.1;
        //•	Homemade – 1.0;

        switch (flourType) {
            case "White":
                break;
            case "Wholegrain":
                break;
            case "Crispy":
                break;
            case "Chewy":
                break;
            case "Homemade":
                break;
        }
        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique) {
        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
