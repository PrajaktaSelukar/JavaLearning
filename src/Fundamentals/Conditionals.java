public class Conditionals {
    public static void main(String[] args) {
        // Problem 3 — Conditionals
        int marks = 95;

        if(marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else if (marks >= 60) {
            System.out.println("Grade C");
        } else {
            System.out.println("Grade F");
        }

        String result = marks >= 60 ? "Pass" : "Fail";
        System.out.println(result);
    }
}
