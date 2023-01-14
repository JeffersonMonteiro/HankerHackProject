package ChallengesDay1.exercise2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        List<Long> arrSomasResult = new ArrayList<>();
        List<Integer> arrSomasCopy = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {

            prepareSomaCopyArray(arr, arrSomasCopy, i);

            long soma = 0;
            for (int j = 0; j < arrSomasCopy.size(); j++) {
                soma = soma + arrSomasCopy.get(j);
            }
            arrSomasCopy = new ArrayList<>();
            arrSomasResult.add(soma);
        }
        System.out.println(Collections.min(arrSomasResult) + " " + Collections.max(arrSomasResult));
    }

    private static void prepareSomaCopyArray(List<Integer> arr, List<Integer> arrSomasCopy, int i) {
        for (int w = 0; w < arr.size(); w++) {
            arrSomasCopy.add(arr.get(w));
        }
        arrSomasCopy.remove(arr.get(i));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}

