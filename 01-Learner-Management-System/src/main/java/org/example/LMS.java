package org.example;

import java.util.Scanner;

public class LMS {

    public static String[] names = new String[10];
    public static int[] ages = new int[10];
    public static int[] xps = new int[10];
    public static int count = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addLearner();
                    break;
                case 2:
                    displayAllLearners();
                    break;
                case 3:
                    calculateAvearageXp();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select between 1 and 4.");
            }
        }

    }


    public static void addLearner() {

        System.out.println("Enter name:");
        String name = sc.nextLine();

        System.out.println("Enter age:");
        int age = sc.nextInt();


        System.out.println("Enter the XP:");
        int xp = sc.nextInt();
        sc.nextLine();


        // Age validation
        if (age >= 18 && age <= 100) {
            names[count] = name;
            ages[count] = age;
            xps[count] = xp;
            count++;

            System.out.println("✓ Learner added successfully!");
        } else {
            System.out.println(
                    "✗ Invalid age. Age must be between 18 and 100.");
        }

    }

    public static void displayAllLearners() {
        if (count == 0) {
            System.out.println("No learners added yet.");
            return;
        }
        System.out.println("\n--- Learner List ---");

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + names[i] + "| Age :" + ages[i] + "| Xp :" + xps[i]);
        }

    }

    public static void calculateAvearageXp() {
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += xps[i];
        }
        double avg = (double) sum / count;
        System.out.printf("Average XP: %.2f%n", avg);

    }

    public static void displayMenu() {
        System.out.println("\n===== Airtribe Learner Manager =====");
        System.out.println("1. Add Learner");
        System.out.println("2. Display All Learners");
        System.out.println("3. Calculate Average XP");
        System.out.println("4. Exit");
        System.out.println("Select: _");

    }
}