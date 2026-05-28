public class DeclarePrint {
    public static void main(String[] args) {
        // Problem 1 — Declare & Print
        String name = "Prajakta";
        int age = 25;
        double gpa = 8.5;
        boolean isStudent = false;
        char initial = 'P';

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        System.out.printf("Is student: %b%n", isStudent);
        System.out.printf("Initial: %c%n", initial);
    }
}
