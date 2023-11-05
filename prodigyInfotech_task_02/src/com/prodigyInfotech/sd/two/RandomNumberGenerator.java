package com.prodigyInfotech.sd.two;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the randomly generated number between 1 and 50.");
        System.out.println("NOTE : you have 25 attempts :");

        int userGuess, generatedNumber;
        int maxAttempts = 25;
        int countWon = 0, countLost = 0;

        do {
            generatedNumber = random.nextInt(50) + 1;

            System.out.print("Enter your guess (or enter 0 to quit): ");

            if (scan.hasNextInt()) {
                userGuess = scan.nextInt();

                if (userGuess == 0) {
                    System.out.println("Thanks for playing! You made " + countLost + " attempt(s).");
                    break;
                }

                if (userGuess >= 1 && userGuess <= 50) {
                    System.out.println("Generated Number: " + generatedNumber);

                    if (userGuess == generatedNumber) {
                        System.out.println("Congratulations! Your guess is correct.");
                        System.out.println("Attempts to win: " + ++countWon);
                        break; 
                    } else {
                        System.out.println("Your guess is incorrect. Try again!");
                        countLost++;
                    }
                } else {
                    System.out.println("Enter a number between 1 and 50.");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                scan.next(); 
            }

            System.out.println("Attempts remaining: " + --maxAttempts);
            System.out.println();
        } while (maxAttempts > 0);

        if (countWon == 0 && countLost == 25) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + generatedNumber + ".");
        }

        scan.close();
    }
}
