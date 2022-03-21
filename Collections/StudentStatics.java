package Collections;

import java.util.ArrayList;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int id;
    private String subject;

    double percentage;

    public Student(String name, int id, String subject, double percentage) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public int compareTo(Student o) {

        return (int) (o.percentage - this.percentage);
    }

    @Override
    public String toString() {
        return name + "-" + id + "-" + subject + "-" + percentage;
    }
}

public class StudentStatics {
    public static void main(String[] args) {
        Student student1 = new Student("Dinesh", 1, "Algorithms", 75);
        Student student2 = new Student("Arnav", 2, "Automata", 55);
        Student student3 = new Student("Anamika", 3, "Databases", 80);
        Student student4 = new Student("Vishal", 4, "Networking", 40);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        // Partition the students who got above 60% from those who didn’t.
        List<Student> a = new ArrayList<>();
        List<Student> b = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPercentage() > 60) {
                a.add(studentList.get(i));
            } else
                b.add(studentList.get(i));
        }
        System.out.println("{false=" + b + ", true=" + a);

        // Get the names of the top 3 performing students
        List<Student> topList = studentList.stream().sorted().toList();
        for (int i = 0; i < 3; i++) {
            System.out.print(topList.get(i) + " , ");
        }

        System.out.println();
        // " Get the name and percentage of each student."
        for (Student student : studentList) {
            System.out.print(student.getName() + "=" + student.getPercentage() + " ");
        }

        System.out.println();
        // Get the set of subjects offered in the college
        for (Student student : studentList) {
            System.out.print(student.getSubject() + " , ");
        }

        System.out.println("\nHighest Percentage: " + topList.get(0).getPercentage());
        System.out.println("Lowest Percentage: " + topList.get(topList.size() - 1).getPercentage());
        double average = studentList.stream().mapToDouble(Student::getPercentage).average().getAsDouble();
        System.out.println("Average Percentage: " + average);

        // Get total number of students from the given list of students
        System.out.println(studentList.size());

        // Get the students grouped by subject from the given list of students
        for (Student student : studentList) {
            System.out.print(student.getSubject() + " [ " + student + " ] ");
        }

    }
}
