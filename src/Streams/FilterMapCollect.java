package Streams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterMapCollect {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList(
                "Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "George"
        ));

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(
                5, 12, 3, 8, 21, 7, 14, 2, 18, 9
        ));
        // Block 1 — filter

        //Filter names longer than 4 characters → collect to list → print
        List<String> wordsMoreThanFourChar = names.stream()
                .filter(s -> s.length() > 4)
                .collect(Collectors.toList());
        System.out.println(wordsMoreThanFourChar);
        //Filter even numbers → collect to list → print
        List<Integer> evenNumbers = numbers.stream()
                .filter(s -> s % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);
        //Filter numbers greater than 10 → count them → print count
        long numbersGreaterThan10 = numbers.stream()
                .filter(s -> s > 10)
                .count();
        System.out.println(numbersGreaterThan10);

        //Block 2 — map

        //Convert all names to uppercase → collect to list → print
        List<String> namesToUppercase = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(namesToUppercase);
        //Multiply every number by 3 → collect to list → print
        List<Integer> numberMultiplyBy3 = numbers.stream()
                .map(n -> n * 3)
                .collect(Collectors.toList());
        System.out.println(numberMultiplyBy3);
        //Convert every number to its square → collect to list → print
        List<Integer> numbersToSquare = numbers.stream()
                .map(n -> n*n)
                .collect(Collectors.toList());
        System.out.println(numbersToSquare);

        //Block 3 — filter + map chained

        //Filter names starting with a vowel (A, E, I, O, U) → convert to lowercase → collect → print
//        List<String> namesWithVowels = names.stream()
//                .filter(s -> s.startsWith("A") || s.startsWith("E") || s.startsWith("I") || s.startsWith("O") || s.startsWith("U"))
//                .map(String::toLowerCase)
//                .collect(Collectors.toList());
        List<String> namesWithVowels = names.stream()
                .filter(s -> "AEIOU".contains(String.valueOf(s.charAt(0))))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println(namesWithVowels);
        //Filter numbers greater than 5 → multiply each by 2 → collect → print
        List<Integer> numbersGreaterThan5MultiplyBy2 = numbers.stream()
                .filter(n -> n > 5)
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println(numbersGreaterThan5MultiplyBy2);
        //Filter even numbers → convert to String with "Number: " prefix → collect → print
        List<String> filteredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> "Number: " + n.toString())
                .collect(Collectors.toList());
        System.out.println(filteredNumbers);
    }
}
