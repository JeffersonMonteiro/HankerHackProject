package codeinterviewquestionsjava8.findlowestandhighestnumberofStream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Java8 {
    public static void main(String args[]) {

        Integer highest = Stream.of(1, 2, 3, 77, 6, 5)
                .max(Comparator.comparing(Integer::valueOf))
                .get();

    /* We have used max() method with Comparator.comparing() method
       to compare and find the highest number
    */

        Integer lowest = Stream.of(1, 2, 3, 77, 6, 5)
                .min(Comparator.comparing(Integer::valueOf))
                .get();

    /* We have used max() method with Comparator.comparing() method
       to compare and find the highest number
    */

        System.out.println("The highest number is: " + highest);
        System.out.println("The lowest number is: " + lowest);
    }
}
