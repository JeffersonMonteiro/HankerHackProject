package ChallengesDay3.exercise2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        // Write your code here
        int quantityTorre1 = m;
        int quantityTorre2 = m;
        int jogada = m-1;
        int winner = 0;


        if(n>1){

            do{
                if( quantityTorre1 % jogada ==1){
                    quantityTorre1 -= jogada;

                    if(quantityTorre1<0){
                        winner = 1;
                        break;
                    }
                }else{
                    if(quantityTorre1 != 1){
                        quantityTorre1 -= jogada;
                    }else{
                        winner = 2;
                        break;
                    }
                }


                if(  quantityTorre2 % jogada ==1){
                    quantityTorre2 -= jogada;
                    if(quantityTorre2<0){
                        winner = 2;
                        break;
                    }
                }else{
                    if(quantityTorre2 != 1){
                        quantityTorre2 -= jogada;
                    }else{
                        winner = 1;
                        break;
                    }
                }


            }while(quantityTorre1>=1 && quantityTorre2>=1);



        }else{

            do{
                if( quantityTorre1 % jogada ==1){
                    quantityTorre1 -= jogada;

                    if(quantityTorre1 < 0){
                        winner = 1;
                        break;
                    }

                }else{
                    if(quantityTorre1 != 1){
                        quantityTorre1 -= jogada;
                    }else{
                        winner = 2;
                        break;
                    }
                }
            }while(quantityTorre1>=1);
        }
        return winner;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
*/
        System.out.println(Result.towerBreakers(1, 7));

        System.out.println(Result.towerBreakers(3, 7));

    }
}
