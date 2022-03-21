package StreamsAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }
}

public class EmployeeStatistics {
    public static void main(String[] args) {
        Employee emp1 = new Employee(3, "Vishal Singhal", 34, "male", "HR", 2013, 300000);
        Employee emp2 = new Employee(4, "Amitabh Singh", 35, "male", "Admin", 2014, 500000);
        Employee emp3 = new Employee(5, "Vivek Bhati", 28, "male", "Admin", 2017, 500000);
        Employee emp4 = new Employee(6, "Vipul Diwan", 34, "male", "Account", 2014, 200000);
        Employee emp5 = new Employee(7, "Satish Kumar", 29, "male", "Account", 2017, 75000);
        Employee emp6 = new Employee(8, "Geetika Chauhan", 30, "female", "Admin", 2016, 90000);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);
        employeeList.add(emp6);

        // Count the number of employees in each department.
        HashMap<String, Integer> map = new HashMap<>();
        for (Employee emp : employeeList) {
            map.put(emp.department, map.getOrDefault(emp.department, 0) + 1);
        }

        // Find out the average salary of male and female employees.
        double msum = 0, fsum = 0;
        int mcount = 0, fcount = 0;
        for (Employee employee : employeeList) {
            if (employee.gender.equals("male")) {
                msum += employee.salary;
                mcount++;

            } else {
                fsum += employee.salary;
                fcount++;
            }
        }
        System.out.println("{feamle=" + fsum / fcount + ", male=" +
                msum / mcount + "}");

        // Get the details of the highest-paid employee in the organization from the
        // given list of employees.
        Optional<Employee> highestPaid = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(highestPaid);

        // Get the average age of each department in an organization.
        Map<String, Double> agemap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(agemap);

        // Find out who is the senior-most employee in the organization in terms of
        // experience.
        Optional<Employee> experience = employeeList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
        System.out.println(experience);

        // Get the details of the youngest employee in the organization.
        Optional<Employee> minAge = employeeList.stream().min(Comparator.comparingInt(Employee::getAge));
        System.out.println(minAge);

        // Get the number of employees in each department if you have given a list of
        // employees.
        Map<String, Long> employeeByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(employeeByDept);

        // Find out the number of male and female employees in the organization.
        Map<String, Long> employeeByGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(employeeByGender);
    }
}
