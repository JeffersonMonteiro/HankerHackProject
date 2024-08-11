package codeinterviewquestionsjava8.findduplicateelements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaHungry {
    public static void main(String args[]) {

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet();
        //Find duplicate Elements an print them
//        myList.stream()
//                .filter(n -> !set.add(n))
//                .forEach(System.out::println);

        //Don't print duplicated elements
        myList.stream()
                .filter(n -> set.add(n))
                .forEach(System.out::println);
    }
}
