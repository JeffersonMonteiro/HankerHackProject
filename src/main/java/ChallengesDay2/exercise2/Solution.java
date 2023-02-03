package ChallengesDay2.exercise2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */



    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int rightDiagonal = 0;
        int leftDiagonal = 0;
        int result =0;
        int count =0;

        for (List<Integer> elementList: arr) {
            for (int i =count; i< elementList.size(); i++){
                rightDiagonal += elementList.get(i);
                leftDiagonal += elementList.get((elementList.size()-1)-i);
                count++;
                break;
            }
        }

        result = Math.abs(rightDiagonal - leftDiagonal);

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        Integer [] array_1 = new Integer[3];
        List<Integer> listname1 = new ArrayList<>();

        List<List<Integer>> arr = new ArrayList<>();
        array_1 = new Integer[]{11, 2, 4};
        listname1 = Arrays.asList(array_1);
        arr.add(listname1);
        array_1 = new Integer[]{4, 5, 6};
        listname1 = Arrays.asList(array_1);
        arr.add(listname1);
        array_1 = new Integer[]{10, 8, -12};
        listname1 = Arrays.asList(array_1);
        arr.add(listname1);

        System.out.println(Result.diagonalDifference(arr));

    }
}
