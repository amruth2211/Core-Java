package week5;

import java.util.ArrayList;

class Height {
    int feet;
    int inches;

    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    @Override
    public String toString() {
        return "Height [feet=" + feet + ", inches=" + inches + "]";
    }

}

abstract class Student {
    String name;
    String branch;
    Height height;

    protected Student(String name, Height height) {
        this.name = name;
        this.height = height;

    }

    protected Student(String name, String branch, Height height) {
        this.name = name;
        this.branch = branch;
        this.height = height;
    }

    public static int compareByHeight(Student s1, Student s2) {
        if (s1.height.feet > s2.height.feet) {
            return 1;
        } else if (s1.height.feet < s2.height.feet) {
            return -1;
        } else {
            if (s1.height.inches < s2.height.inches) {
                return -1;
            } else if (s1.height.feet > s2.height.feet) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "Student [branch=" + branch + ", height=" + height + ", name=" + name + "]";
    }

}

class EEEStudent extends Student {

    public EEEStudent(String name, Height height) {
        super(name, "EEE", height);
    }

}

class ECEStudent extends Student {

    public ECEStudent(String name, Height height) {
        super(name, "ECE", height);
    }

}

class CSEStudent extends Student {

    public CSEStudent(String name, Height height) {
        super(name, "CSE", height);
    }

}

class StudentAdministration {

    Student[] students;

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public StudentAdministration(Student[] students) {
        this.students = students;
    }

    public void sortByHeight(Student[] students) {

        int n = students.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Student.compareByHeight(students[i], students[j]) < 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    public void displaySortedEEEStudents() {
        ArrayList<Student> eee = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (students[i].branch.equals("EEE")) {
                eee.add(students[i]);

            }
        }
        Student a[] = eee.toArray(new Student[eee.size()]);
        sortByHeight(a);
        int i = 0;

        synchronized (this) {
            while (i < a.length) {

                System.out.println((i + 1) + ":" + a[i++]);
                notifyAll();
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException caught");
                }

            }

        }
    }

    public void displaySortedECEStudents() {
        ArrayList<Student> ece = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (students[i].branch.equals("ECE")) {
                ece.add(students[i]);

            }
        }
        Student a[] = ece.toArray(new Student[ece.size()]);
        sortByHeight(a);
        int i = 0;

        synchronized (this) {
            while (i < a.length) {

                System.out.println((i + 1) + ":" + a[i++]);
                notifyAll();
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException caught");
                }

            }

        }
    }

    public void displaySortedCSEStudents() {
        ArrayList<Student> cse = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            if (students[i].branch.equals("CSE")) {
                cse.add(students[i]);

            }
        }
        Student a[] = cse.toArray(new Student[cse.size()]);
        sortByHeight(a);
        int i = 0;

        synchronized (this) {
            while (i < a.length) {

                System.out.println((i + 1) + ":" + a[i++]);
                notifyAll();
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException caught");
                }

            }

        }

    }

}

public class UniversityDriverClass {
    public static void main(String[] args) {
        EEEStudent s1 = new EEEStudent("Amruth", new Height(5, 2));
        EEEStudent s2 = new EEEStudent("Sai", new Height(5, 8));
        CSEStudent s3 = new CSEStudent("Sahith", new Height(5, 5));
        CSEStudent s4 = new CSEStudent("Sam", new Height(5, 7));
        ECEStudent s5 = new ECEStudent("Ram", new Height(4, 5));
        ECEStudent s6 = new ECEStudent("Charan", new Height(6, 1));
        Student[] student = new Student[] { s1, s2, s3, s4, s5, s6 };
        StudentAdministration admin = new StudentAdministration(student);

        Thread cseDept = new Thread() {
            @Override
            public void run() {
                admin.displaySortedCSEStudents();
            }
        };
        cseDept.start();

        new Thread() {
            @Override
            public void run() {
                admin.displaySortedECEStudents();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                admin.displaySortedEEEStudents();
            }
        }.start();

    }
}
