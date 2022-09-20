package codeinterviewquestionsjava8.print5randomnumbersusingforEachinJava8;

import java.util.Random;

public class Java8 {
    public static void main(String[] args) {

        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);
        /* limit is set to 5 which means only 5 numbers will be printed
        with the help of terminal operation forEach
        */
        System.out.println("--------------------------------------------");
        Random random2 = new Random();
        random2 .ints().limit(5).sorted().forEach(System.out::println);

    }
}
