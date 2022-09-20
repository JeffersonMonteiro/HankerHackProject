package codeinterviewquestionsjava8.differencebetweenIntermediateandTerminalOperations;

import java.util.Arrays;

public class Java8 {
    public static void main(String[] args) {
        System.out.println("Intermediate Operation won't execute");
        Arrays.stream(new int[] { 0, 1 }).map(i -> {
            System.out.println(i);
            return i;
            // No terminal operation so it won't execute
        });

        System.out.println("Terminal operation starts here");
        Arrays.stream(new int[] { 1, 2 }).map(i -> {
            System.out.println(i);
            return i;
            // This is followed by terminal operation sum()
        }).sum();
    }
}
