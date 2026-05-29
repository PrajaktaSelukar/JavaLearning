# STEP 9. STREAMS & LAMBDAS
## LAMBDA
```
// Regular method
public int add(int a, int b) {
    return a + b;
}
// Same thing as Lambda
(a, b) -> a + b

// No parameters
() -> System.out.println("Hello")

// One parameter — brackets optional
x -> x * 2

// Multiple parameters
(a, b) -> a + b

// Multiple lines — need braces and return
(a, b) -> {
    int sum = a + b;
    return sum;
}
```
```
// 1. Static method
Math::abs                    // n -> Math.abs(n)

// 2. Instance method on a specific object
System.out::println          // s -> System.out.println(s)

// 3. Instance method on an arbitrary object of a type
String::toUpperCase          // s -> s.toUpperCase()
String::compareTo            // (a, b) -> a.compareTo(b)

// 4. Constructor
ArrayList::new               // () -> new ArrayList<>()
Student::new                 // name -> new Student(name)

// Usage
list.forEach(System.out::println);   // ✅ cleaner than s -> System.out.println(s)
```
## STREAM
- A Stream is a pipeline of operations on a collection — process data without writing loops.
```
list.stream()           // source — creates stream from list
    .filter(...)        // intermediate — keep matching elements
    .map(...)           // intermediate — transform elements
    .sorted(...)        // intermediate — sort
    .collect(...)       // terminal — collect results back to list
```
## CREATING STREAMS
```
// From ArrayList
list.stream()

// From Array
Arrays.stream(arr)

// From values directly
Stream.of("Alice", "Bob", "Charlie")

// Infinite stream (careful!)
Stream.iterate(0, n -> n + 1)   // 0, 1, 2, 3, ...
```
## INTERMEDIATE OPERATIONS
### filter — keep elements matching condition
```
// Keep only even numbers
list.stream()
    .filter(n -> n % 2 == 0)

// Keep students with marks > 60
students.stream()
        .filter(s -> s.getMarks() > 60)
```
### map — transform each element
```
// Double every number
list.stream()
    .map(n -> n * 2)

// Get just the names from students
students.stream()
        .map(s -> s.getName())
        // or: .map(Student::getName)
```
### sorted — sort elements
```
// Natural order
stream.sorted()

// Custom order
stream.sorted((a, b) -> Double.compare(b.getMarks(), a.getMarks()))
// or:
stream.sorted(Comparator.comparingDouble(Student::getMarks).reversed())
```
### distinct — remove duplicates
```
list.stream().distinct()
```
### limit — take first N elements
```
stream.limit(3)   // first 3 only
```
### skip — skip first N elements
```
stream.skip(2)    // skip first 2
```
### peek — look at elements without changing them (debugging)
```
stream.peek(s -> System.out.println("Processing: " + s))
```
### mapToInt, mapToDouble — convert to numeric stream
```
// Needed for sum, average, max, min
students.stream()
        .mapToDouble(Student::getMarks)
        .average()
```

## TERMINAL OPERATIONS
### collect — gather into collection
```
// To List
List<String> names = students.stream()
                              .map(Student::getName)
                              .collect(Collectors.toList());

// To Set
Set<String> unique = students.stream()
                              .map(Student::getName)
                              .collect(Collectors.toSet());

// To Map
Map<String, Double> nameToMarks = students.stream()
    .collect(Collectors.toMap(
        Student::getName,    // key
        Student::getMarks    // value
    ));

// Group by — replaces your manual HashMap grouping
Map<String, List<Student>> bySubject = students.stream()
    .collect(Collectors.groupingBy(Student::getSubject));
```
### forEach — perform action on each
```
students.stream().forEach(System.out::println);
// same as:
students.forEach(System.out::println);  // can skip .stream() for forEach
```
### count — count elements
```
long count = students.stream()
                     .filter(s -> s.getMarks() > 60)
                     .count();
```
### findFirst — get first element
```
Optional<Student> first = students.stream()
                                   .filter(s -> s.getMarks() > 90)
                                   .findFirst();
```
### anyMatch / allMatch / noneMatch
```
boolean anyPassed  = students.stream().anyMatch(s -> s.getMarks() >= 60);
boolean allPassed  = students.stream().allMatch(s -> s.getMarks() >= 60);
boolean noneFailed = students.stream().noneMatch(s -> s.getMarks() < 60);
```
### min / max
```
Optional<Student> topper = students.stream()
    .max(Comparator.comparingDouble(Student::getMarks));
```
### reduce — combine all elements into one value
```
// Sum all marks
double total = students.stream()
                       .mapToDouble(Student::getMarks)
                       .sum();

// Or with reduce:
Optional<Double> total = marks.stream()
                              .reduce((a, b) -> a + b);
// or:
double total = marks.stream().reduce(0.0, Double::sum);
```

## COLLECTORS — ADVANCED
```
// Group by subject
Map<String, List<Student>> bySubject = students.stream()
    .collect(Collectors.groupingBy(Student::getSubject));

// Count per subject
Map<String, Long> countPerSubject = students.stream()
    .collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()));

// Average marks per subject
Map<String, Double> avgPerSubject = students.stream()
    .collect(Collectors.groupingBy(
        Student::getSubject,
        Collectors.averagingDouble(Student::getMarks)
    ));

//Group by subject → get only the names per subject
Map<String, List<String>> groupBySubject = students.stream()
        .collect((Collectors.groupingBy(Student::getSubject, Collectors.mapping(Student::getName, Collectors.toList()))));

//Group by subject → get the top scorer per subject 
Map<String, Optional<Student>> groupBySubjectTopScorer = students.stream()
        .collect(Collectors.groupingBy(Student::getSubject, Collectors.maxBy(Comparator.comparingDouble(Student::getMarks))));
        
// Join strings
String names = students.stream()
                       .map(Student::getName)
                       .collect(Collectors.joining(", "));
// "Alice, Bob, Charlie"
```

## BEFORE vs AFTER
```
// Get names of students scoring above 80 — sorted alphabetically

// Loop way
List<String> result = new ArrayList<>();
for (Student s : students) {
    if (s.getMarks() > 80) {
        result.add(s.getName());
    }
}
Collections.sort(result);

// Stream way — one pipeline
List<String> result = students.stream()
    .filter(s -> s.getMarks() > 80)
    .map(Student::getName)
    .sorted()
    .collect(Collectors.toList());
```
```
// Group by subject and count — loop way
HashMap<String, Integer> count = new HashMap<>();
for (Student s : students) {
    count.put(s.getSubject(), count.getOrDefault(s.getSubject(), 0) + 1);
}

// Stream way
Map<String, Long> count = students.stream()
    .collect(Collectors.groupingBy(Student::getSubject, Collectors.counting()));
```
### Optional
Many stream operations return Optional<T> — a container that may or may not have a value. Avoids NullPointerException.
Any time you have Optional<T> → never println directly. Always unwrap first:
```
Optional<Student> topper = students.stream()
                                    .max(Comparator.comparingDouble(Student::getMarks));

// Check and use safely
if (topper.isPresent()) {
    System.out.println(topper.get());
}

// Or with ifPresent
topper.ifPresent(s -> System.out.println(s));

// Or with orElse — provide default
Student result = topper.orElse(new Student("None", "N/A", 0));
```
- .ifPresent(System.out::println)              // if you just want to print
- .get()                                       // if you're sure it exists
- .orElse(defaultValue)                        // if it might be empty
- .isPresent() ? .get() : "fallback"          // conditional print