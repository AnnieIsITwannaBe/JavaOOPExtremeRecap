package WorkingWithAbstractionLab.StudentSystemRefactoring;

public class Student {
    public static final double VERY_GOOD_GRADE = 5.00;
    public static final double AVERAGE_GRADE_LOWERBOUND = 3.50;
    public static final String EXCELLENT_STUDENT_DISPLAY_MESSAGE = " Excellent student.";
    public static final String AVERAGE_STUDENT_DISPLAY_MESSAGE = " Average student.";
    public static final String LOW_GRADE_DISPLAY_MESSAGE = " Very nice person.";
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s is %s years old.", this.name, this.age) + getGradeCommentary();
    }

    public String getGradeCommentary() {
        String commentary = " ";
        if (this.grade >= VERY_GOOD_GRADE) {
            commentary += EXCELLENT_STUDENT_DISPLAY_MESSAGE;
        } else if (this.grade < VERY_GOOD_GRADE && this.grade >= AVERAGE_GRADE_LOWERBOUND) {
            commentary += AVERAGE_STUDENT_DISPLAY_MESSAGE;
        } else {
            return LOW_GRADE_DISPLAY_MESSAGE;
        }
        return commentary;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
