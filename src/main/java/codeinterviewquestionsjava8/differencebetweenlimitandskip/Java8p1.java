package codeinterviewquestionsjava8.differencebetweenlimitandskip;

import java.util.stream.Stream;

public class Java8p1 {
    public static void main(String[] args) {
        Stream.of(0,1,2,3,4,5,6,7,8)
                .limit(6)
                /*limit is set to 6, hence it will print the
                numbers starting from 0 to 5
                */
                .forEach(num ->System.out.print("\n"+num));
    }
}
