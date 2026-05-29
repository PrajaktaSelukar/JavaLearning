package Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLists {
    static class Student {
        private String name;
        private double marks;
        public Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }
        public String toString() {
            return "Student [name: " + name + ", marks: " + marks + "]";
        }
        public String getName() {
            return name;
        }
        public double getMarks() {
            return marks;
        }
    }
    public  static void main(String[] args) {
        // Problem 1: ArrayList
        // Block 1 — Basic operations
        ArrayList<String> fruits = new ArrayList<>();
        // Add 5 fruits
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Mango");
        // Print all using for-each
        for(String fruit : fruits){
            System.out.println(fruit);
        }
        //Update the second fruit to something else
        fruits.set(1, "Blueberry");

        //Remove one fruit by name, one by index
        System.out.println("Fruits size: " + fruits.size());
        fruits.remove(3);
        System.out.println("Fruits size: " + fruits.size());
        fruits.remove("Apple");

        //Print size before and after removals
        System.out.println("Fruits size: " + fruits.size());

        //Check if "Mango" exists — print result
        System.out.println(fruits.contains("Mango") ? "Mango exists" : "Mango does not exists");

        // Block 2 — ArrayList with objects
        ArrayList<Student>  students = new ArrayList<>();
        students.add(new Student("Mike", 12.5));
        students.add(new Student("Kim", 45.1));
        students.add(new Student("Leo", 89.2));
        students.add(new Student("Ross", 67.9));
        students.add(new Student("Hugh", 34.6));
        students.add(new Student("Pasco", 78.9));
        students.add(new Student("Jim", 23.3));
        students.add(new Student("Ean", 78.7));

        // Print all students using toString()
        for(Student student : students){
            System.out.println(student.toString());
        }

        // Find and print the student with highest marks (loop — no sorting yet)
        double highestMark = -1;
        int highestIndex = 0;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).getMarks() > highestMark) {
                highestMark = students.get(i).getMarks();
                highestIndex = i;
            }
        }
        System.out.println("Highest mark: " + highestMark + ". Student: " + students.get(highestIndex).getName());

        // Remove all students with marks below 60
        for(int j = students.size() - 1; j >= 0; j--){
            if(students.get(j).getMarks() < 60) {
                students.remove(j);
            }
        }
        // Print all students using toString()
        for(Student student : students){
            System.out.println(student);
        }

        // Block 3 — Conversion
        // Convert this array to an ArrayList and add two more elements
        String[] cities = {"Mumbai", "Delhi", "Bangalore"};
        ArrayList<String> cityList = new ArrayList<>(Arrays.asList(cities));
        cityList.add("Hyderabad");
        cityList.add("Pune");
        String[] backArrayCity = cityList.toArray(new String[cityList.size()]);
        for(String city : backArrayCity){
            System.out.println(city);
        }
    }
}
