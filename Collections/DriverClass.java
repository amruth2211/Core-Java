package Collections;

import java.util.ArrayList;
import java.lang.Comparable;
import java.util.Collections;

class Employee {
    protected long employeeId;
    protected String firstName;
    protected String lastName;

    public Employee(long employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // @Override
    public int compareTo(Object o) {
        Employee other = (Employee) o;
        if (this.getEmployeeId() > other.getEmployeeId())
            return 1;
        else if (this.getEmployeeId() < other.getEmployeeId())
            return -1;
        else
            return 0;
    }

    public boolean isEqual(Employee e) {
        if (e == null)
            return false;
        if (!(e instanceof Employee))
            return false;
        if (this == e)
            return true;

        return this.employeeId == e.employeeId && this.firstName == e.firstName;

    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}

public class DriverClass {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(345, "abbss", "eqd"));
        list.add(new Employee(123, "qwert", "sjsik"));
        list.add(new Employee(678, "ertf", "dwdSD"));

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) == 1) {
                    Collections.swap(list, j, j + 1);
                }

            }
        }
        list.forEach(System.out::println);

        // System.out.println(list.get(0).isEqual(list.get(1)));
        // System.out.println(list.get(1).compareTo(list.get(2)));
    }
}
