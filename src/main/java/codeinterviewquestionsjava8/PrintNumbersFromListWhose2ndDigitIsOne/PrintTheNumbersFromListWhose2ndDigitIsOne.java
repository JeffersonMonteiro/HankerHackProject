package codeinterviewquestionsjava8.PrintNumbersFromListWhose2ndDigitIsOne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintTheNumbersFromListWhose2ndDigitIsOne {

    public static void main(String[] args) {
        int[] intArray = new int[]{1, 8, 2123, 612, 51, 2345, 2158};

        String[] result = IntStream.of(intArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")).split(",");

        List<String> listStrings = Arrays.asList(result).stream()
                .filter(l -> l.length() > 1)
                .filter(l -> l.charAt(1) == '1')
                .collect(Collectors.toList());

        listStrings.forEach(System.out::println);

    }
}
