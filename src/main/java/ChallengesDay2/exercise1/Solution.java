package ChallengesDay2.exercise1;
import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here

        int equalNumber = 0;
        int countElement = 0;

       initial:  for (int i = 0; i < a.size(); i++) {
           for (int j = 0; j < a.size(); j++) {
               if (a.get(i).compareTo(a.get(j)) == 0) {
                   countElement++;
               }
               if(countElement ==2){
                   countElement =0;
                   continue initial;
               }
            }
           equalNumber = a.get(i);
        }
        return equalNumber;

    }

    public static void main(String[] args) throws IOException {
        Integer [] array_name = {1,2,3,4,3,2,1};

        List<Integer> listname = Arrays.asList(array_name);
        int result = Result.lonelyinteger(listname);

        System.out.println(result);


    }

}
