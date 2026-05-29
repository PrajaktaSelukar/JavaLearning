package Collections;

import java.util.*;

public class StudentResultSystem {
    static class Student {
        String name;
        String subject;
        double marks;
        public Student(String name, String subject, double marks) {
            this.name = name;
            this.subject = subject;
            this.marks = marks;
        }
        @Override
        public String toString() {
            return "Student [name=" + name + ", subject=" + subject + ", marks=" + marks + "]";
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
    }
    public static void main(String[] args) {
        // 1. Store and display
        // Use ArrayList<Student> — add at least 8 students across 3 subjects.
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John", "CS", 99));
        students.add(new Student("Jane", "Chemistry", 80));
        students.add(new Student("Kim", "Physics", 90));
        students.add(new Student("Leo", "CS", 78));
        students.add(new Student("John", "Chemistry", 88));
        students.add(new Student("George", "Physics", 95));
        students.add(new Student("Chris", "CS", 87));
        students.add(new Student("Ian", "Chemistry", 90));

        for (Student student : students) {
            System.out.println(student);
        }
        // 2. Group by subject
        // Use HashMap<String, ArrayList<Student>> to group students by subject. Print each subject with its students.
        System.out.println("=== Students by Subject ===");
        HashMap<String, ArrayList<Student>> studentsBySubject = new HashMap<String, ArrayList<Student>>();
        for (Student student : students) {
            String subject = student.getSubject();
            ArrayList<Student> subjectStudents = studentsBySubject.getOrDefault(subject, new ArrayList<>());
            subjectStudents.add(student);
            studentsBySubject.put(subject, subjectStudents);
        }
        for(Map.Entry<String, ArrayList<Student>> entry: studentsBySubject.entrySet()) {
            System.out.print(entry.getKey() + "    :  ");
            ArrayList<Student> allStudents = entry.getValue();
            for (Student student : allStudents) {
                System.out.print(student.getName() + "(" + student.getMarks() + ")");
                System.out.print(" ");
            }
            System.out.println();
        }

        // 3. Top scorer per subject
        // For each subject in the map — find and print the student with highest marks.
        System.out.println("=== Top Scorer per Subject ===");
        for(Map.Entry<String, ArrayList<Student>> entry: studentsBySubject.entrySet()) {
            String subject = entry.getKey();
            ArrayList<Student> subjectStudents = entry.getValue();
            double highestMarks = -1;
            Student highestStudent = null;
            for (Student student : subjectStudents) {
                if (student.getMarks() > highestMarks) {
                    highestMarks = student.getMarks();
                    highestStudent = student;
                }
            }
            if (highestStudent != null) {
                System.out.println(subject + ":     " + highestStudent.getName() + "   - " + highestMarks);
            }
        }
        // 4. Deduplication check
        // Some students appear in multiple subjects. Use a HashSet<String> to find and print all unique student names.
        HashSet<String> uniqueStudents = new HashSet<>();
        for(Student student : students) {
            uniqueStudents.add(student.getName());
        }
        System.out.println("=== Unique Students ===");
        System.out.println(uniqueStudents);

        // 5. Sort
        // Sort the full list by marks descending using Comparator
        // Print top 3 students overall
        Collections.sort(students, (a, b) -> Double.compare(b.getMarks(), a.getMarks()));
        // === Top 3 Overall ===
        //1. Frank   - 95.0 (English)
        //2. Alice   - 92.0 (Maths)
        //3. Diana   - 91.0 (Science)
        System.out.println("=== Top 3 Overall ===");
        for(int i = 0; i < 3; i++) {
            Student student = students.get(i);
            System.out.println(i + 1 + ". " + student.getName() + "   - " + student.getMarks() + " (" +  student.getSubject() + ")");
        }

        // 6. Subject averages Calculate and print average marks per subject using the HashMap.
        System.out.println("=== Subject Averages ===");
        for(Map.Entry<String, ArrayList<Student>> entry: studentsBySubject.entrySet()) {
            String subject = entry.getKey();
            ArrayList<Student> subjectStudents = entry.getValue();
            double averageMarks = 0;
            for (Student student : subjectStudents) {
                averageMarks += student.getMarks();
            }
            averageMarks = averageMarks / subjectStudents.size();
            System.out.printf("%s: %.2f\n", subject, averageMarks);
        }
    }
}
