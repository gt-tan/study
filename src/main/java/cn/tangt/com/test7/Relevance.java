package cn.tangt.com.test7;

/**
 * @author : tgt
 * @version : 1.0
 * @class : Relevance
 * @description : Relevance
 * @date : 2022/4/16
 */
public class Relevance {
    public static void main(String[] args) {
        Course c1 = new Course("c1", "1");
        Course c2 = new Course("c2", "2");
        Student s1 = new Student("Tom", "1");
        Student s2 = new Student("Jack", "2");
        Faculty f1 = new Faculty("hyy", "1");
        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.appointTeacher(f1);
        c2.addStudent(s1);
        c2.addStudent(s2);
        c2.appointTeacher(f1);
        f1.appointCourse(c1);
        f1.appointCourse(c2);
        System.out.println("选课c1的所有学生姓名：");
        for (int i = 0; i < c1.studentSize; i++) {
            System.out.println(c1.studentList[i].name);
        }
        System.out.println("选课c2的所有学生姓名：");
        for (int i = 0; i < c2.studentSize; i++) {
            System.out.println(c2.studentList[i].name);
        }
        System.out.println("hyy老师讲授的所有课程：");
        for (int i = 0; i < f1.courseSize; i++) {
            System.out.println(f1.courseList[i].courseName);
        }
        System.out.println("c1课程的主讲老师是：" + c1.teacher.name);
        System.out.println("c2课程的主讲老师是：" + c2.teacher.name);
    }
}


class Student {
    public String stuNo;
    public String name;

    public Student(String name, String no) {
        this.name = name;
        this.stuNo = no;
    }
}


class Faculty {
    public String tNo;  // 老师编号
    public String name;// 老师名字
    public Course[] courseList;// 课程列表
    public int courseSize;// 课程数

    public Faculty(String name, String no) {
        this.tNo = no;
        this.name = name;
        this.courseSize = 0;
        this.courseList = new Course[3];
    }

    public void appointCourse(Course cou) {
        if (courseSize < 3) {
            this.courseList[courseSize++] = cou;
        }
    }
}


class Course {
    public Faculty teacher;//讲授老师
    public String courseName;//课程名称
    public String courseNo;//课程号
    public Student[] studentList;//学生表
    public int studentSize;//学生人数

    public Course(String name, String no) {//构造函数
        this.courseName = name;
        this.courseNo = no;
        this.studentSize = 0;
        this.studentList = new Student[60];
    }

    public void appointTeacher(Faculty teacher) {//安排老师
        this.teacher = teacher;
    }

    public void addStudent(Student stu) {//添加学生
        if (studentSize < 60) {
            this.studentList[studentSize++] = stu;
        }
    }

}

