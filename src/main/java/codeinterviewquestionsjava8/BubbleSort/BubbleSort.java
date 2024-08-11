package codeinterviewquestionsjava8.BubbleSort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
//https://www.baeldung.com/java-bubble-sort
public class BubbleSort {

    void bubbleSort(Integer[] arr) {
        int n = arr.length;
        IntStream.range(0, n - 1)
                .flatMap(i -> IntStream.range(1, n - i))
                .forEach(j -> {
                    if (arr[j - 1] > arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                });
    }

    public static void main(String[] args) {
        Integer[] array = { 2, 1, 4, 6, 3, 5 };
        Integer[] sortedArray = { 1, 2, 3, 4, 5, 6 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);

        List<Integer> list = Arrays.asList(array);
        list.forEach(System.out::println);
    }
}
