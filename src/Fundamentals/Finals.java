public class Finals {
    public static void main(String[] args) {
        // Problem 7 — Putting It All Together
        String[] students = {"Alice", "Bob", "Charlie", "Diana", "Eve"};
        int[] marks =       {  85,     92,      58,        76,     91  };

        // Prints each student with their grade (A/B/C/F) using a method getGrade(int marks) that returns a String
        for(int i = 0; i < students.length; i++){
            System.out.println(students[i] + " : " + marks[i] + " -> " + getGrade(marks[i]));
        }

        // Prints the class average as a double
        double classAverage = 0;
        int total = 0;
        for (int i = 0; i < marks.length; i++) {
            total += marks[i];
        }
        classAverage = (double) total / marks.length;
        System.out.println("Class Average : " + classAverage);

        // Prints the highest scorer (name + marks)
        int highestIndex = highestScorer(marks);
        System.out.println("Highest Scorer: " + students[highestIndex] + " -> " + marks[highestIndex]);

        // Prints the number of students who passed (marks >= 60)
        int passedStudent = 0;
        for (int i = 0; i < students.length; i++) {
            if (marks[i] >= 60) {
                passedStudent++;
            }
        }
        System.out.println("Students Passed: " + passedStudent + " out of " + students.length);
    }

    public static String getGrade(int marks) {
        if(marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else {
            return "F";
        }
    }

    public static int highestScorer(int[] marks) {
        int i = 0, highestIndex = 0;
        int highestScore = marks[i];
        for(i = 1; i < marks.length; i++){
            if(highestScore < marks[i]){
                highestScore = marks[i];
                highestIndex = i;
            }
        }
        return highestIndex;
    }
}
