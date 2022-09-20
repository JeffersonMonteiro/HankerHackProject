package codeinterviewquestionsjava8.squarelistofnumbersthenfilteroutnumbersgreaterthan100thenfindaverageremainingnumbers;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Java8 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 100, 100, 9, 8, 200 };
        List<Integer> list = Arrays.asList(arr);
        // Stored the array as list
        OptionalDouble avg = list.stream().mapToInt(n -> n * n).filter(n -> n > 100).average();

        /* Converted it into Stream and filtered out the numbers
            which are greater than 100. Finally calculated the average
        */

        if (avg.isPresent())
            System.out.println(avg.getAsDouble());
    }
}
