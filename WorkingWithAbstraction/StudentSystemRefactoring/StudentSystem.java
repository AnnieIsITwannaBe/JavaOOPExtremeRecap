package WorkingWithAbstractionLab.StudentSystemRefactoring;

public class StudentSystem {
    private StudentRepository studentRepository;

    private CommandRepository commandRepository;

    private boolean running;

    public StudentSystem() {
        studentRepository = new StudentRepository();
        //вместо функции с класове
        commandRepository = new CommandRepository(studentRepository);
        this.running = true;
    }

    public void ParseCommand(String[] args) {
        String command = args[0];

        String result = commandRepository.get(command).apply(args);

        if (command.equals("Show")) {
            System.out.println(result);
        } else if (command.equals("Exit")) {
            running = Boolean.parseBoolean(result);
        }
    }

    private void handleCreating(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);

        Student student = new Student(name, age, grade);
        studentRepository.create(student);
    }

    private void handlePrinting(String[] args) {
        String name = args[1];

        Student student = studentRepository.get(name);

        if (student != null) {
            System.out.println(student);
        }
    }

    public boolean isRunning() {
        return running;
    }
}
