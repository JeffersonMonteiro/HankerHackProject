package codeinterviewquestionsjava8.findnumbersstartingwith1using;

import java.util.Arrays;
import java.util.List;

public class JavaHungry {
    public static void main(String args[]) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        myList.stream()
                .map(s -> s + "") // Convert integer to String
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);
    }
}
