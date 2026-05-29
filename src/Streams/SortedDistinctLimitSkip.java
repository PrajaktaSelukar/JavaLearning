package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class SortedDistinctLimitSkip {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(Arrays.asList(
                "Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "George"
        ));

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(
                5, 12, 3, 8, 21, 7, 14, 2, 18, 9, 5, 3, 8
        ));
        // Block 1 — sorted

        //Sort names alphabetically → print
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNames);
        //Sort names by length → print
        List<String> sortNamesByLength = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(sortNamesByLength);
        //Sort numbers descending → print
        List<Integer> numbersDescending = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(numbersDescending);

        //Block 2 — distinct

        //Remove duplicates from numbers → collect → print
        List<Integer> removeDuplicates = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(removeDuplicates);
        //Get distinct name lengths → collect → print
        List<Integer> distinctNameLength = names.stream()
                .map(String::length)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNameLength);

        //Block 3 — limit and skip

        //Sort numbers ascending → take first 5 → print
        List<Integer> sortNumbersAscending = numbers.stream()
                .sorted()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(sortNumbersAscending);
        //Sort numbers ascending → skip first 3 → print
        List<Integer> sortNumbersAscendingSkip3 = numbers.stream()
                .sorted()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(sortNumbersAscendingSkip3);
        //Sort names alphabetically → skip 2 → take 3 → print
        List<String> sortNamesAscendingSkip2Take3 = names.stream()
                .sorted()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(sortNamesAscendingSkip2Take3);

        //Block 4 — chained all together

        //From numbers: remove duplicates → filter > 5 → sort descending → take top 3 → print
        List<Integer> removeDupsFilterSort = numbers.stream()
                .distinct()
                .filter(n -> n > 5)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(removeDupsFilterSort);
        //From names: filter length > 3 → sort alphabetically → skip 1 → collect → print
        List<String> filteredLen3SortSkip = names.stream()
                .filter(s -> s.length() > 3)
                .sorted()
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(filteredLen3SortSkip);
    }
}
