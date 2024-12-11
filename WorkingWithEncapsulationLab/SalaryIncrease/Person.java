package WorkingWithEncapsulationLab.SalaryIncrease;

public class Person {

    private static final int BONUS_THRESHOLD = 30;

    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %d %.2f\n", this.name, this.age, this.salary);
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double bonusPercentage) {
        if (this.getAge() < BONUS_THRESHOLD) {
            bonusPercentage = bonusPercentage / 2;
        }
        this.setSalary(this.getSalary() + (this.getSalary() * bonusPercentage / 100));
    }

    //public void adjustSalary(double baseIncrement) {
    //        if (this.age < 30) {
    //            this.salary += baseIncrement / 2; // Employees under 30 get half the increment
    //        } else {
    //            this.salary += baseIncrement; // Others get the full increment
    //        }
}
