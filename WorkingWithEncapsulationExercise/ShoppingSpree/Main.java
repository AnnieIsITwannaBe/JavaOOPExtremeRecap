package WorkingWithEncapsulationExercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final String TERMINATING_COMMAND = "End";
    public static final String SPLITERATOR = ";";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personData = getInput(scanner);
        String[] productData = getInput(scanner);

        //think about how to put this into a single method:
        List<Person> people = addPeopleToDataBase(personData);
        List<Product> products = addProductsToDataBase(productData);


        String line = scanner.nextLine();

        while (!TERMINATING_COMMAND.equals(line)) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String product = tokens[1];

            //this stream API can also be refactored in a way in which it will be a single method:
            Person targetPerson =
                    people.stream().filter(person -> person.getName().equals(name)).findFirst().orElse(null);

            Product targetProduct =
                    products.stream().filter(product1 -> product1.getName().equals(product)).findFirst().orElse(null);

            assert targetProduct != null;
            assert targetPerson != null;
            targetPerson.buyProduct(targetProduct);

            line = scanner.nextLine();
        }
    }

    private static List<Product> addProductsToDataBase(String[] productData) {
        List<Product> products = new ArrayList<>();
        for (String productDatum : productData) {
            String[] tokens = productDatum.split("=");
            String productName = tokens[0];
            double cost = Double.parseDouble(tokens[1]);

            Optional<Product> product = Optional.empty();

            try {
                product = Optional.of(new Product(productName, cost));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            product.ifPresent(products::add);
        }
        return products;
    }

    private static List<Person> addPeopleToDataBase(String[] personData) {
        List<Person> people = new ArrayList<>();
        for (String personDatum : personData) {
            String[] tokens = personDatum.split("=");

            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);

            Optional<Person> person = Optional.empty();
            try {
                person = Optional.of(new Person(name, money));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            person.ifPresent(people::add);
        }
        return people;
    }

    private static String[] getInput(Scanner scanner) {
        return scanner.nextLine().split(SPLITERATOR);
    }
}
