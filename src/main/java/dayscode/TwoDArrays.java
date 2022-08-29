package dayscode;

import javax.swing.*;
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



public class TwoDArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> listHourglass =  new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );






            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int[][] myArray = (int[][]) arr.toArray();
        int max_sum = 0;

        for(int w = 0; w < 4; w++) {
            for(int j = 0; j < 4; j++) {

                int temp_sum = 0;
                // top row
                temp_sum += myArray[w][j];
                temp_sum += myArray[w][j+1];
                temp_sum += myArray[w][j+2];
                //middle
                temp_sum += myArray[w+1][j+1];
                //bottom row
                temp_sum += myArray[w+2][j];
                temp_sum += myArray[w+2][j+1];
                temp_sum += myArray[w+2][j+2];

                //if first hourglass, set as max
                if(temp_sum > max_sum){
                    max_sum = temp_sum;///this will keep it up to date
                }
            }
        }


        bufferedReader.close();
    }
}
