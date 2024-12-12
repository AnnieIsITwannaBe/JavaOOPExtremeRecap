package WorkingWithEncapsulationExercise.ClassBox;

import WorkingWithEncapsulationExercise.ClassBox.Box;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int weight = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        Optional<Box> box = Optional.empty();

        try {
            box = Optional.of(new Box(length, weight, height));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (box.isPresent()) {
            System.out.println(box.toString());
        }
    }
}
