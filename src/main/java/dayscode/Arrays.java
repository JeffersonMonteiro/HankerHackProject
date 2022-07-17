package dayscode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;



public class Arrays {
    public static void main(String[] args) throws IOException {
        StringBuilder reversedList = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Collections.reverse(arr);

        for (Integer item: arr) {
            reversedList.append(item+" ");
        }

        System.out.println(reversedList.toString());
        bufferedReader.close();
    }
}
