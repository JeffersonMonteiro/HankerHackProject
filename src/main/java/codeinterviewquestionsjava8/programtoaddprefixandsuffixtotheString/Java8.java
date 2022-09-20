package codeinterviewquestionsjava8.programtoaddprefixandsuffixtotheString;

import java.util.StringJoiner;

public class Java8 {
    public static void main(String[] args) {

        StringJoiner stj = new StringJoiner(",", "(", ")");

        // Separated the elements with a comma in between.
        //Added a prefix "(" and a suffix ")"

        stj.add("Saket");
        stj.add("John");
        stj.add("Franklin");
        stj.add("Ricky");
        stj.add("Trevor");

        // Added elements into StringJoiner “stj”

        System.out.println(stj);
    }
}
