package codeinterviewquestions.countdigits;

//Q144. Write a Java program to count the number of digits in a number.
//If you want to create a Java program that tallies up the digits in a number,
//you can follow a straightforward approach.
//Start by repeatedly dividing the number by 10 until it reaches zero.
//Each time you divide, you essentially discard one digit from the number.

public class DigitCounter {
    public static void main(String[] args) {
 
       int number = 123456; // Example number
       int count = 0;
 
       while (number != 0) {
           number /= 10;  // Remove the last digit
           count++;       // Increment the count
       }
       System.out.println("Number of digits: " + count);
   }
}
