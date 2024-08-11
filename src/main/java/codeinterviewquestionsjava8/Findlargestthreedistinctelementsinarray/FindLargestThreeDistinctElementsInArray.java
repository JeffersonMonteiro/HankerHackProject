package codeinterviewquestionsjava8.Findlargestthreedistinctelementsinarray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindLargestThreeDistinctElementsInArray {

    public static void main(String[] args) {
        List<Integer> listIntegers = Arrays.asList(45, 69, 21, 36, 45, 95, 36, 21, 36, 458, 3659, 145, 1154);
        System.out.println(findMax3(listIntegers));

    }

    public static List<Integer> findMax3(List<Integer> list) {
        return list.stream().sorted((x, y) -> y.compareTo(x)).distinct().limit(3).collect(Collectors.toList());
    }
}
