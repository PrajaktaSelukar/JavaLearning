package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector {
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

        System.out.println("==== Block 1 — groupingBy =====");
        //Group students by subject → Map<String, List<Student>>
        Map<String, List<Student>> groupStudentsBySubject = students.stream()
                .collect(Collectors.groupingBy((Student s) -> s.getSubject()));
        //Print each subject and its students
        for(Map.Entry<String, List<Student>> entry : groupStudentsBySubject.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("====== Block 2 — counting per group =======");

        //Count students per subject → Map<String, Long>
        Map<String, Long> countStudentsPerSubject = students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()));
        //Print each subject and count
        for(Map.Entry<String, Long> entry : countStudentsPerSubject.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("===== Block 3 — averagingDouble per group =====");

        //Average marks per subject → Map<String, Double>
        Map<String, Double> averageMarksPerSubject = students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.averagingDouble(Student::getMarks)));
        //Print each subject and average formatted to 2 decimal places
        for(Map.Entry<String, Double> entry : averageMarksPerSubject.entrySet()) {
            System.out.printf("%s : %.2f%n", entry.getKey(), entry.getValue());
        }

        System.out.println("==== Block 4 — toMap ====");

        //Create a Map<String, Double> of name → marks
        Map<String, Double> mapNameMarks = students.stream()
                .collect(Collectors.toMap(Student::getName, Student::getMarks));
        //Print each entry
        for(Map.Entry<String, Double> entry : mapNameMarks.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("==== Block 5 — joining ====");

        //Join all student names into one comma-separated String → print
        String joinAllStudentNames = students.stream()
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        System.out.println("All student names : " + joinAllStudentNames);
        //Join names of students scoring above 75 with " | " separator → print
        String joinStudentsScoringAbove75 = students.stream()
                .filter(s -> s.getMarks() > 75)
                .map(Student::getName)
                .collect(Collectors.joining(" | "));
        System.out.println("Students Names Scoring Above 75 : " + joinStudentsScoringAbove75);

        System.out.println("==== Block 6 — chained collectors ====");

        //Group by subject → get only the names per subject → Map<String, List<String>>
        Map<String, List<String>> groupBySubject = students.stream()
                .collect((Collectors.groupingBy(Student::getSubject, Collectors.mapping(Student::getName, Collectors.toList()))));
        for(Map.Entry<String, List<String>> entry : groupBySubject.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //Group by subject → get the top scorer per subject → Map<String, Optional<Student>>
        Map<String, Optional<Student>> groupBySubjectTopScorer = students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.maxBy(Comparator.comparingDouble(Student::getMarks))));
        for(Map.Entry<String, Optional<Student>> entry : groupBySubjectTopScorer.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            entry.getValue().ifPresent(System.out::println);
        }
    }
}
