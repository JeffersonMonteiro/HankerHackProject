package ChallengesDay1.exercise1;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result{

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        int countPositiveNumbers = 0;
        int countNegativeNumbers = 0;
        int countZeroNumbers = 0;
        int proportion = arr.size();

        for (Integer item : arr) {
            if(item.intValue()<0){
                countNegativeNumbers++;
            }else if(item.intValue()>0){
                countPositiveNumbers++;
            }else{
                countZeroNumbers++;
            }
        }

        BigDecimal proportionResult = new BigDecimal(proportion);
        MathContext mc = new MathContext(6, RoundingMode.FLOOR);

        Number resultPositives = new BigDecimal(countPositiveNumbers).divide(proportionResult, mc);
        BigDecimal resultNegatives = new BigDecimal(countNegativeNumbers).divide(proportionResult, mc);
        BigDecimal resultZeros = new BigDecimal(countZeroNumbers).divide(proportionResult, mc);


        System.out.println(resultPositives.doubleValue());
        System.out.println(resultNegatives.doubleValue());
        System.out.println(resultZeros.doubleValue());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
