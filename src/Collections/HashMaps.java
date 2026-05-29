package Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMaps {
    public  static void main(String[] args) {
        // Problem 2 — HashMap
        // Block 1 — Basic operations
        HashMap<String, Integer> wordCount = new HashMap<>();

        // Add 5 words with their character counts (e.g. "apple" → 5)
        wordCount.put("Apple", 5);
        wordCount.put("Banana", 6);
        wordCount.put("Pineapple", 9);
        wordCount.put("Mango", 5);
        wordCount.put("Orange", 6);

        // Print all key-value pairs using entrySet()
        for(Map.Entry<String, Integer> entry: wordCount.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
        }
        // Update one value
        wordCount.put("Apple", 9);
        // Remove one entry
        wordCount.remove("Pineapple");
        // Check if key "banana" exists
        System.out.println(wordCount.containsKey("Banana") ? "Banana exists" : "Banana does not exist");
        // Get a value that doesn't exist safely — use getOrDefault
        System.out.println(wordCount.getOrDefault("Papaya", 8));

        // Block 2 — Frequency counter
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        HashMap<String, Integer> wordCount2 = new HashMap<>();
        for(String word: words) {
            wordCount2.put(word, wordCount2.getOrDefault(word, 0) + 1);
        }
        // Print all
        for(Map.Entry<String, Integer> entry: wordCount2.entrySet()) {
            System.out.println(entry.getKey() + "-> " + entry.getValue());
        }

        // Block 3 — Invert a map
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 92);

        HashMap<Integer, String> reverseScore = new HashMap<>();
        for(Map.Entry<String, Integer> entry: scores.entrySet()) {
            reverseScore.put(entry.getValue(), entry.getKey());
        }
        // Print all
        for(Map.Entry<Integer, String> entry: reverseScore.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
        }
    }
}
