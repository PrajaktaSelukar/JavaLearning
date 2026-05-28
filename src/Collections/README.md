# PHASE 3 — Collections + DSA Foundations
## STEP 1. ArrayList
```
import java.util.ArrayList;

ArrayList<String> names = new ArrayList<>();

// Adding
names.add("Alice");           // adds to end
names.add("Bob");
names.add(0, "Zara");         // adds at index 0, shifts others

// Accessing
names.get(0);                 // "Zara"
names.size();                 // 3 — not length, size() ✅

// Updating
names.set(1, "Charlie");      // replaces index 1

// Removing
names.remove("Bob");          // remove by value
names.remove(0);              // remove by index

// Checking
names.contains("Alice");      // true/false
names.isEmpty();              // true/false
names.indexOf("Alice");       // returns index, -1 if not found

// Iterating
for (String name : names) {
    System.out.println(name);
}

// Clear
names.clear();                // empties the list
```
## STEP 2. HashMap
- hashing
- collisions
- buckets
```
import java.util.HashMap;

HashMap<String, Integer> scores = new HashMap<>();

// Adding
scores.put("Alice", 95);
scores.put("Bob", 87);
scores.put("Charlie", 92);

// Accessing
scores.get("Alice");              // 95
scores.get("Unknown");            // null — key doesn't exist

// Safe access with default
scores.getOrDefault("Unknown", 0); // 0 instead of null

// Checking
scores.containsKey("Bob");        // true
scores.containsValue(95);         // true
scores.size();                    // 3

// Updating
scores.put("Bob", 90);            // overwrites existing key

// Removing
scores.remove("Charlie");

// Iterating — three ways
// 1. Keys only
for (String key : scores.keySet()) {
    System.out.println(key);
}

// 2. Values only
for (int value : scores.values()) {
    System.out.println(value);
}

// 3. Both key and value — most common
for (Map.Entry<String, Integer> entry : scores.entrySet()) {
    System.out.println(entry.getKey() + " → " + entry.getValue());
}
```
## STEP 3. HashSet
```
import java.util.HashSet;

HashSet<String> cities = new HashSet<>();

// Adding
cities.add("Mumbai");
cities.add("Delhi");
cities.add("Mumbai");    // duplicate — silently ignored

cities.size();           // 2, not 3

// Checking
cities.contains("Delhi");  // true

// Removing
cities.remove("Delhi");

// Iterating
for (String city : cities) {
    System.out.println(city);  // order not guaranteed
}
```
## STEP 4. Queue
- Queue
```
import java.util.Queue;
import java.util.LinkedList;

Queue<String> queue = new LinkedList<>();

// Adding — to back
queue.add("Alice");       // throws exception if full
queue.offer("Bob");       // returns false if full — safer ✅
queue.offer("Charlie");

// Peeking — look at front without removing
queue.peek();             // "Alice" — null if empty
queue.element();          // "Alice" — throws exception if empty

// Removing — from front
queue.poll();             // removes and returns "Alice" — null if empty ✅
queue.remove();           // removes and returns — throws exception if empty

// Check
queue.size();             // 2
queue.contains("Bob");    // true
queue.isEmpty();          // false

// Iterating
for (String s : queue) {
    System.out.println(s);
}
```
- Deque
```
import java.util.Deque;
import java.util.ArrayDeque;

Deque<String> deque = new ArrayDeque<>();

// Add to front or back
deque.addFirst("Alice");
deque.addLast("Bob");
deque.offerFirst("Zara");   // safe version

// Remove from front or back
deque.pollFirst();          // removes front — safe ✅
deque.pollLast();           // removes back  — safe ✅

// Peek front or back
deque.peekFirst();          // look at front
deque.peekLast();           // look at back
```
- PriorityQueue
```
import java.util.PriorityQueue;

PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.offer(40);
pq.offer(10);
pq.offer(30);
pq.offer(20);

// Peek — always the smallest
pq.peek();    // 10 — doesn't remove

// Poll — removes smallest each time
pq.poll();    // 10
pq.poll();    // 20
pq.poll();    // 30
pq.poll();    // 40
```
- Max PriorityQueue
```
// Pass Collections.reverseOrder() to flip it
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

maxPQ.offer(40);
maxPQ.offer(10);
maxPQ.offer(30);

maxPQ.poll();   // 40 — largest first
```
- PriorityQueue with objects
```
// Sort students by marks — lowest marks first
PriorityQueue<Student> pq = new PriorityQueue<>(
    (a, b) -> a.marks - b.marks   // comparator — explained in section 6
);
```
## STEP 5. Stack
- Stack - old class
```
import java.util.Stack;

Stack<String> stack = new Stack<>();

// Push — add to top
stack.push("A");
stack.push("B");
stack.push("C");

// Peek — look at top without removing
stack.peek();     // "C"

// Pop — remove from top
stack.pop();      // "C"
stack.pop();      // "B"

// Check
stack.isEmpty();  // false
stack.size();     // 1
stack.contains("A");  // true
```
- ArrayDeque - preferred modern stack
```
Deque<String> stack = new ArrayDeque<>();
stack.push("A");    // addFirst
stack.pop();        // removeFirst
stack.peek();       // peekFirst
```
## STEP 6. Comparable vs Comparator
- Both are used for sorting objects. This is where custom sorting lives.
### Comparable — "I know how to compare myself"
```
public class Student implements Comparable<Student> {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name  = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return this.marks - other.marks;  // sort by marks ascending
        // negative → this comes first
        // zero     → equal
        // positive → other comes first
    }
}

// Now this works:
Collections.sort(students);   // ✅ sorts by marks ascending
```
### Comparator — "Someone else defines the sort order"
```
import java.util.Comparator;

// Sort by name alphabetically
Comparator<Student> byName = new Comparator<Student>() {
    @Override
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
};

// Sort by marks descending
Comparator<Student> byMarksDesc = new Comparator<Student>() {
    @Override
    public int compare(Student a, Student b) {
        return b.marks - a.marks;
    }
};

Collections.sort(students, byName);       // sort by name
Collections.sort(students, byMarksDesc);  // sort by marks desc
```
### Lambda shorthand — cleaner syntax
```
// Same thing, much shorter
Collections.sort(students, (a, b) -> a.name.compareTo(b.name));
Collections.sort(students, (a, b) -> b.marks - a.marks);

// Or with list.sort():
students.sort((a, b) -> a.name.compareTo(b.name));
students.sort((a, b) -> b.marks - a.marks);
```
### Comparator utility methods — cleanest syntax
```
// Sort by single field
students.sort(Comparator.comparingInt(s -> s.marks));

// Sort descending
students.sort(Comparator.comparingInt((Student s) -> s.marks).reversed());

// Sort by multiple fields — name first, then marks
students.sort(Comparator.comparing((Student s) -> s.name)
                        .thenComparingInt(s -> s.marks));
```
## STEP 7. GENERICS
```
// Without generics (old way) — unsafe
ArrayList list = new ArrayList();
list.add("hello");
list.add(123);           // ❌ mixed types — compiles but crashes at runtime

// With generics — safe
ArrayList<String> list = new ArrayList<>();
list.add("hello");       // ✅
list.add(123);           // ❌ compile error — caught immediately
```
## STEP 8. COLLECTIONS UTILITY CLASS
```
import java.util.Collections;

ArrayList<Integer> nums = new ArrayList<>();
nums.add(3); nums.add(1); nums.add(4); nums.add(1); nums.add(5);

Collections.sort(nums);         // [1, 1, 3, 4, 5]
Collections.reverse(nums);      // [5, 4, 3, 1, 1]
Collections.shuffle(nums);      // random order
Collections.max(nums);          // 5
Collections.min(nums);          // 1
Collections.frequency(nums, 1); // 2 — count of value 1
```
## STEP 8. CONVERTING BETWEEN ARRAY AND ARRAYLIST
```
// Array → ArrayList
String[] arr = {"Alice", "Bob", "Charlie"};
ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));  // ✅

// ArrayList → Array
String[] back = list.toArray(new String[0]);  // ✅
```
## STEP 9. CHOOSING THE RIGHT COLLECTION
- Need ordered list with duplicates?     → ArrayList
- Need key-value lookup?                 → HashMap
- Need unique values only?               → HashSet
- Need sorted list?                      → Collections.sort() on ArrayList
- Need sorted map by key?                → TreeMap
- Need to count frequencies?             → HashMap<String, Integer>
