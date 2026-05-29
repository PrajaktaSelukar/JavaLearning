package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortingWithComparableComparator {
    static class Employee implements Comparable<Employee> {
        String name;
        String department;
        double salary;
        int experience;

        public Employee(String name, String department, double salary, int experience) {
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.experience = experience;
        }
        @Override
        public String toString() {
            return "Employee [name=" + name + ", " +
                    "department=" + department + ", " +
                    "salary=" + salary + ", " +
                    "experience=" + experience + "]";
        }
        @Override
        public int compareTo(Employee others) {
            return Double.compare(salary, others.salary);
        }
    }
    static Comparator<Employee> byName = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareTo(o2.name);
        }
    };
    static Comparator<Employee> bySalary = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return Double.compare(o2.salary, o1.salary);
        }
    };

    public static void main(String[] args) {
        // Block 1 — Comparable Make Employee implement Comparable<Employee> — natural order by salary ascending.
        ArrayList<Employee> employees = new ArrayList<>();
        // add at least 6 employees across different departments
        employees.add(new Employee("Josh", "CS", 45678, 2));
        employees.add(new Employee("Kim", "Science", 87654, 4));
        employees.add(new Employee("Hugh", "History", 34565, 12));
        employees.add(new Employee("Neo", "Maths", 76546, 6));
        employees.add(new Employee("Deo", "English", 54567, 5));
        employees.add(new Employee("Liam", "Sanskrit", 66554, 7));

        Collections.sort(employees);   // should work automatically
        // print all after sorting
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Block 2 — Comparator, multiple sort orders
        // By name alphabetically
        System.out.println("By name alphabetically");
        Collections.sort(employees, byName);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        //By salary descending
        System.out.println("By salary descending");
        Collections.sort(employees, bySalary);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        //By experience descending
        System.out.println("By experience descending");
        Collections.sort(employees, (a, b) -> b.experience - a.experience);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        //By department alphabetically, then by salary descending within same department
        System.out.println("By department alphabetically, then by salary descending within same department");
        employees.sort(Comparator.comparing((Employee e) -> e.department)
                                .thenComparing((Employee e) -> -e.salary));
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Block 3 — PriorityQueue with Comparator
        System.out.println("PriorityQueue with Comparator");
        // Create a PriorityQueue that always gives the highest paid employee first
        PriorityQueue<Employee> pq = new PriorityQueue<>(
                (e1, e2) -> Double.compare(e2.salary, e1.salary)
        );
        for (Employee employee : employees) {
            pq.add(employee);
        }
        //Poll all employees out one by one and print them — should come out in salary descending order
        while (!pq.isEmpty()) {
            Employee e = pq.poll();
            System.out.println(e);
        }
    }
}
