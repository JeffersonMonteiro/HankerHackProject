package codeinterviewquestionsjava8.iterateStreamusingforEachmethod;

import java.util.stream.Stream;

public class Java8 {
    public static void main(String[] args){
        Stream.iterate(2, count->count+1)

        // Counter Started from 2, incremented by 1

        .filter(number->number%2==0)

        // Filtered out the numbers whose remainder is zero
        // when divided by 2

        .limit(5)
                // Limit is set to 5, so only 5 numbers will be printed

                .forEach(System.out::println);
    }
}
