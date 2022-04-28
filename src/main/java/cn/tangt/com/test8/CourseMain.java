package cn.tangt.com.test8;

/**
 * @author tan
 * @date 2022/04/28 14:09
 */
class CourseNew {
    Student[] student = new Student[2];
    String courseName;
    int number = 0;

    public CourseNew(String courseName) {
        this.courseName = courseName;
    }

    public void increaseSize() {
        if (number == student.length) {
            Student[] stu1 = new Student[2 * number];
            System.arraycopy(student, 0, stu1, 0, number);
            student = stu1;
        }
    }

    public void addStudent(Student s) {
        for (int i = 0; i < number; i++) {
            if (student[i].getName().equals(s.getName()))
                return;
        }
        student[number] = s;
        number++;
        increaseSize();
    }

    public int getNumberOfStudents() {
        return number;
    }

    public void dropStudent(Student s) {
        for (int i = 0; i < number; i++) {
            if (student[i].getName().equals(s.getName())) {
                if (number - 1 - i >= 0) System.arraycopy(student, i + 1, student, i, number - 1 - i);
                number--;
            }
        }
    }

    public Student[] getStudents() {
        return student;
    }

    public void clear() {
        student = null;
        number = 0;
    }

    public boolean contains(Student s) {
        for (int i = 0; i < number; i++) {
            if (student[i] == s)
                return true;
        }
        return false;
    }
}

class Student {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

public class CourseMain {
    public static void main(String[] args) {
        CourseNew course1 = new CourseNew("Data Structures");
        CourseNew course2 = new CourseNew("Database Systems");
        Student s1 = new Student("Peter Jones");
        Student s2 = new Student("Brian Smith");
        Student s3 = new Student("Anne Kennedy");
        Student s4 = new Student("Susan Kennedy");
        Student s5 = new Student("Kim Johnson");
        Student s6 = new Student("Peter Jones");
        Student s7 = new Student("Steve Smith");
        course1.addStudent(s1);
        course1.addStudent(s2);
        course1.addStudent(s3);
        course1.addStudent(s4);
        course1.addStudent(s5);
        course1.addStudent(s6);
        course1.addStudent(s7);
        course2.addStudent(s6);
        course2.addStudent(s7);
        System.out.println("Number of students in course1: " + course1.getNumberOfStudents());
        Student[] students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++)
            System.out.print(students[i].getName() + ", ");
        System.out.println();
        System.out.print("Number of students in course2: " + course2.getNumberOfStudents());
        System.out.println();
        course1.dropStudent(s6);
        System.out.println("Number of students in course1: " + course1.getNumberOfStudents());
        students = course1.getStudents();
        for (int i = 0; i < course1.getNumberOfStudents(); i++)
            System.out.print(students[i].getName() + ", ");
        course1.clear();
        System.out.println("\nNumber of students in course1: " + course1.getNumberOfStudents());
    }
}
