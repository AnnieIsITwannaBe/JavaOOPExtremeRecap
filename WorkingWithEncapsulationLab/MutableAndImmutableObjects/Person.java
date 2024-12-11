package WorkingWithEncapsulationLab.MutableAndImmutableObjects;

public class Person {


    private static final int MIN_NAME_LENGTH_CRITERION = 3;
    private static final String NAME_LENGTH_DOES_NOT_MEET_APPLICATION_CRITERION_MESSAGE = "The name you're currently providing is not long enough, please try again";

    private static final int MIN_AGE_CRITERION = 1;
    private static final String AGE_VALUE_DOES_NOT_MEET_APPLICATION_CRITERION_MESSAGE = "Your age must be a positive value and above 0, please try again";

    private static final Double MIN_SALARY_THRESHOLD = 460.00;
    private static final String SALARY_VALUE_DOES_NOT_MEET_APPLICATION_CRITERION_MESSAGE = "Salary can't be less than %.2f";
    private static final int BONUS_THRESHOLD = 30;

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) throws IllegalAccessException {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public void setSalary(double salary) {
        if (salary < MIN_SALARY_THRESHOLD) {
            throw new IllegalArgumentException(String.format(SALARY_VALUE_DOES_NOT_MEET_APPLICATION_CRITERION_MESSAGE, MIN_SALARY_THRESHOLD));
        }
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    //This design is cleaner, more maintainable, and aligns well with common Java practices.
    private void setFirstName(String firstName) throws IllegalAccessException {
        //Handles null and validates length properly.
        if (firstName == null || firstName.length() < MIN_NAME_LENGTH_CRITERION) {
            throw new IllegalArgumentException(NAME_LENGTH_DOES_NOT_MEET_APPLICATION_CRITERION_MESSAGE);
            //IllegalArgumentException communicates that the issue is with the provided argument.
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName == null || lastName.length() < MIN_NAME_LENGTH_CRITERION) {
            throw new IllegalArgumentException(NAME_LENGTH_DOES_NOT_MEET_APPLICATION_CRITERION_MESSAGE);
        }
        this.lastName = lastName;
    }

    private void setAge(int age) {
        if (age < MIN_AGE_CRITERION) {
            throw new IllegalArgumentException(AGE_VALUE_DOES_NOT_MEET_APPLICATION_CRITERION_MESSAGE);
        }
        this.age = age;
    }

    public void increaseSalary(double bonusPercentage) {
        if (this.getAge() < BONUS_THRESHOLD) {
            bonusPercentage = bonusPercentage / 2;
        }
        this.setSalary(this.getSalary() + (this.getSalary() * bonusPercentage / 100));
    }
}
