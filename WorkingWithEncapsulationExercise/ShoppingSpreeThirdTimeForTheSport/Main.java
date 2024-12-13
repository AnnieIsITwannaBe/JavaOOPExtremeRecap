package WorkingWithEncapsulationExercise.ShoppingSpreeThirdTimeForTheSport;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {

    public static final String TERMINATING_OPERATION = "end";
    public static final String SUCCESSFUL_PURCHASE = "%s bought %s";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Person> people = getMapOf(scanner, Person::new);

        LinkedHashMap<String, Product> products = getMapOf(scanner, Product::new);

        String userInput = scanner.nextLine();

        handlePurchaseProcess(userInput, people, products, scanner);

        System.out.println(people.values().stream().map(Person::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static void handlePurchaseProcess(String userInput, LinkedHashMap<String, Person> people, LinkedHashMap<String, Product> products, Scanner scanner) {
        while (userInput.equalsIgnoreCase(TERMINATING_OPERATION)) {
            String[] tokens = userInput.split("\\s+");

            Person targetPerson = people.get(tokens[0]);
            Product targetProduct = products.get(tokens[1]);

            if (targetPerson != null && targetProduct != null) {
                try {
                    targetPerson.buyProduct(targetProduct);
                    System.out.printf(SUCCESSFUL_PURCHASE, targetPerson.getName(), targetProduct.getName());

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            userInput = scanner.nextLine();
        }
    }

    private static <T extends Identity> LinkedHashMap<String, T> getMapOf(Scanner scanner, BiFunction<String, Double, T> constructor) {
        return Arrays.stream(scanner.nextLine().split(";")).map(s -> createEntity(s, constructor)).filter(Optional::isPresent).map(Optional::get).collect(Collectors.toMap(Identity::getName, p -> p, (x, y) -> y, LinkedHashMap::new));
    }

    public static <T> Optional<T> createEntity(String text, BiFunction<String, Double, T> constructor) {
        String[] entityData = text.split("=");
        String name = entityData[0];
        double money = Double.parseDouble(entityData[1]);

        Optional<T> entity = Optional.empty();

        try {
            entity = Optional.of(constructor.apply(name, money));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return entity;
    }
}

//notes:
// A BiFunction is a functional
// interface representing a method that takes two arguments (in this case, a String and a Double) and returns a result of type T