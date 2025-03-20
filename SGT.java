import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    // Algorithm to track student grades
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        
        System.out.println("Enter the number of students:");
        int numStudents = scanner.nextInt();
        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter grade for student " + (i + 1) + ":");
            int grade = scanner.nextInt();
            grades.add(grade);
        }
        
        scanner.close();
        
        processGrades(grades);
    }
    
    // Algorithm to compute highest, lowest, and average grades
    public static void processGrades(ArrayList<Integer> grades) {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        
        int highest = Collections.max(grades);
        int lowest = Collections.min(grades);
        double average = grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.println("Average Grade: " + average);
    }
    
    // Method to integrate with existing applications
    public static void addGrade(ArrayList<Integer> grades, int grade) {
        grades.add(grade);
        System.out.println("Grade added successfully.");
    }
}
