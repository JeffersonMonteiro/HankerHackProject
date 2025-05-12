package codeinterviewquestions.countdigits;

import java.util.Scanner;

//Q145. Write a Java program that counts how many times digit ‘D’ occurs within a given number ‘N’.
//You have to take N and D as inputs from the user.
//Here’s a Java program that takes a number ‘N’ and a digit ‘D’ as
//input from the user and counts how many times digit ‘D’ occurs within the given number ‘N’:

public class DigitCounterDForN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for N and D from the user

        System.out.print("Enter the number (N): ");

        long N = scanner.nextLong();

        System.out.print("Enter the digit (D): ");

        int D = scanner.nextInt();


        // Converting N to a string for easier manipulation

        String numberAsString = String.valueOf(N);


        // Counting the occurrences of D in N

        int count = 0;

        for (int i = 0; i < numberAsString.length(); i++) {

            if (numberAsString.charAt(i) - '0' == D) {

                count++;

            }
        }
        // Displaying the result

        System.out.println("The digit " + D + " occurs " + count + " times in the number " + N);

    }
}