package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class FinalStreamTogether {
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
        // Task — Rebuild the Student Result System using Streams
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

        // 1. Print all students using forEach
        students.stream()
                .forEach(System.out::println);

        //2. Group by subject using Collectors.groupingBy — print each subject and students
        Map<String, List<Student>> groupStudentsBySubject = students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.toList()));
        for (Map.Entry<String, List<Student>> entry : groupStudentsBySubject.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //3. Top scorer per subject using groupingBy + Collectors.maxBy — print name and marks
        Map<String, Optional<Student>> topScorerPerSubject = students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.maxBy(Comparator.comparingDouble(Student::getMarks))));
        for (Map.Entry<String, Optional<Student>> entry : topScorerPerSubject.entrySet()) {
            entry.getValue().ifPresent(s -> System.out.println(entry.getKey() + " : " + s.getMarks()));
        }

        //4. Unique student names using stream + Collectors.toSet() — print sorted alphabetically
        List<String> uniqueStudents = students.stream()
                .map(Student::getName)
                .sorted()
                .collect(Collectors.toList());
        for (String studentName : uniqueStudents) {
            System.out.println(studentName);
        }
        //5. Top 3 overall — sort descending by marks → limit(3) → print with rank:
        List<Student> top3OOverallMarks = students.stream()
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .limit(3)
                .toList();
        for(int index = 0; index < top3OOverallMarks.size(); index++){
            Student student = top3OOverallMarks.get(index);
            System.out.println(index + 1 + ": " + student.getName() + "  -  " + student.getMarks() + " (" + student.getSubject() + ")");
        }
        //6. Subject averages using Collectors.averagingDouble — print formatted to 2 decimal places
        Map<String, Double> subjectAverage = students.stream()
                .collect(Collectors.groupingBy(Student::getSubject, Collectors.averagingDouble(Student::getMarks)));
        for (Map.Entry<String, Double> entry : subjectAverage.entrySet()) {
            System.out.printf("%s : %.2f\n", entry.getKey(), entry.getValue());
        }

        //7. Pass/Fail summary — count passed (>=60) and failed (<60) using streams:
        long passCount = students.stream()
                .filter(s -> s.getMarks() >= 60)
                .count();
        long failCount = students.stream()
                .filter(s -> s.getMarks() < 60)
                .count();
        System.out.println("Passed: " + passCount);
        System.out.println("Failed: " + failCount);
        
        //8. All names joined — names of students who passed, sorted alphabetically, joined with ", " → print
        String passStudentsJoin = students.stream()
                .filter(s -> s.getMarks() >= 60)
                .sorted(Comparator.comparing(Student::getName))
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        System.out.println(passStudentsJoin);
    }
}
