package dayscode.queuesandstacks;

import java.io.*;
import java.util.*;

public class Solution {
    // Write your code here.
    private String stackValue = "";
    private String queueValue = "";
    private int stackCount;
    private int queueCount;

    private void pushCharacter(char inputValue){
        stackValue += inputValue;
        stackCount++;
    }

    private void enqueueCharacter(char inputValue){
        queueValue += inputValue;
        queueCount++;
    }

    private char popCharacter(){
        char tempStack = stackValue.charAt(stackValue.length()- stackCount);
        stackCount--;
        return tempStack;
    }

    private char dequeueCharacter(){
        char tempQueue = queueValue.charAt(queueCount-1);
        queueCount--;
        return tempQueue;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Solution p = new Solution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}