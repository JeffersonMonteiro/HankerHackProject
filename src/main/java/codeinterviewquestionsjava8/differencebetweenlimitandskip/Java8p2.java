package codeinterviewquestionsjava8.differencebetweenlimitandskip;

import java.util.stream.Stream;

public class Java8p2 {
    public static void main(String[] args) {
        Stream.of(0,1,2,3,4,5,6,7,8)
                .skip(6)
                /*
                 It will skip till 6th index. Hence 7th, 8th and 9th
                 index elements will be printed
                 */
                .forEach(num->System.out.print("\n"+num));
    }
}
