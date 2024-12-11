package WorkingWithEncapsulationLab.ValidationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        List<Person> employees = addPeopleToDataSet(numberOfEmployees, scanner);

        double bonusPercentage = getDoubleInput(scanner);

        adjustSalary(employees, bonusPercentage);

        displayStatistics(employees);
    }

    private static List<Person> addPeopleToDataSet(int n, Scanner scanner) throws IllegalAccessException {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            Optional<Person> person = Optional.empty();

            try {
                person = Optional.of(new Person(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3])));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            person.ifPresent(people::add);
        }
        return people;
    }

    private static double getDoubleInput(Scanner scanner) {
        return Double.parseDouble(scanner.nextLine());
    }

    private static void displayStatistics(List<Person> people) {
        people.forEach(System.out::println);
    }

    private static void adjustSalary(List<Person> people, double bonusPercentage) {
        for (Person currentPerson : people) {
            currentPerson.increaseSalary(bonusPercentage);
        }
    }
}

