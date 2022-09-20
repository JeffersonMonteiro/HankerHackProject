package codeinterviewquestionsjava8.evennumbersusingstreams;

import java.util.Arrays;
import java.util.List;

public class JavaHungry {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        myList.stream()
                .filter(n -> n%2 == 0)
                .forEach(System.out::println);
    }
}
