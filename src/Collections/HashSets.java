package Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class HashSets {
    public static void main(String[] args) {
        // Block 1 — Basic operations
        HashSet<String> tags = new HashSet<>();

        // Add 6 tags — deliberately add 2 duplicates
        tags.add("Apple");
        tags.add("Banana");
        tags.add("Pineapple");
        tags.add("Apple");
        tags.add("Mango");
        tags.add("Pineapple");

        // Print size — show duplicates were ignored
        System.out.println(tags.size());
        // Check if a tag exists
        System.out.println(tags.contains("Berry") ? "Berry exists" : "Berry not exists");
        // Remove one tag
        tags.remove("Pineapple");
        // Iterate and print all
        for(String s : tags){
            System.out.println(s);
        }

        // Block 2 — Remove duplicates from a list
        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(4, 2, 7, 2, 9, 4, 1, 7, 3, 9)
        );
        HashSet<Integer> setNumbers = new HashSet<>(numbers);
        ArrayList<Integer> setArrayNumbers = new ArrayList<>(setNumbers);
        for(Integer number : setArrayNumbers){
            System.out.println(number);
        }

        // Block 3 — Common elements (intersection)
        HashSet<String> team1 = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie", "Diana"));
        HashSet<String> team2 = new HashSet<>(Arrays.asList("Charlie", "Eve", "Alice", "Frank"));

        // Players in both teams (intersection)
        HashSet<String> intersection = new HashSet<>();
        intersection.addAll(team1);
        intersection.retainAll(team2);
        System.out.println("Players in both teams :");
        for(String team : intersection){
            System.out.println(team);
        }
        //Players in team1 only (difference)
        HashSet<String> team1Players = new HashSet<>();
        team1Players.addAll(team1);
        team1Players.removeAll(team2);
        System.out.println("Players in team1 only :");
        for(String team : team1Players){
            System.out.println(team);
        }
        //Players in either team (union)
        HashSet<String> union = new HashSet<>();
        union.addAll(team1);
        union.addAll(team2);
        System.out.println("Players in either team :");
        for(String team : union){
            System.out.println(team);
        }
    }
}
