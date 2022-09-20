package codeinterviewquestionsjava8.differenceBetweenMapAndflatMapStreamOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] str) {
        List<String> Names = Arrays.asList("Saket", "Trevor", "Franklin", "Michael");

        List<String> UpperCase = Names.stream().map(String::toUpperCase).collect(Collectors.toList());
        // Changed the characters into upper case after converting it into Stream

        UpperCase.forEach(System.out::println);
        // Printed using forEach Terminal Operation
    }
}
