package academy.javapro;

import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double gpa;
    String year;

    public Student(String name, double gpa, String year) {
        this.name = name;
        this.gpa = gpa;
        this.year = year;
    }

    @Override
    public String toString() {
        return name + " (" + year + ") - GPA: " + gpa;
    }
}

public class FunctionalProgramming {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Original numbers: " + numbers);

        // TASK 1: Filter even numbers and print them
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // Keeps only even numbers
                .collect(Collectors.toList()); // Collect results into a new list

        System.out.println("Even numbers: " + evenNumbers);

        // TASK 2: Double each number in the original list
        List<Integer> doubledNumbers = numbers.stream()
                .map(n -> n * 2) // Doubles each number
                .collect(Collectors.toList()); // Collect results into a new list

        // TASK 3: Sum all numbers in the doubled list
        int sum = doubledNumbers.stream()
                .mapToInt(n -> n) // Convert to IntStream
                .sum(); // Sum all elements

        System.out.println("Doubled numbers: " + doubledNumbers);
        System.out.println("Sum of doubled numbers: " + sum);

        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")
        );

        List<Student> highGpaStudents = students.stream()
                .filter(s -> s.gpa > 3.0)
                .collect(Collectors.toList());
        
        System.out.println("\nStudents with GPA > 3.0:");
        highGpaStudents.forEach(System.out::println);

        List<String> highGpaNames = highGpaStudents.stream()
                .map(s -> s.name)
                .collect(Collectors.toList());
        
        System.out.println("\nHigh GPA student names:");
        highGpaNames.forEach(System.out::println);

        double averageGpa = students.stream()
                .mapToDouble(s -> s.gpa)
                .average()
                .orElse(0.0);
        
        System.out.println("\nAverage GPA: " + String.format("%.2f", averageGpa));

        List<Student> juniorStudents = students.stream()
                .filter(s -> s.year.equals("Junior"))
                .collect(Collectors.toList());
        
        System.out.println("\nJuniors:");
        juniorStudents.forEach(System.out::println);
    }
}

