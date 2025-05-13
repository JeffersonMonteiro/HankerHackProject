package codeinterviewquestions.stringoperations;

import java.util.*;

public class StringOperations {
    //
//    Q148. Write a program in Java to Toggle the case of every character of a string. For instance,
//    if the input string is “ApPLe”, the output should be “aPplE”.
    public static String toggleCase(String input) {

        StringBuilder result = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (Character.isUpperCase(c)) {

                result.append(Character.toLowerCase(c));

            } else if (Character.isLowerCase(c)) {

                result.append(Character.toUpperCase(c));

            } else {

                result.append(c);
            }
        }
        return result.toString();
    }

    //    Q149. Write a program in Java to count the total number of vowels and consonants in a String.
//    The string can contain all the alphanumeric and other special characters as well.
//        However, only the lowercase English alphabets are allowed in the String.
    public static void countVowelsAndConsonants(String input) {

        int vowelCount = 0;

        int consonantCount = 0;

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            // Check if the character is a lowercase alphabet

            if (c >= 'a' && c <= 'z') {

                if (isVowel(c)) {

                    vowelCount++;

                } else {

                    consonantCount++;

                }

            }

        }

        System.out.println("Total number of vowels: " + vowelCount);

        System.out.println("Total number of consonants: " + consonantCount);

    }

    public static boolean isVowel(char c) {
        // Check if the character is a vowel
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

//    Q150. Write a program to print all the unique characters in a String. For instance,
//    if the input string is “abcb”, the output will be the characters ‘a’ and ‘c’ as they are unique.
//    The character ‘b’ repeats twice and so it will not be printed.
    public static void printUniqueCharacters(String input) {

        // Create a HashMap to store the frequency of each character

        Map<Character, Integer> charCountMap = new HashMap<>();

        // Iterate through the input string and populate the HashMap

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);

        }

        // Create a StringBuilder to store the unique characters

        StringBuilder uniqueChars = new StringBuilder();

        // Iterate through the HashMap and find characters with frequency 1

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {

            if (entry.getValue() == 1) {

                uniqueChars.append(entry.getKey());

            }

        }

        // Print the unique characters

        System.out.println("Unique characters: " + uniqueChars.toString());

    }

    public static String isPalindrome(String sentence) {
        // Convert the sentence to lowercase
        sentence = sentence.toLowerCase();

        // Remove all characters that are not alphanumeric
        String filteredSentence = sentence.replaceAll("[^a-z0-9]", "");

        // Check if the filtered sentence is a palindrome
        if (filteredSentence.equals(new StringBuilder(filteredSentence).reverse().toString())) {
            return "true";
        } else {
            return "false";
        }
    }

//    Q160. Add two Binary Strings and return a Binary String as a result. The addition should be performed as per the rules of binary addition.
//    To add two binary strings and return the result as a binary string, we can follow these steps:
//
//    Initialize Variables:
//    Create variables to store the carry and the result.
//    Set i and j to point to the last characters of the two binary strings.

//    Iterate from Right to Left:
//    Use a loop to iterate from the end of both strings towards the beginning.
//    At each step, add the corresponding bits along with the carry.

//    Calculate Sum and Carry:
//    The sum of two binary digits (a and b) and a carry (c) can be calculated as follows:
//    total_sum = int(a) + int(b) + carry
//    The new bit to add to the result is total_sum % 2.
//    The new carry is total_sum // 2.

//    Handle Remaining Carry:
//    If there is a carry left after the loop, add it to the result.
//    Construct the Result:
//    The result is constructed in reverse order, so reverse it before returning.


//    Explanation of Example:
//
//    Given binary strings 1101 and 1011.
//    We start from the rightmost bit:
//            1 + 1 = 10 (binary), write down 0, carry 1.
//            0 + 1 + 1 (carry) = 10 (binary), write down 0, carry 1.
//            1 + 0 + 1 (carry) = 10 (binary), write down 0, carry 1.
//            1 + 1 (carry) = 10 (binary), write down 0, carry 1.
//    After finishing the addition, we have an extra carry 1.
//    The final result is 11000 after reversing the constructed result.
//    This method ensures that the binary addition is performed accurately, following the rules of binary arithmetic.

    public static String addBinaryStrings(String a, String b) {
        ArrayList<String> result = new ArrayList<>();
        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int totalSum = carry;

            if (i >= 0) {
                totalSum += Character.getNumericValue(a.charAt(i));
                i--;
            }
            if (j >= 0) {
                totalSum += Character.getNumericValue(b.charAt(j));
                j--;
            }

            // Append the current bit to the result
            result.add(String.valueOf(totalSum % 2));

            // Update the carry
            carry = totalSum / 2;
        }

        // Since we've constructed the result in reverse order, reverse it back
        Collections.reverse(result);
        return String.join("", result);
    }

    //Q161. You are given 2 strings as input. You have to check whether they are anagrams or not.
    public static boolean areAnagrams(String str1, String str2) {
        // Step 1: Convert both strings to lowercase to handle case insensitivity
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Step 2: Check if the lengths of both strings are the same
        if (str1.length() != str2.length()) {
            return false;
        }

        // Step 3: Create HashMaps to count the occurrences of each character
        HashMap<Character, Integer> charCount1 = new HashMap<>();
        HashMap<Character, Integer> charCount2 = new HashMap<>();

        // Count characters for the first string
        for (char c : str1.toCharArray()) {
            charCount1.put(c, charCount1.getOrDefault(c, 0) + 1);
        }

        // Count characters for the second string
        for (char c : str2.toCharArray()) {
            charCount2.put(c, charCount2.getOrDefault(c, 0) + 1);
        }

        // Step 4: Compare the two HashMaps
        return charCount1.equals(charCount2);
    }

    public static void main(String[] args) {

        String input = "ApPLe";
        String toggled = toggleCase(input);
        System.out.println("Original String: " + input);
        System.out.println("Toggled String: " + toggled);

        String input2 = "hello world!";
        countVowelsAndConsonants(input2);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String userInput = scanner.nextLine();

        // Print whether the sentence is a palindrome or not
        System.out.println(isPalindrome(userInput));

        System.out.println(addBinaryStrings("1101" , "1011"));


        String str1 = "anagram";
        String str2 = "nagrama";
        System.out.println(areAnagrams(str1, str2)); // Output: true

    }
}
