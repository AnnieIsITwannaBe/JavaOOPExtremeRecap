package WorkingWithEncapsulationExercise.ShoppingSpreeRefined;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {
    private static final String TERMINATING_COMMAND = "end";
    public static final String PURCHASE_SUCCESSFUL = "%s bought successfully %s\n";
    public static final String PURCHASE_UNSUCCESSFUL = "%s does not have enough money to buy %s";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = readMapOf(scanner, Person::new);

        LinkedHashMap<String, Product> products = readMapOf(scanner, Product::new);

        //.equalsIgnoreCase
        String line = scanner.nextLine();

        while (!line.equalsIgnoreCase(TERMINATING_COMMAND)) {
            String[] tokens = line.split("\\s+");

            Person person = people.get(tokens[0]);

            Product product = products.get(tokens[1]);

            if (person == null) {
                continue;
            }
            if (product == null) {
                continue;
            }

            if (person.getMoney() >= product.getCost()) {
                person.buyProduct(product);
                System.out.printf(PURCHASE_SUCCESSFUL, person.getName(), product.getName());
            } else {
                System.out.printf(PURCHASE_UNSUCCESSFUL, person.getName(), product.getName());
            }

            line = scanner.nextLine();
        }

        System.out.println(people.values().stream()
                .map(Person::toString).collect(Collectors.joining(System.lineSeparator())));
    }

    private static <T extends Identity> LinkedHashMap<String, T>
    readMapOf(Scanner scanner, BiFunction<String, Double, T> constructor) {
        return Arrays.stream(scanner.nextLine()
                        .split(";")).map(s -> createEntity(s, constructor))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toMap(T::getName, p -> p, (x, y) -> y, LinkedHashMap::new));
        //трябва ни функционалност, която е споделена между различни типове
        //интерфейсите са специален тип класове, които дефинират общо поведение
    }

    //capturing scope Generics:
    private static <T> Optional<T> createEntity(String input, BiFunction<String, Double, T> constructor) {
        String[] tokens = input.split("=");
        String name = tokens[0];
        double money = Double.parseDouble(tokens[1]);

        Optional<T> entity = Optional.empty();

        try {
            entity = Optional.of(constructor.apply(name, money));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }
}

//notes on the last part of the lambda