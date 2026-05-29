package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TerminalOperations {
    static class Student {
        String name;
        String subject;
        double marks;

        public Student(String name, String subject, double marks) {
            this.name = name;
            this.subject = subject;
            this.marks = marks;
        }
        public String getName() {
            return name;
        }
        public String getSubject() {
            return subject;
        }
        public double getMarks() {
            return marks;
        }
        @Override
        public String toString() {
            return "Student [name=" + name + ", subject=" + subject + ", marks=" + marks + "]";
        }
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        // add at least 8 students across 3 subjects
        students.add(new Student("John", "CS", 70));
        students.add(new Student("Liam", "Science", 40));
        students.add(new Student("Neo", "Maths", 80));
        students.add(new Student("Kim", "CS", 77));
        students.add(new Student("Dino", "Science", 90));
        students.add(new Student("Jim", "Maths", 88));
        students.add(new Student("Ean", "CS", 34));
        students.add(new Student("Gigi", "Science", 67));
        students.add(new Student("Rimi", "Maths", 76));

        // Block 1 — count, min, max

        //Count students with marks above 70
        long countStudentsAbove70 = students.stream()
                .filter(s -> s.getMarks() > 70)
                .count();
        System.out.println(countStudentsAbove70);
        //Find student with highest marks using max()
        Optional<Student> studentsWithHighestMarks = students.stream()
                .max(Comparator.comparingDouble(Student::getMarks));
        studentsWithHighestMarks.ifPresent(System.out::println);
        //Find student with lowest marks using min()
        Optional<Student> studentsWithLowestMarks = students.stream()
                .min(Comparator.comparingDouble(Student::getMarks));
        studentsWithLowestMarks.ifPresent(System.out::println);

        //Block 2 — anyMatch, allMatch, noneMatch

        //Check if any student scored above 90
        boolean checkStudentAbove90 = students.stream()
                .anyMatch(s -> s.getMarks() > 90);
        System.out.println("Students scored above 90: " + (checkStudentAbove90 ? "Yes" : "No"));
        //Check if all students passed (marks >= 60)
        boolean checkAllStudentsPassed = students.stream()
                .allMatch(s -> s.getMarks() >= 60);
        System.out.println("All Students scored above 60: " + (checkAllStudentsPassed ? "Yes" : "No"));
        //Check if no student scored below 40
        boolean checkNoStudentScoredBelow40 = students.stream()
                .noneMatch(s -> s.getMarks() < 40);
        System.out.println("No student below 40: " + (checkNoStudentScoredBelow40 ? "Yes" : "No"));

        //Block 3 — findFirst

        //Find first student in Science subject
        Optional<Student> findFirstStudentInScience = students.stream()
                .filter(s -> s.getSubject().equals("Science"))
                .findFirst();
        findFirstStudentInScience.ifPresent(System.out::println);
        //Find first student with marks above 85 — if none found print "No student found"
        Optional<Student> findFirstStudentMarksAbove85 = students.stream()
                .filter(s -> s.getMarks() > 85)
                .findFirst();
        System.out.println(findFirstStudentMarksAbove85.isPresent()
                ? findFirstStudentMarksAbove85.get()
                : "No student found");

        //Block 4 — reduce

        //Sum all marks using reduce
        double sumAllMarks = students.stream()
                .reduce(0.0, (sum, student) -> sum + student.getMarks(), Double::sum);
        System.out.println("Sum all marks : " + sumAllMarks);
        //Find highest marks using reduce (no max() allowed)
        Optional<Student> highestMarks = students.stream()
                .reduce((a, b) -> a.getMarks() > b.getMarks() ? a : b);
        highestMarks.ifPresent(s -> System.out.println("Highest marks: " + s));

        //Block 5 — forEach

        //Print all students with marks above 75 using stream().forEach()
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .forEach(s -> System.out.println(s.getName() + " - " + s.getMarks()));
        //Print all subject names in uppercase using forEach + method reference style
        students.stream()
                .map(s -> s.getSubject().toUpperCase())
                .forEach(System.out::println);
    }
}
