package dayscode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Arrays2D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arrayList = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arrayList.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        //Converter LIst para array
        /*int[][] arr = list.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        System.out.println(Arrays.deepToString(arr));*/

        System.out.println(getMaxhourglasse(arrayList));
        bufferedReader.close();
    }

    private static int getMaxhourglasse(List<List<Integer>> arrayList) {
        int sum = 0;
        int maxSum = 0;

        for (int row = 0; row < arrayList.size() ; row++) {
            for (int col = 0; col < arrayList.get(row).size()  ; col++) {
                try{
                    sum = arrayList.get(row).get(col) + arrayList.get(row).get(col + 1) + arrayList.get(row).get(col + 2);
                    sum += arrayList.get(row + 1).get(col + 1);
                    sum += arrayList.get(row + 2).get(col) + arrayList.get(row + 2).get(col + 1) + arrayList.get(row + 2).get(col + 2);

                    if (row == 0 && col == 0) {
                        maxSum = sum; //assume max sum is found in the first iteration
                    }

                    maxSum = Math.max(sum, maxSum);

                }catch(IndexOutOfBoundsException e){
                }
            }
        }

        return maxSum;
    }



}
