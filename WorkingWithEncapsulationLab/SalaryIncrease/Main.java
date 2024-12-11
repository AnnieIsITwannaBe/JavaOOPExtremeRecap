package WorkingWithEncapsulationLab.SalaryIncrease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        List<Person> employees = addPeopleToDataSet(numberOfEmployees, scanner);

        double bonusPercentage = getDoubleInput(scanner);

        adjustSalary(employees, bonusPercentage);

        displayStatistics(employees);
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

    private static List<Person> addPeopleToDataSet(int n, Scanner scanner) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String firstName = data[0];
            String secondName = data[1];
            String fullName = firstName + " " + secondName;

            int age = Integer.parseInt(data[2]);
            double salary = Double.parseDouble(data[3]);

            Person currentPerson = new Person(fullName, age, salary);
            people.add(currentPerson);
        }
        return people;
    }
}
