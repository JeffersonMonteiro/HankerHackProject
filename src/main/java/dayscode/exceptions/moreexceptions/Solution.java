package dayscode.exceptions.moreexceptions;

import java.util.*;
import java.io.*;

//Write your code here
class Calculator{

    public int power(int n, int p){
        double result =0;
        try{

            if(n< 0 || p<0 ){
                throw new Exception();
            }else{
                result =  Math.pow(n, p);
            }
        }catch(Exception e){
            throw new NumberFormatException("n and p should be non-negative");
        }
        return (int)result;
    }

}

class Solution{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}

