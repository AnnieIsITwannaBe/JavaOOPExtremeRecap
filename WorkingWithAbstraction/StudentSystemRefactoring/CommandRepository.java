package WorkingWithAbstractionLab.StudentSystemRefactoring;

import java.util.Map;
import java.util.function.Function;

public class CommandRepository {
    private Map<String, Function<String[], String>> commandByName;

    private StudentRepository studentRepository;

    CommandRepository(StudentRepository studentRepository) {
        this.commandByName = setUpCommands(studentRepository);
        this.studentRepository = studentRepository;
    }

    private static Map<String, Function<String[], String>> setUpCommands(StudentRepository studentRepository) {

        Function<String[], String> create = arr -> {
            String name = arr[0];
            int age = Integer.parseInt(arr[1]);
            double grade = Double.parseDouble(arr[2]);

            Student student = new Student(name, age, grade);
            studentRepository.create(student);
            return name + " was created.";
        };

        Function<String[], String> show = arr -> {
            String name = arr[1];

            Student student = studentRepository.get(name);

            return student == null
                    ? "No student with name: " + name + " was found  in the database."
                    : "this is the student: " + student.getName() + ".";
        };

        return Map.of("Create", create, "Show", show, "Exit", arr -> "true");


    }

    public Function<String[], String> get(String command) {
        return commandByName.get(command);
    }
}
