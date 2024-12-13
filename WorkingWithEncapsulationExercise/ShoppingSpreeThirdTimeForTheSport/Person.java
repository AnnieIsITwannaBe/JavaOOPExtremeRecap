package WorkingWithEncapsulationExercise.ShoppingSpreeThirdTimeForTheSport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static WorkingWithEncapsulationExercise.AnimalFarm.Chicken.NAME_CANNOT_BE_NULL_EMPTY_OR_WHITESPACE;

public class Person implements Identity {
    private String name;
    private double money;
    private List<Product> products;

    public double getMoney() {
        return money;
    }

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_CANNOT_BE_NULL_EMPTY_OR_WHITESPACE);
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money > 0) {
            this.money = money;
        } else throw new IllegalArgumentException("Money should be a positive value.");
    }

    public void buyProduct(Product product) {
        //how can i implement the boolean method here and also throw the illegalArguments exception
        if (this.money >= product.getCost()) {
            this.money -= product.getCost();
            this.products.add(product);
        } else throw new IllegalArgumentException
                (String.format("%s can't afford %s\n", this.getName(), product.getName()));

    }

    @Override
    public String toString() {
        return String.format("%s -%s", this.name, products.stream()
                .map(Product::getName).collect(Collectors.joining(", ")));
    }


    @Override
    public String getName() {
        return this.name;
    }
}
